package com.sergio.fastservice.controllers;

import com.sergio.fastservice.entity.models.UserEntity;
import com.sergio.fastservice.entity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<UserEntity> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserEntity userDetails) {
        Optional<UserEntity> user = userService.getUserById(id);

        if (user.isPresent()) {
            UserEntity updatedUser = user.get();
            updatedUser.setUsername(userDetails.getUsername());
            userService.saveUser(updatedUser);
            return ResponseEntity.ok("Usuario actualizado exitosamente.");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.ok("Usuario eliminado exitosamente.");
        }
        return ResponseEntity.notFound().build();
    }
}