package com.sergio.fastservice.controller;

import com.sergio.fastservice.entity.IngredientsEntity;
import com.sergio.fastservice.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    private static final Pattern NAME_PATTERN = Pattern.compile(
            "^[A-Z][a-zA-Z]{2,}$"
    );

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
    public ResponseEntity<?> saveOrUpdateIngredient(@RequestBody IngredientsEntity ingredient) {
        if (!NAME_PATTERN.matcher(ingredient.getName()).matches()) {
            return ResponseEntity.badRequest().body("Error: El nombre del ingrediente debe comenzar con una mayúscula y tener al menos 3 caracteres.");
        }
        IngredientsEntity savedIngredient = ingredientsService.saveOrUpdateIngredient(ingredient);
        return ResponseEntity.ok(savedIngredient);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateIngredient(@PathVariable Long id, @RequestBody IngredientsEntity ingredientDetails) {
        Optional<IngredientsEntity> existingIngredient = ingredientsService.getIngredientById(id);

        if (existingIngredient.isPresent()) {
            if (!NAME_PATTERN.matcher(ingredientDetails.getName()).matches()) {
                return ResponseEntity.badRequest().body("Error: El nombre del ingrediente debe comenzar con una mayúscula y tener al menos 3 caracteres.");
            }
            IngredientsEntity ingredient = existingIngredient.get();
            ingredient.setName(ingredientDetails.getName());

            IngredientsEntity updatedIngredient = ingredientsService.saveOrUpdateIngredient(ingredient);
            return ResponseEntity.ok(updatedIngredient);
        } else {
            return ResponseEntity.notFound().build();
        }
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