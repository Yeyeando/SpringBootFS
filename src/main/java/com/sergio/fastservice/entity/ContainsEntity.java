package com.sergio.fastservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "contains")
public class ContainsEntity {

    @EmbeddedId
    private ContainsId id;

    @ManyToOne
    @MapsId("idDish")
    @JoinColumn(name = "id_dish", nullable = false)
    private DishesEntity dishes;

    @ManyToOne
    @MapsId("idIngredient")
    @JoinColumn(name = "id_ingredient", nullable = false)
    private IngredientsEntity ingredients;

    @NotNull
    @Min(1)
    private Integer quantity;

    public ContainsEntity(ContainsId id, DishesEntity dishes, IngredientsEntity ingredients, Integer quantity) {
        this.id = id;
        this.dishes = dishes;
        this.ingredients = ingredients;
        this.quantity = quantity;
    }

    public ContainsEntity() {
    }

    public ContainsId getId() {
        return id;
    }

    public void setId(ContainsId id) {
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