package com.sergio.fastservice.service;

import com.sergio.fastservice.entity.ContainsEntity;
import com.sergio.fastservice.repository.ContainsRepository;
import com.sergio.fastservice.entity.DishesEntity;
import com.sergio.fastservice.entity.IngredientsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContainsService {

    private final ContainsRepository containsRepository;

    @Autowired
    public ContainsService(ContainsRepository containsRepository) {
        this.containsRepository = containsRepository;
    }

    public List<ContainsEntity> getAllContains() {
        return containsRepository.findAll();
    }

    public Optional<ContainsEntity> getContainsById(Long id) {
        return containsRepository.findById(id);
    }

    public ContainsEntity saveOrUpdateContains(ContainsEntity containsEntity) {
        return containsRepository.save(containsEntity);
    }

    public void deleteContainsById(Long id) {
        if (containsRepository.existsById(id)) {
            containsRepository.deleteById(id);
        } else {
            throw new RuntimeException("El registro con ID " + id + " no existe.");
        }
    }

    public List<ContainsEntity> findByDish(DishesEntity dish) {
        return containsRepository.findByDishes(dish);
    }

    public List<ContainsEntity> findByIngredient(IngredientsEntity ingredient) {
        return containsRepository.findByIngredients(ingredient);
    }
}
