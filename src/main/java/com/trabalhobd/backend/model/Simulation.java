package com.trabalhobd.backend.model;

import jakarta.persistence.*;

@Entity
public class Simulation {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String version;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }
}
