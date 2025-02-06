package com.sergio.fastservice.controllers;
import java.util.List;
import java.util.stream.Collectors;

import com.sergio.fastservice.entity.models.Dishes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.fastservice.entity.models.Contains;
import com.sergio.fastservice.entity.models.ContainsId;
import com.sergio.fastservice.entity.services.ContainServicelmpl;

@RestController
@CrossOrigin(origins ="*")
public class ContainsController {

    @Autowired
    ContainServicelmpl containsService;

    public ContainsController(ContainServicelmpl containsService) {
        this.containsService = containsService;
    }

    @GetMapping("/contains")
    public List<Contains> getAllContaints(){
        return containsService.getAll();
    }

    // Obtener ingredientes por platillo
    @GetMapping("/{dishId}")
    public List<Contains> getIngredientsByDish(@PathVariable Long dishId) {
        return containsService.getIngredientsByDish(dishId);
    }

    // Obtener una relación específica
    @GetMapping("/{dishId}/{ingredientId}")
    public Contains getContains(@PathVariable Long dishId, @PathVariable Long ingredientId) {
        ContainsId id = new ContainsId(dishId, ingredientId);
        return containsService.get(id);
    }

    // Agregar un ingrediente a un platillo
    @PostMapping
    public void postContains(@RequestBody Contains contain) {
        containsService.post(contain);
    }

    // Actualizar cantidad de un ingrediente en un platillo
    @PutMapping("/{dishId}/{ingredientId}")
    public void putContains(@PathVariable Long dishId, @PathVariable Long ingredientId, @RequestBody Contains contain) {
        ContainsId id = new ContainsId(dishId, ingredientId);
        containsService.put(contain, id);
    }

    // Eliminar un ingrediente de un platillo
    @DeleteMapping("/{dishId}/{ingredientId}")
    public void deleteContains(@PathVariable Long dishId, @PathVariable Long ingredientId) {
        ContainsId id = new ContainsId(dishId, ingredientId);
        containsService.delete(id);
    }
}
