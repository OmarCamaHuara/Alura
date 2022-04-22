package br.com.alura.forum.controller.form;

import br.com.alura.forum.Repository.TopicRepository;
import br.com.alura.forum.modelo.Topic;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class ApdateTopicForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String title;
    @NotNull @NotEmpty @Length(min = 10)
    private String message;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Topic updateDato(Long id, TopicRepository topicRepository) {
        Topic topic = topicRepository.getById(id);
        topic.setTitle(this.title);
        topic.setMessage(this.message);
        return topic;
    }
}
