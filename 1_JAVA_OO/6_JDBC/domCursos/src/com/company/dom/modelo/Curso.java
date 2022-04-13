package com.company.dom.modelo;

public class Curso {
    private Integer id;
    private String name;
    private String description;
    private Integer idCategory;

    public Curso(String name, String description){
        super();
        this.name = name;
        this. description = description;
    }

    public Curso(Integer id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }
    @Override
    public String toString(){
        return String.format("O produto: %d, %s, %s", this.id, this.name, this.description);
    }
}
