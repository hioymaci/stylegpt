package com.oymaci.stylegpt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Generates getters, setters, equals, hashCode, and toString methods
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields
//TODO add mapper
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String password; // Ensure not to expose this in responses
}

