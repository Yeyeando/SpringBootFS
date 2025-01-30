package com.sergio.fastservice.controllers;

import com.sergio.fastservice.entity.models.UserEntity;
import com.sergio.fastservice.security.JWTUtils;
import com.sergio.fastservice.entity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtils jwtUtils;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserEntity user) {
        if (userService.getUserByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: El nombre de usuario ya está en uso.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserEntity user) {
        Optional<UserEntity> userOptional = userService.getUserByUsername(user.getUsername());

        if (userOptional.isEmpty() || !passwordEncoder.matches(user.getPassword(), userOptional.get().getPassword())) {
            return ResponseEntity.badRequest().body("Error: Credenciales inválidas.");
        }

        String token = jwtUtils.generateToken(user.getUsername());
        return ResponseEntity.ok().body("{\"token\": \"" + token + "\"}");
    }
}

