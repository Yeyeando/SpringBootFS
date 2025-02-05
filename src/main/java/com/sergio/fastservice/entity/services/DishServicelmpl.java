package com.sergio.fastservice.entity.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sergio.fastservice.entity.dao.IDishesDao;
import com.sergio.fastservice.entity.models.Dishes;
@Service
public class DishServicelmpl implements IDishService{
	@Autowired
	private IDishesDao dishesDao;
	
	
	@Override
	public Dishes get(long id) {
		return dishesDao.findById(id).get();
	}
	
	@Override
	public List<Dishes> getAll(){
		return (List<Dishes>) dishesDao.findAll();
	}
	
	@Override
	public void post(Dishes dish) {
		dishesDao.save(dish);
	}
	
	@Override
	public void put(Dishes dish, long id) {
		dishesDao.findById(id)	.ifPresent((x)->{
			dish.setId_dish(id);
			dishesDao.save(dish);
		});
	}
	
	@Override
	public void delete(long id) {
		dishesDao.deleteById(id);
	}
}
