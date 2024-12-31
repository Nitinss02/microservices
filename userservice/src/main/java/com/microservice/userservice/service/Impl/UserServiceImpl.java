package com.microservice.userservice.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.userservice.Entity.User;
import com.microservice.userservice.Exceptions.ResourceNotFound;
import com.microservice.userservice.Repository.UserRepository;
import com.microservice.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getUser() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User updateUser(String userId, User user) {
        User newUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("User is not found with given id"));
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setAbout(user.getAbout());
        User updatedUser = userRepository.save(newUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("User is not found with given id"));
        userRepository.delete(user);
    }

}
