package com.sergio.fastservice.service;

import com.sergio.fastservice.entity.RestaurantsEntity;
import com.sergio.fastservice.repository.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantsService {

    @Autowired
    private RestaurantsRepository restaurantsRepository;

    public List<RestaurantsEntity> getAllRestaurants() {
        return restaurantsRepository.findAll();
    }

    public Optional<RestaurantsEntity> getRestaurantById(Long id) {
        return restaurantsRepository.findById(id);
    }

    public RestaurantsEntity createRestaurant(RestaurantsEntity restaurant) {
        return restaurantsRepository.save(restaurant);
    }

    public RestaurantsEntity updateRestaurant(Long id, RestaurantsEntity updatedRestaurant) {
        return restaurantsRepository.findById(id).map(restaurant -> {
            restaurant.setName(updatedRestaurant.getName());
            restaurant.setUbication(updatedRestaurant.getUbication());
            return restaurantsRepository.save(restaurant);
        }).orElse(null);
    }

    public boolean deleteRestaurant(Long id) {
        if (restaurantsRepository.existsById(id)) {
            restaurantsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}