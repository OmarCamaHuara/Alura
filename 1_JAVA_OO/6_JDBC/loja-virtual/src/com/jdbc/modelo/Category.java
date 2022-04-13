package com.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private Integer id;
    private String name;
    private List<Product> product = new ArrayList<>();

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Integer getId(){
        return this.id;
    }

    public void addProduct(Product product) {
        this.product.add(product);
    }
    public List<Product> getProduct() {
        return product;
    }
}
