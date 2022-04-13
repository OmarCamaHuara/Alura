package com.company.dom.modelo;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private Integer id;
    private String name;
    private List<Curso> cursos = new ArrayList<>();

    public Category(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    @Override
    public String toString(){
        return this.name;
    }

    public void adicionar(Curso curso) {
        this.cursos.add(curso);
    }
}
