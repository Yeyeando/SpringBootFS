package com.sergio.fastservice.entity.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ContainsId {
    @Column(name = "id_dish")
    private Long idDish;

    @Column(name = "id_ingredient")
    private Long idIngredient;
    public ContainsId() {
    }

    public ContainsId(long id_dish, long id_ingredient) {
        this.idDish = id_dish;
        this.idIngredient = id_ingredient;
    }

    // Getters y Setters
    public long getId_dish() {
        return idDish;
    }

    public void setId_dish(long id_dish) {
        this.idDish = id_dish;
    }

    public long getId_ingredient() {
        return idIngredient;
    }

    public void setId_ingredient(long id_ingredient) {
        this.idIngredient = id_ingredient;
    }

    
    public Long getIdDish() { return idDish; }
    public void setIdDish(Long idDish) { this.idDish = idDish; }

    public Long getIdIngredient() { return idIngredient; }
    public void setIdIngredient(Long idIngredient) { this.idIngredient = idIngredient; }
    
    // Métodos equals y hashCode necesarios para la comparación de claves compuestas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainsId that = (ContainsId) o;
        return Objects.equals(idDish, that.idDish) && 
               Objects.equals(idIngredient, that.idIngredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDish, idIngredient);
    }
}
