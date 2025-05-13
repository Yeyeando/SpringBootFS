package com.sergio.fastservice.controller;

import com.sergio.fastservice.entity.RestaurantsEntity;
import com.sergio.fastservice.entity.TablesEntity;
import com.sergio.fastservice.repository.RestaurantsRepository;
import com.sergio.fastservice.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tables")
public class TablesController {

    private final TablesService tablesService;
    private final RestaurantsRepository restaurantsRepository;

    @Autowired
    public TablesController(TablesService tablesService, RestaurantsRepository restaurantsRepository) {
        this.tablesService = tablesService;
        this.restaurantsRepository = restaurantsRepository;
    }

    @GetMapping
    public List<TablesEntity> getAllTables() {
        return tablesService.getAllTables();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablesEntity> getTableById(@PathVariable Long id) {
        Optional<TablesEntity> table = tablesService.getTableById(id);
        return table.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/restaurants/{restaurantId}/tables")
    public ResponseEntity<List<TablesEntity>> getTablesByRestaurantId(@PathVariable Long restaurantId) {
        List<TablesEntity> tables = tablesService.getTablesByRestaurantId(restaurantId);

        if (tables.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tables);
    }

    @PostMapping
    public ResponseEntity<TablesEntity> createTable(@RequestBody Map<String, Object> body) {
        int number = (int) body.get("number");
        boolean availability = (boolean) body.get("availability");
        Long restaurantId = Long.valueOf(body.get("restaurantId").toString());

        RestaurantsEntity restaurant = new RestaurantsEntity();
        restaurant.setId(restaurantId);

        TablesEntity table = new TablesEntity();
        table.setNumber(number);
        table.setAvailability(availability);
        table.setRestaurant(restaurant);

        TablesEntity savedTable = tablesService.saveOrUpdateTable(table);
        return ResponseEntity.ok(savedTable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablesEntity> updateTable(@PathVariable Long id, @RequestBody Map<String, Object> tableDetails) {
        Optional<TablesEntity> optionalTable = tablesService.getTableById(id);

        if (optionalTable.isPresent()) {
            TablesEntity table = optionalTable.get();

            table.setNumber((int) tableDetails.get("number"));
            table.setAvailability((boolean) tableDetails.get("availability"));

            Long restaurantId = Long.valueOf(tableDetails.get("restaurantId").toString());
            RestaurantsEntity restaurant = new RestaurantsEntity();
            restaurant.setId(restaurantId);

            if (!restaurantsRepository.existsById(restaurantId)) {
                return ResponseEntity.badRequest().body(null);
            }

            table.setRestaurant(restaurant);

            TablesEntity updatedTable = tablesService.saveOrUpdateTable(table);
            return ResponseEntity.ok(updatedTable);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTableById(@PathVariable Long id) {
        try {
            tablesService.deleteTableById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}