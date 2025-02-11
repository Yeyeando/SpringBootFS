package com.sergio.fastservice.controller;

import com.sergio.fastservice.entity.ContainsEntity;
import com.sergio.fastservice.entity.ContainsId;
import com.sergio.fastservice.service.ContainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contains")
public class ContainsController {

    @Autowired
    private ContainsService containsService;

    @GetMapping
    public List<ContainsEntity> getAllContains() {
        return containsService.getAllContains();
    }

    @GetMapping("/{idDish}/{idIngredient}")
    public ResponseEntity<ContainsEntity> getContainsById(
            @PathVariable Long idDish,
            @PathVariable Long idIngredient) {
        ContainsId id = new ContainsId(idDish, idIngredient);
        Optional<ContainsEntity> contains = containsService.getContainsById(id);
        return contains.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContainsEntity createContains(@RequestBody ContainsEntity contains) {
        return containsService.createContains(contains);
    }

    @PutMapping("/{idDish}/{idIngredient}")
    public ResponseEntity<ContainsEntity> updateContains(
            @PathVariable Long idDish,
            @PathVariable Long idIngredient,
            @RequestBody ContainsEntity contains) {
        ContainsId id = new ContainsId(idDish, idIngredient);
        if (!containsService.getContainsById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contains.setId(id);
        return ResponseEntity.ok(containsService.updateContains(contains));
    }

    @DeleteMapping("/{idDish}/{idIngredient}")
    public ResponseEntity<Void> deleteContains(
            @PathVariable Long idDish,
            @PathVariable Long idIngredient) {
        ContainsId id = new ContainsId(idDish, idIngredient);
        if (!containsService.getContainsById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        containsService.deleteContains(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ingredient/{ingredientId}")
    public List<ContainsEntity> getContainsByIngredient(@PathVariable Long ingredientId) {
        return containsService.getContainsByIngredient(ingredientId);
    }

    @GetMapping("/dish/{dishId}")
    public List<ContainsEntity> getContainsByDish(@PathVariable Long dishId) {
        return containsService.getContainsByDish(dishId);
    }
}