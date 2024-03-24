package com.example.VideoCall.service;


import com.example.VideoCall.entity.User;

public interface UserService {
    User registerUser(User user);

    User loginUser(String username, String password);

    User findByUsername(String username);
}
