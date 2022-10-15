package org.acme.dto;

public class Developer {

    static Long counter = 1L;

    private long id;
    private String name;

    public void persist(){
        this.id = counter++;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
