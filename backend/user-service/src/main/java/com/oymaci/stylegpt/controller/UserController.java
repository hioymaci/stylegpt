package com.oymaci.stylegpt.controller;

import com.oymaci.stylegpt.dto.UserDTO;
import com.oymaci.stylegpt.entity.User;
import com.oymaci.stylegpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        User savedUser = userService.createUser(user);

        // Create a new UserDTO to return without exposing the password
        UserDTO responseDTO = new UserDTO(savedUser.getId(), savedUser.getFullName(), savedUser.getEmail(), null);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        UserDTO userDTO = new UserDTO(user.getId(), user.getFullName(), user.getEmail(), null);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers().stream()
                .map(user -> new UserDTO(user.getId(), user.getFullName(), user.getEmail(), null))
                .collect(Collectors.toList()));
    }
}
