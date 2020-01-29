package com.company.Model.entity;

public class CarEnt {

    private Long id;
    private String name;
    private String model;
    private int year;
    private String color;

    public Long getId() {
        return id;
    }

    public CarEnt setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CarEnt setName(String name) {
        this.name = name;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarEnt setModel(String model) {
        this.model = model;
        return this;
    }

    public int getYear() {
        return year;
    }

    public CarEnt setYear(int year) {
        this.year = year;
        return this;
    }

    public String getColor() {
        return color;
    }

    public CarEnt setColor(String color) {
        this.color = color;
        return this;
    }
}
