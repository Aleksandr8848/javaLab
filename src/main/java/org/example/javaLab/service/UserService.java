package org.example.javaLab.service;


import org.example.javaLab.dto.UserDto;
import org.example.javaLab.entity.User;

import java.time.LocalDate;

public interface UserService {
    UserDto createUser(String fullName, LocalDate birthDate, String workplace);

    User getUserById(Long id);

    UserDto getUserByIdDto(Long id);

    UserDto updateUser(Long id, String fullName, String workplace);

    void deleteUser(Long id);
}
