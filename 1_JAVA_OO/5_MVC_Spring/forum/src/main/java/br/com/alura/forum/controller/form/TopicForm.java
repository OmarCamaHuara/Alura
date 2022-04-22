package br.com.alura.forum.controller.form;

import br.com.alura.forum.Repository.CursoRepository;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topic;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class TopicForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String title;
    @NotNull @NotEmpty @Length(min = 10)
    private String message;
    @NotNull @NotEmpty
    private String nameCurso;

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

    public String getNameCurso() {
        return nameCurso;
    }

    public void setNameCurso(String nameCurso) {
        this.nameCurso = nameCurso;
    }

    public Topic convert(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByName(nameCurso);
        return new Topic(title, message, curso);
    }
}
