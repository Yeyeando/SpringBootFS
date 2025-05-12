package com.sergio.fastservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name = "users")
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

    public UserEntity(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role != null ? role : "Camarero";
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public @NotNull String getRole() {
        return role;
    }

    public void setRole(@NotNull String role) {
        this.role = role;
    }
}
