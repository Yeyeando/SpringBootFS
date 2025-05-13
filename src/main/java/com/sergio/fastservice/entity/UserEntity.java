package com.sergio.fastservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String role = "Camarero";

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private RestaurantsEntity restaurant;

    public UserEntity() {
    }

    public UserEntity(Long id, String username, String password, String role, RestaurantsEntity restaurant) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role != null ? role : "Camarero";
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public RestaurantsEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantsEntity restaurant) {
        this.restaurant = restaurant;
    }
}
