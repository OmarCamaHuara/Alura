package br.com.alura.forum.Repository;

import br.com.alura.forum.modelo.Topic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    List<Topic> findByCursoName(String nameCurso, Pageable pageable);
    //findByCurso_Name(String nameCurso)

    // Quando a gente precise de um nome que seja mas identificavel
//    @Query("SELECT t FROM Topic t WHERE t.curso.name = :nameCurso)
//    List<Topic> carregarPorNomeDoCurso(@Param("nameCurso") String nameCurso);
}
