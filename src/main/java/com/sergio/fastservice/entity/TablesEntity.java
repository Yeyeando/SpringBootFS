package com.sergio.fastservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "tables")
public class TablesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int number;

    @NotNull
    private boolean availability;

    @OneToMany(mappedBy = "table")
    @JsonIgnore
    private List<DishesEntity> dishes;

    public TablesEntity(Long id, int number, boolean availability, List<DishesEntity> dishes) {
        this.id = id;
        this.number = number;
        this.availability = availability;
        this.dishes = dishes;
    }

    public TablesEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public List<DishesEntity> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishesEntity> dishes) {
        this.dishes = dishes;
    }
}
