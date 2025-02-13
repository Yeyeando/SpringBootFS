package com.sergio.fastservice.controller;

import com.sergio.fastservice.entity.UserEntity;
import com.sergio.fastservice.security.JWTUtils;
import com.sergio.fastservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtils jwtUtils;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$"
    );

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserEntity user) {
        if (userService.getUserByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: El nombre de usuario ya está en uso.");
        }

        if (!PASSWORD_PATTERN.matcher(user.getPassword()).matches()) {
            return ResponseEntity.badRequest().body("Error: La contraseña debe contener al menos una letra minúscula, una letra mayúscula, un número y tener un mínimo de 8 caracteres.");
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
