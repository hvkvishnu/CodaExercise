package com.vishnu.codaexrercise.entity;

public class Notes {
    private Integer id;
    private String description;

    public Notes(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Notes( String description) {
        this(null, description);
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
