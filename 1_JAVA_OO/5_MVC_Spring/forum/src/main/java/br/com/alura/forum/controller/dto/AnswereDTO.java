package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Answere;

import java.time.LocalDateTime;

public class AnswereDTO {

    private Long id;
    private String message;
    private LocalDateTime creationDate;
    private String nameAuthor;

    public AnswereDTO(Answere answere){
        this.id = answere.getId();
        this.message = answere.getMessage();
        this.creationDate = answere.getCreationDate();
        this.nameAuthor = answere.getAuthor().getName();
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }
}
