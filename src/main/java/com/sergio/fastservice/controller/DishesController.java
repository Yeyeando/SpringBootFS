package com.sergio.fastservice.controller;

import com.sergio.fastservice.entity.DishesEntity;
import com.sergio.fastservice.entity.TablesEntity;
import com.sergio.fastservice.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dishes")
public class DishesController {

    private final DishesService dishesService;

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
    public ResponseEntity<DishesEntity> saveOrUpdateDish(@RequestBody DishesEntity dish) {
        DishesEntity savedDish = dishesService.saveOrUpdateDish(dish);
        return ResponseEntity.ok(savedDish);
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
