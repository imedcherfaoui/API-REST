package com.quest.etna.controller;

import com.quest.etna.model.User;
import com.quest.etna.model.UserDetails;
import com.quest.etna.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final UserRepository userRepository;

    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        // Check if username or password is missing
        if (user.getUsername() == null || user.getUsername().isEmpty() ||
            user.getPassword() == null || user.getPassword().isEmpty()) {
            String errorMessage = "Le nom d'utilisateur ou le mot de passe est manquant.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"" + errorMessage + "\"}");
        }

        // Check if the user already exists (case-insensitive)
        User existingUser = userRepository.findByUsernameIgnoreCase(user.getUsername());
        if (existingUser != null) {
            String errorMessage = "L'utilisateur existe déjà.";
            return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"" + errorMessage + "\"}");
        }

        // Save the new user
        User savedUser = userRepository.save(user);

        // Create UserDetails object for response
        UserDetails userDetails = new UserDetails();
        userDetails.setId(savedUser.getId());
        userDetails.setUsername(savedUser.getUsername());
        userDetails.setRole(savedUser.getRole());

        // Return a JSON response with created status and UserDetails object
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetails);
    }
}
