package com.grocery.booking.Service.Impl;

import com.grocery.booking.Model.User;
import com.grocery.booking.Repository.UserRepository;
import com.grocery.booking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class UserServiceImpl implements UserService {

        @Autowired
        private UserRepository userRepository;

        @Override
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        @Override
        public User getUserById(Long userId) {
            Optional<User> optionalUser = userRepository.findById(userId);
            return optionalUser.orElse(null);
        }

        @Override
        public User createUser(User user) {
            return userRepository.save(user);
        }


    @Override
    public User updateUserAttributes(Long userId, User updatedUser) {
        User existingUser = getUserById(userId);
        if (existingUser != null) {
            // Update attributes that are allowed to be modified
            existingUser.setEmailId(updatedUser.getEmailId());
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setRole(updatedUser.getRole());

            // Save the updated user
            return userRepository.save(existingUser);
        }
        return null; // User not found
    }

        @Override
        public void deleteUser(Long userId) {
            userRepository.deleteById(userId);
        }
}
