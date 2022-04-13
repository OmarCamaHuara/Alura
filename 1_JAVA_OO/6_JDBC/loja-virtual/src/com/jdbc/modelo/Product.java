package com.jdbc.modelo;

public class Product {

    private Integer id;
    private String nome;
    private String description;

    Product(String nome, String description){
        this.nome = nome;
        this.description = description;
    }

    public Product(int id, String name, String description){
        this.id = id;
        this.nome = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return String.format("The product is: %d, %s, %s",
                this.id, this.nome, this.description);
    }
}
