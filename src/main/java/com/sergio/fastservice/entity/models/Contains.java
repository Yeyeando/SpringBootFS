package com.sergio.fastservice.entity.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "contains")
@IdClass(ContainsId.class)
public class Contains {

    @Id
    @Column(name = "id_dish", insertable = false, updatable = false) // Importante para clave compuesta
    private Long idDish;

    @Id
    @Column(name = "id_ingredient", insertable = false, updatable = false) // Importante para clave compuesta
    private Long idIngredient;

    @Column(name = "quantity")
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "id_dish", referencedColumnName = "id_dish", insertable = false, updatable = false)
    @JsonIgnore // Evita el bucle infinito al serializar la relación inversa
    private Dishes dish;

    @ManyToOne
    @JoinColumn(name = "id_ingredient", referencedColumnName = "id_ingredient", insertable = false, updatable = false)
    @JsonIgnore // Evita el bucle infinito al serializar la relación inversa
    private Ingredients ingredient;

    // Getters y setters
    public Long getIdDish() {
        return idDish;
    }

    public void setIdDish(Long idDish) {
        this.idDish = idDish;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Long idIngredient) {
        this.idIngredient = idIngredient;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Dishes getDish() {
        return dish;
    }

    public void setDish(Dishes dish) {
        this.dish = dish;
    }

    public Ingredients getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredients ingredient) {
        this.ingredient = ingredient;
    }

    // Constructor vacío
    public Contains() {}

    // Constructor con parámetros
    public Contains(Long idDish, Long idIngredient, Long quantity) {
        this.idDish = idDish;
        this.idIngredient = idIngredient;
        this.quantity = quantity;
    }
}
