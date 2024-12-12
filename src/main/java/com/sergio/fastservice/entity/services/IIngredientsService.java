package com.sergio.fastservice.entity.services;

import java.util.List;

import com.sergio.fastservice.entity.models.Ingredients;

public interface IIngredientsService {
	public Ingredients get(long id);
	public List<Ingredients> getAll();
	public void post(Ingredients ingredient);
	public void put (Ingredients ingredient, long id);
	public void delete(long id);
}
