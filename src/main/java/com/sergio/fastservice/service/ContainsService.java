package com.sergio.fastservice.service;

import com.sergio.fastservice.entity.ContainsEntity;
import com.sergio.fastservice.entity.ContainsId;
import com.sergio.fastservice.repository.ContainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContainsService {

    @Autowired
    private ContainsRepository containsRepository;

    public List<ContainsEntity> getAllContains() {
        return containsRepository.findAll();
    }

    public Optional<ContainsEntity> getContainsById(ContainsId id) {
        return containsRepository.findById(id);
    }

    public ContainsEntity createContains(ContainsEntity contains) {
        return containsRepository.save(contains);
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