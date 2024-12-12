package com.sergio.fastservice.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.fastservice.entity.dao.IIngredientsDao;
import com.sergio.fastservice.entity.models.Ingredients;

@Service
public class IngredientsServicelmpl implements IIngredientsService{
	
	@Autowired
	private IIngredientsDao ingredientsDao;
	
	
	@Override
	public Ingredients get(long id) {
		return ingredientsDao.findById(id).get();
	}
	
	@Override
	public List<Ingredients> getAll(){
		return (List<Ingredients>) ingredientsDao.findAll();
	}
	
	
	@Override
	public void post(Ingredients ingredient) {
		ingredientsDao.save(ingredient);
	}
	
	@Override
	public void put(Ingredients ingredient, long id) {
		ingredientsDao.findById(id)	.ifPresent((x)->{
			ingredient.setId_ingredient(id);
			ingredientsDao.save(ingredient);
		});
	}
	
	@Override
	public void delete(long id) {
		ingredientsDao.deleteById(id);
	}

	
	
}
