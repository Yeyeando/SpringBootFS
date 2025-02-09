package com.sergio.fastservice.controller;

import com.sergio.fastservice.entity.IngredientsEntity;
import com.sergio.fastservice.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    @Autowired
    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping
    public List<IngredientsEntity> getAllIngredients() {
        return ingredientsService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientsEntity> getIngredientById(@PathVariable Long id) {
        Optional<IngredientsEntity> ingredient = ingredientsService.getIngredientById(id);
        return ingredient.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<IngredientsEntity> saveOrUpdateIngredient(@RequestBody IngredientsEntity ingredient) {
        IngredientsEntity savedIngredient = ingredientsService.saveOrUpdateIngredient(ingredient);
        return ResponseEntity.ok(savedIngredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredientById(@PathVariable Long id) {
        try {
            ingredientsService.deleteIngredientById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}