package com.trabalhobd.backend.model;

import jakarta.persistence.*;

@Entity
public class Resistance {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String localization;
    private String leaderName;

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

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(final String localization) {
        this.localization = localization;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(final String leaderName) {
        this.leaderName = leaderName;
    }
}
