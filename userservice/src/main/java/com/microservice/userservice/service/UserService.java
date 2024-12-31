package com.microservice.userservice.service;

import java.util.List;

import com.microservice.userservice.Entity.User;

public interface UserService {
    public User saveUser(User user);

    public List<User> getUser();

    public User updateUser(String userId, User user);

    public void deleteUser(String userId);
}
