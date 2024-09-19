package com.tegshigzugder.explorenote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tegshigzugder.explorenote.model.User;
import com.tegshigzugder.explorenote.repository.SqliteRepository;
import com.tegshigzugder.explorenote.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private SqliteRepository sqliteRepository;

    @Autowired
    private UserRepository userRepository;

    public User createUser(String username, String email, String password) {
        var user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPasswordHash(password);
        // sqliteRepository.createUser(username, email, password);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User updatedUser) {
        return userRepository.save(updatedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}