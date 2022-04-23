package br.com.alura.forum.controller;

import br.com.alura.forum.Repository.CursoRepository;
import br.com.alura.forum.Repository.TopicRepository;
import br.com.alura.forum.controller.dto.DetalhesDoTopicDTO;
import br.com.alura.forum.controller.dto.TopicDTO;
import br.com.alura.forum.controller.form.ApdateTopicForm;
import br.com.alura.forum.controller.form.TopicForm;
import br.com.alura.forum.modelo.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CursoRepository cursoRepository;

    // @ResponseBody = agora va junto com ao Controller acima
    @GetMapping
    @Cacheable(value = "ListaDeTopics")
    public Page<TopicDTO> lista(@RequestParam(required = false) String nameCurso,
                                @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 2) Pageable pageable){
        if (nameCurso == null) {
            Page<Topic> topics = topicRepository.findAll(pageable);
            return TopicDTO.convertir(topics);
        }else{
            Page<Topic> topics = (Page<Topic>) topicRepository.findByCursoName(nameCurso, pageable);
            return TopicDTO.convertir(topics);
        }
    }

    // ResponseEntity<dto> = 201 class que divolve um dto - metodo estatico
    // UriComponentsBuilder = mandar como parametro
    // URI = objeto passar o caminho mas temo UriComp...
    // path = o que foi criado id dinamico
    // buildAndExpand(topic.getId) = para substutuir o id
    // toUri() = converte na uri completa localhost:80....
    // create(uri) = metodo do responseEntity
    // body(TopicDto(topic)) = mandar a resposta
    // tem que se devolver dois coisas
    // - cabecalho que acabou de ser criado
    // - corpo da resposta representacao do objeto que se crio

    @PostMapping
    @Transactional
    @CacheEvict(value = "ListaDeTopics", allEntries = true)
    public ResponseEntity<TopicDTO> cadastrar(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder){
        Topic topic = form.convert(cursoRepository);
        topicRepository.save(topic);
        // "/topics/{id}" = end-point mapeado
        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDTO(topic));
    }

    @GetMapping("/{id}")
    @CacheEvict(value = "ListaDeTopics", allEntries = true)
    public ResponseEntity<DetalhesDoTopicDTO> detalhar(@PathVariable Long id){
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent())
            return ResponseEntity.ok(new DetalhesDoTopicDTO(topic.get()));
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "ListaDeTopics", allEntries = true)
    public ResponseEntity<TopicDTO> apdate(@PathVariable Long id, @RequestBody @Valid ApdateTopicForm form){
        Optional<Topic> opcional = topicRepository.findById(id);
        if (opcional.isPresent()) {
            Topic topic = form.updateDato(id, topicRepository);
            return ResponseEntity.ok(new TopicDTO(topic));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "ListaDeTopics", allEntries = true)
    public ResponseEntity remove(@PathVariable Long id){
        Optional<Topic> opcional = topicRepository.findById(id);
        if (opcional.isPresent()) {
            topicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
