package com.sergio.fastservice.controller;

import com.sergio.fastservice.entity.RestaurantsEntity;
import com.sergio.fastservice.service.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantsController {

    @Autowired
    private RestaurantsService restaurantsService;

    @GetMapping
    public List<RestaurantsEntity> getAllRestaurants() {
        return restaurantsService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantsEntity> getRestaurantById(@PathVariable Long id) {
        return restaurantsService.getRestaurantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RestaurantsEntity createRestaurant(@RequestBody RestaurantsEntity restaurant) {
        return restaurantsService.createRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantsEntity> updateRestaurant(@PathVariable Long id, @RequestBody RestaurantsEntity restaurant) {
        RestaurantsEntity updated = restaurantsService.updateRestaurant(id, restaurant);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        if (restaurantsService.deleteRestaurant(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
