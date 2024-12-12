package com.sergio.fastservice.entity.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tables")
public class Tables implements Serializable{
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id_table;

private int number;

private boolean availability;

public long getId_table() {
	return id_table;
}

public void setId_table(long id_table) {
	this.id_table = id_table;
}

public int getNumber() {
	return number;
}

public void setNumber(int number) {
	this.number = number;
}

public boolean isAvailability() {
	return availability;
}

public void setAvailability(boolean availability) {
	this.availability = availability;
}

public Tables(long id_table, int number, boolean availability) {
	super();
	this.id_table = id_table;
	this.number = number;
	this.availability = availability;
}

public Tables() {
	
}
}
