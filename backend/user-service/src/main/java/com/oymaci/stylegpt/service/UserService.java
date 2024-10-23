package com.oymaci.stylegpt.service;


import com.oymaci.stylegpt.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User userDetails);

    boolean deleteUser(Long id);
}
