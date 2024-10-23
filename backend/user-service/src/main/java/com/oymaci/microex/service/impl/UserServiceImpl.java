package com.oymaci.microex.service.impl;

import com.oymaci.microex.entity.User;
import com.oymaci.microex.exception.ResourceNotFoundException;
import com.oymaci.microex.repository.UserRepository;
import com.oymaci.microex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public User createUser(User user) {
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User inputUser) {
        return userRepository.findById(id).map(user -> {
            user.setFullName(inputUser.getFullName());
            user.setEmail(inputUser.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public boolean deleteUser(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
