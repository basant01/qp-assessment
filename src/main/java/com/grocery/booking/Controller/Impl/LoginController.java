package com.grocery.booking.Controller.Impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class LoginController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody LoginRequest request) {
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword());
        newUser.setRole("USER"); // Assuming a default role for registration

        User savedUser = userService.registerUser(newUser);

        return ResponseEntity.ok("User registered successfully with id: " + savedUser.getUserId());
    }
}
