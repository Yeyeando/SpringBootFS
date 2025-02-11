package com.sergio.fastservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "contains")
public class ContainsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_dish")
    private DishesEntity dishes;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_ingredient")
    private IngredientsEntity ingredients;

    @NotNull
    @Min(1)
    private Integer quantity;

    public ContainsEntity(Long id, DishesEntity dishes, IngredientsEntity ingredients, Integer quantity) {
        this.id = id;
        this.dishes = dishes;
        this.ingredients = ingredients;
        this.quantity = quantity;
    }

    public ContainsEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DishesEntity getDishes() {
        return dishes;
    }

    public void setDishes(DishesEntity dishes) {
        this.dishes = dishes;
    }

    public IngredientsEntity getIngredients() {
        return ingredients;
    }

    public void setIngredients(IngredientsEntity ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}