package com.sergio.fastservice.controller;

import com.sergio.fastservice.entity.UserEntity;
import com.sergio.fastservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$"
    );

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

            if (userDetails.getPassword() != null && !PASSWORD_PATTERN.matcher(userDetails.getPassword()).matches()) {
                return ResponseEntity.badRequest().body("La contraseña debe tener al menos 8 caracteres, incluyendo una mayúscula, una minúscula y un número.");
            }

            updatedUser.setPassword(userDetails.getPassword());

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
