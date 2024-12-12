package com.sergio.fastservice.entity.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name ="contains")
@IdClass(ContainsId.class)
public class Contains {
    @Id
    @Column(name = "id_dish")
    private Long idDish;

    @Id
    @Column(name = "id_ingredient")
    private Long idIngredient;

    @Column(name = "quantity")
    private Long quantity;

    // Getters y Setters
     
    public Long getIdDish() { return idDish; }
    public void setIdDish(Long idDish) { this.idDish = idDish; }

    public Long getIdIngredient() { return idIngredient; }
    public void setIdIngredient(Long idIngredient) { this.idIngredient = idIngredient; }

    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }

    public Contains(Long idDish, Long idIngredient, Long quantity) {
        this.idDish = idDish;
        this.idIngredient = idIngredient;
        this.quantity = quantity;
    }

    public Contains() {}
}
