package com.trabalhobd.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Reality {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int population;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(final int population) {
        this.population = population;
    }
}
