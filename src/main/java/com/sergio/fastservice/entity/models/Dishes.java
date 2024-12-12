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
@Table(name ="dishes")

public class Dishes implements Serializable{
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id_dish;

private String name;

@OneToMany(mappedBy = "idDish")
private List<Contains> contains;


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
public Dishes(long id_dish, String name) {
	super();
	this.id_dish = id_dish;
	this.name = name;
}

public Dishes() {
	
}
}	