package com.grocery.booking.Service;

import com.grocery.booking.Model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long userId);
    User createUser(User user);
    User updateUserAttributes(Long userId, User updatedUser);
    void deleteUser(Long userId);
}
