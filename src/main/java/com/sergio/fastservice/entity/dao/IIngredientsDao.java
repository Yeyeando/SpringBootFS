package com.sergio.fastservice.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.sergio.fastservice.entity.models.Ingredients;

public interface IIngredientsDao extends CrudRepository<Ingredients, Long>{
	
}
