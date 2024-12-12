package com.sergio.fastservice.entity.services;

import java.util.List;

import com.sergio.fastservice.entity.models.Dishes;

public interface IDishService {
	public Dishes get(long id);
	public List<Dishes> getAll();
	public void post(Dishes dish);
	public void put (Dishes dish, long id);
	public void delete(long id);
}
