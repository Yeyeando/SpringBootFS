package com.sergio.fastservice.service;

import com.sergio.fastservice.entity.ContainsEntity;
import com.sergio.fastservice.entity.ContainsId;
import com.sergio.fastservice.entity.DishesEntity;
import com.sergio.fastservice.entity.IngredientsEntity;
import com.sergio.fastservice.repository.ContainsRepository;
import com.sergio.fastservice.repository.DishesRepository;
import com.sergio.fastservice.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContainsService {

    @Autowired
    private ContainsRepository containsRepository;

    @Autowired
    private DishesRepository dishesRepository;

    @Autowired
    private IngredientsRepository ingredientsRepository;

    public List<ContainsEntity> getAllContains() {
        return containsRepository.findAll();
    }

    public Optional<ContainsEntity> getContainsById(ContainsId id) {
        return containsRepository.findById(id);
    }

    public ContainsEntity createContains(ContainsEntity containsEntity) {
        DishesEntity dish = dishesRepository.findById(containsEntity.getId().getIdDish())
                .orElseThrow(() -> new RuntimeException("Plato no encontrado"));

        IngredientsEntity ingredient = ingredientsRepository.findById(containsEntity.getId().getIdIngredient())
                .orElseThrow(() -> new RuntimeException("Ingrediente no encontrado"));

        containsEntity.setDishes(dish);
        containsEntity.setIngredients(ingredient);

        return containsRepository.save(containsEntity);
    }

    public ContainsEntity updateContains(ContainsEntity contains) {
        return containsRepository.save(contains);
    }

    public void deleteContains(ContainsId id) {
        containsRepository.deleteById(id);
    }

    public List<ContainsEntity> getContainsByIngredient(Long ingredientId) {
        return containsRepository.findByIngredientsId(ingredientId);
    }

    // Buscar relaciones por plato
    public List<ContainsEntity> getContainsByDish(Long dishId) {
        return containsRepository.findByDishesId(dishId);
    }
}