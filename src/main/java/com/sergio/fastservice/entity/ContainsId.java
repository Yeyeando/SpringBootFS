package com.sergio.fastservice.entity;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class ContainsId implements Serializable {

    private Long idDish;
    private Long idIngredient;

    public ContainsId() {
    }

    public ContainsId(Long idDish, Long idIngredient) {
        this.idDish = idDish;
        this.idIngredient = idIngredient;
    }

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