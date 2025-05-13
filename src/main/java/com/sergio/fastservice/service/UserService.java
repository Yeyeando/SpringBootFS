package com.sergio.fastservice.service;

import com.sergio.fastservice.entity.UserEntity;
import com.sergio.fastservice.entity.RestaurantsEntity;
import com.sergio.fastservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantsService restaurantsService;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void saveUser(UserEntity user, Long restaurantId) {
        // Buscar el restaurante por ID
        Optional<RestaurantsEntity> restaurantOpt = restaurantsService.getRestaurantById(restaurantId);

        // Si no encontramos el restaurante, lanzamos una excepción
        if (!restaurantOpt.isPresent()) {
            throw new IllegalArgumentException("Error: El restaurante con ID " + restaurantId + " no existe.");
        }

        // Asignamos el restaurante encontrado al usuario
        user.setRestaurant(restaurantOpt.get());

        // Guardamos al usuario con la relación
        userRepository.save(user);
    }

    public Optional<UserEntity> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
