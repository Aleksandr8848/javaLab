package org.example.javaLab.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.javaLab.dto.UserDto;
import org.example.javaLab.entity.User;
import org.example.javaLab.repository.UserRepository;
import org.example.javaLab.service.UserService;
import org.example.javaLab.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(String fullName, LocalDate birthDate, String workplace) {
        User user = new User();
        user.setFullName(fullName);
        user.setBirthDate(birthDate);
        user.setWorkplace(workplace);
        user.setMonthlyIncome((int)(Math.random() * 10_000));
        user.setCreditRating((user.getMonthlyIncome() / 1000) * 100);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User repository not found with id " + id));
    }

    @Override
    public UserDto getUserByIdDto(Long id) {
        return userMapper.toDto(getUserById(id));
    }

    @Override
    public UserDto updateUser(Long id, String fullName, String workplace) {
        User user = getUserById(id);
        user.setFullName(fullName);
        user.setWorkplace(workplace);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
