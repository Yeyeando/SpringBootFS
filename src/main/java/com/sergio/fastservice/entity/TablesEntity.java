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

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantsEntity restaurant;

    public TablesEntity() {
    }

    public TablesEntity(Long id, int number, boolean availability, List<DishesEntity> dishes, RestaurantsEntity restaurant) {
        this.id = id;
        this.number = number;
        this.availability = availability;
        this.dishes = dishes;
        this.restaurant = restaurant;
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

    public RestaurantsEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantsEntity restaurant) {
        this.restaurant = restaurant;
    }
}
