package com.sergio.fastservice.controller;

import com.sergio.fastservice.entity.DishesEntity;
import com.sergio.fastservice.entity.TablesEntity;
import com.sergio.fastservice.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/dishes")
public class DishesController {

    private final DishesService dishesService;

    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Z][a-zA-Z]{2,}.*$");

    @Autowired
    public DishesController(DishesService dishesService) {
        this.dishesService = dishesService;
    }

    @GetMapping
    public List<DishesEntity> getAllDishes() {
        return dishesService.getAllDishes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishesEntity> getDishById(@PathVariable Long id) {
        Optional<DishesEntity> dish = dishesService.getDishById(id);
        return dish.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> saveOrUpdateDish(@RequestBody DishesEntity dish) {
        if (dish.getName() == null || !NAME_PATTERN.matcher(dish.getName()).matches()) {
            return ResponseEntity.badRequest().body("Error: El nombre del plato debe comenzar con una mayúscula y tener al menos 3 caracteres.");
        }

        DishesEntity savedDish = dishesService.saveOrUpdateDish(dish);
        return ResponseEntity.ok(savedDish);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDish(@PathVariable Long id, @RequestBody DishesEntity dish) {
        if (dish.getName() == null || !NAME_PATTERN.matcher(dish.getName()).matches()) {
            return ResponseEntity.badRequest().body("El nombre del plato debe comenzar con una mayúscula y tener al menos 3 caracteres.");
        }

        Optional<DishesEntity> existingDishOpt = dishesService.getDishById(id);
        if (existingDishOpt.isPresent()) {
            DishesEntity existingDish = existingDishOpt.get();

            existingDish.setName(dish.getName());
            existingDish.setTable(dish.getTable());
            existingDish.setContains(dish.getContains());

            DishesEntity updatedDish = dishesService.saveOrUpdateDish(existingDish);

            return ResponseEntity.ok(updatedDish);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDishById(@PathVariable Long id) {
        try {
            dishesService.deleteDishById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/table/{tableId}")
    public List<DishesEntity> getDishesByTable(@PathVariable Long tableId) {
        TablesEntity table = new TablesEntity();
        table.setId(tableId);
        return dishesService.findByTable(table);
    }
}
