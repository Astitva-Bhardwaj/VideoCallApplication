package com.example.VideoCall.service.impl;

import com.example.VideoCall.entity.User;
import com.example.VideoCall.repo.UserRepository;
import com.example.VideoCall.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        log.info("UserServiceImpl ---- UserServiceImpl");
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; // Return null if login fails
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
