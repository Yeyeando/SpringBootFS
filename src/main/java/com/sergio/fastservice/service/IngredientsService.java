package com.sergio.fastservice.service;

import com.sergio.fastservice.entity.IngredientsEntity;
import com.sergio.fastservice.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientsService {

    private final IngredientsRepository ingredientsRepository;

    @Autowired
    public IngredientsService(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public List<IngredientsEntity> getAllIngredients() {
        return (List<IngredientsEntity>) ingredientsRepository.findAll();
    }

    public Optional<IngredientsEntity> getIngredientById(Long id) {
        return ingredientsRepository.findById(id);
    }

    public IngredientsEntity saveOrUpdateIngredient(IngredientsEntity ingredient) {
        return ingredientsRepository.save(ingredient);
    }

    public void deleteIngredientById(Long id) {
        if (ingredientsRepository.existsById(id)) {
            ingredientsRepository.deleteById(id);
        } else {
            throw new RuntimeException("El ingrediente con ID " + id + " no existe.");
        }
    }
}
