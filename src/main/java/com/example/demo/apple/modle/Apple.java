package com.example.demo.apple.modle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Apple {
    @JsonProperty("colour")
    private String colour;
    @JsonProperty("weight")
    private double weight;
    @JsonProperty("name")
    private String name;
    @JsonProperty
    private String id;

    public Apple setColour(String colour) {
        this.colour = colour;
        return this;
    }

    public Apple setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public Apple setName(String name) {
        this.name = name;
        return this;
    }


    public String getColour() {
        return colour;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
