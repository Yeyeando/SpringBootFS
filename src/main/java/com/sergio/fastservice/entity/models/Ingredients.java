package com.sergio.fastservice.entity.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="ingredients")

public class Ingredients implements Serializable{
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id_ingredient;

private String name;

@OneToMany(mappedBy = "idIngredient")
private List<Contains> contains;


public long getId_ingredient() {
	return id_ingredient;
}

public void setId_ingredient(long id_ingredient) {
	this.id_ingredient = id_ingredient;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public Ingredients(long id_ingredient, String name) {
	super();
	this.id_ingredient = id_ingredient;
	this.name = name;
}

public Ingredients() {
	
}
}	


