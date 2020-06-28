package com.vishnu.codaexrercise.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SavedResource {
    private int id;
    private String description;
    @JsonCreator
    public SavedResource(@JsonProperty("id") int id) {

        this.id = id;
        this.description=description;
    }

    public int getId() {
        return id;
    }

}
