package com.sergio.fastservice.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "restaurants")
public class RestaurantsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String ubication;

    public RestaurantsEntity() {
    }

    public RestaurantsEntity(Long id, String name, String ubication) {
        this.id = id;
        this.name = name;
        this.ubication = ubication;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }
}
