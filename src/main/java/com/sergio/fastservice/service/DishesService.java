package com.sergio.fastservice.service;

import com.sergio.fastservice.entity.TablesEntity;
import com.sergio.fastservice.entity.DishesEntity;
import com.sergio.fastservice.repository.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishesService {

    private final DishesRepository dishesRepository;

    @Autowired
    public DishesService(DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
    }

    public List<DishesEntity> getAllDishes() {
        return dishesRepository.findAll();
    }

    public Optional<DishesEntity> getDishById(Long id) {
        return dishesRepository.findById(id);
    }

    public DishesEntity saveOrUpdateDish(DishesEntity dish) {
        return dishesRepository.save(dish);
    }

    public void deleteDishById(Long id) {
        if (dishesRepository.existsById(id)) {
            dishesRepository.deleteById(id);
        } else {
            throw new RuntimeException("El plato con ID " + id + " no existe.");
        }
    }

    public List<DishesEntity> findByTable(TablesEntity table) {
        return dishesRepository.findByTable(table);
    }
}
