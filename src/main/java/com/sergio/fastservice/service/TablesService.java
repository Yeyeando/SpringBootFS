package com.sergio.fastservice.service;

import com.sergio.fastservice.entity.RestaurantsEntity;
import com.sergio.fastservice.entity.TablesEntity;
import com.sergio.fastservice.repository.RestaurantsRepository;
import com.sergio.fastservice.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TablesService {

    private final TablesRepository tablesRepository;
    private final RestaurantsRepository restaurantsRepository;

    @Autowired
    public TablesService(TablesRepository tablesRepository, RestaurantsRepository restaurantsRepository) {
        this.tablesRepository = tablesRepository;
        this.restaurantsRepository = restaurantsRepository;
    }

    public List<TablesEntity> getAllTables() {
        return tablesRepository.findAll();
    }

    public List<TablesEntity> getTablesByRestaurantId(Long restaurantId) {
        return tablesRepository.findByRestaurantId(restaurantId);
    }

    public Optional<TablesEntity> getTableById(Long id) {
        return tablesRepository.findById(id);
    }

    public TablesEntity saveOrUpdateTable(TablesEntity table) {
        RestaurantsEntity restaurant = table.getRestaurant();
        if (restaurant == null || restaurant.getId() == null || !restaurantsRepository.existsById(restaurant.getId())) {
            throw new RuntimeException("El restaurante especificado no existe.");
        }

        return tablesRepository.save(table);
    }

    public void deleteTableById(Long id) {
        if (tablesRepository.existsById(id)) {
            tablesRepository.deleteById(id);
        } else {
            throw new RuntimeException("La mesa con ID " + id + " no existe.");
        }
    }
}
