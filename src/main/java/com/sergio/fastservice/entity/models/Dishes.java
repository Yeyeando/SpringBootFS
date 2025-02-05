package com.sergio.fastservice.entity.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dishes")
public class Dishes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_dish;

    private String name;

    @ManyToOne
    @JoinColumn(name = "id_table", nullable = false) // La columna que se usará para la clave foránea en la tabla de dishes
   
    private Tables table;  // Relación con la clase Tables

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference 
    private List<Contains> contains;

    // Getters y setters
    public long getId_dish() {
        return id_dish;
    }

    public void setId_dish(long id_dish) {
        this.id_dish = id_dish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Tables getTable() {
        return table;
    }

    public void setTable(Tables table) {
        this.table = table;
    }

    public List<Contains> getContains() {
        return contains;
    }

    public void setContains(List<Contains> contains) {
        this.contains = contains;
    }

    public Dishes(long id_dish, String name, Tables table) {
        super();
        this.id_dish = id_dish;
        this.name = name;
        this.table = table;
    }

    public Dishes() {
    }
}
