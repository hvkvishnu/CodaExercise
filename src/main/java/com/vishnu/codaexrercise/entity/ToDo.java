package com.vishnu.codaexrercise.entity;

public class ToDo {
    private Integer id;
    private String description;


    public ToDo(Integer id, String description) {
        this.id = id;
        this.description = description;
    }
    public ToDo(String description) {
        this(null, description);
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
