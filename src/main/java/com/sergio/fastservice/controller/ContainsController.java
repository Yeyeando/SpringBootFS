package com.sergio.fastservice.controller;

import com.sergio.fastservice.entity.ContainsEntity;
import com.sergio.fastservice.entity.DishesEntity;
import com.sergio.fastservice.entity.IngredientsEntity;
import com.sergio.fastservice.service.ContainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contains")
public class ContainsController {

    private final ContainsService containsService;

    @Autowired
    public ContainsController(ContainsService containsService) {
        this.containsService = containsService;
    }

    @GetMapping
    public List<ContainsEntity> getAllContains() {
        return containsService.getAllContains();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContainsEntity> getContainsById(@PathVariable Long id) {
        Optional<ContainsEntity> contains = containsService.getContainsById(id);
        return contains.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContainsEntity> saveOrUpdateContains(@RequestBody ContainsEntity containsEntity) {
        ContainsEntity savedContains = containsService.saveOrUpdateContains(containsEntity);
        return ResponseEntity.ok(savedContains);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContainsEntity> updateContains(@PathVariable Long id, @RequestBody ContainsEntity containsDetails) {
        Optional<ContainsEntity> existingContains = containsService.getContainsById(id);

        if (existingContains.isPresent()) {
            ContainsEntity containsEntity = existingContains.get();
            containsEntity.setDishes(containsDetails.getDishes());
            containsEntity.setIngredients(containsDetails.getIngredients());
            containsEntity.setQuantity(containsDetails.getQuantity());

            ContainsEntity updatedContains = containsService.saveOrUpdateContains(containsEntity);
            return ResponseEntity.ok(updatedContains);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContainsById(@PathVariable Long id) {
        try {
            containsService.deleteContainsById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dish/{dishId}")
    public List<ContainsEntity> getContainsByDish(@PathVariable Long dishId) {
        DishesEntity dish = new DishesEntity();
        dish.setId(dishId);
        return containsService.findByDish(dish);
    }

    @GetMapping("/ingredient/{ingredientId}")
    public List<ContainsEntity> getContainsByIngredient(@PathVariable Long ingredientId) {
        IngredientsEntity ingredient = new IngredientsEntity();
        ingredient.setId(ingredientId);
        return containsService.findByIngredient(ingredient);
    }
}