package com.grocery.booking.Controller.Impl;


import com.grocery.booking.Enum.Role;
import com.grocery.booking.Model.RegistrationRequest;
import com.grocery.booking.Model.User;
import com.grocery.booking.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegistrationController {

    @Autowired
    private  UserService userService;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        User savedUser = userService.createUser(user);

        return ResponseEntity.ok("User registered successfully with user id: " + savedUser.getUserId());
    }
}
