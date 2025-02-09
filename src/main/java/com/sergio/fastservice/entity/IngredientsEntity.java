package com.sergio.fastservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class IngredientsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "ingredients", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContainsEntity> contains;

    public IngredientsEntity() {
    }

    public IngredientsEntity(Long id, String name, List<ContainsEntity> contains) {
        this.id = id;
        this.name = name;
        this.contains = contains;
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

    public List<ContainsEntity> getContains() {
        return contains;
    }

    public void setContains(List<ContainsEntity> contains) {
        this.contains = contains;
    }
}
