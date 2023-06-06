package com.trabalhobd.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Agent {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String version;
    private String agentOrigin;

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

    public String getAgentOrigin() {
        return agentOrigin;
    }

    public void setAgentOrigin(final String agentOrigin) {
        this.agentOrigin = agentOrigin;
    }
}
