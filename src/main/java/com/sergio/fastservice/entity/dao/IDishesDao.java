package com.sergio.fastservice.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.sergio.fastservice.entity.models.Dishes;

public interface IDishesDao extends CrudRepository<Dishes, Long>{
	
}
