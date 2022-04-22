package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Answere;
import br.com.alura.forum.modelo.Topic;
import br.com.alura.forum.modelo.TopicStatus;
import br.com.alura.forum.modelo.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesDoTopicDTO {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime dateTime;
    private String nameAuthor;
    private TopicStatus status;
    private List<AnswereDTO> answere;

    public DetalhesDoTopicDTO(Topic topic){
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.dateTime = topic.getCreationDate();
        this.nameAuthor = topic.getAuthor().getName();
        this.status = topic.getStatus();

        this.answere = new ArrayList<>();
        this.answere.addAll(topic
                .getAnswereList()
                .stream()
                .map(AnswereDTO::new)
                .collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public TopicStatus getStatus() {
        return status;
    }
}
