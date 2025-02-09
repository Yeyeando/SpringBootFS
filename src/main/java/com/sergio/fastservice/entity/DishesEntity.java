package com.sergio.fastservice.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "dishes")
public class DishesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_dish;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_table", nullable = false)
    private TablesEntity table;

    @OneToMany(mappedBy = "dishes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContainsEntity> contains;

    public DishesEntity(long id_dish, String name, TablesEntity table, List<ContainsEntity> contains) {
        this.id_dish = id_dish;
        this.name = name;
        this.table = table;
        this.contains = contains;
    }

    public DishesEntity() {
    }

    public long getId_dish() {
        return id_dish;
    }

    public void setId(long id_dish) {
        this.id_dish = id_dish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TablesEntity getTable() {
        return table;
    }

    public void setTable(TablesEntity table) {
        this.table = table;
    }

    public List<ContainsEntity> getContains() {
        return contains;
    }

    public void setContains(List<ContainsEntity> contains) {
        this.contains = contains;
    }
}
