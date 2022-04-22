package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Topic;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicDTO {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime dateTime;

    public TopicDTO(Topic topic){
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.dateTime = topic.getCreationDate();
    }

    public static Page<TopicDTO> convertir(Page<Topic> topics) {
        return topics.map(TopicDTO::new);
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
}
