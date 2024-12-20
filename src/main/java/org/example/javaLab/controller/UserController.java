package org.example.javaLab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.javaLab.dto.UserDto;
import org.example.javaLab.entity.User;
import org.example.javaLab.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // создание пользователя
    @Operation(summary = "Создание пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "пользователь создан",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))})
    })

    @PostMapping
    public UserDto createUser(@RequestParam("fullName") String fullName,
                               @RequestParam("birthDate") LocalDate birthDate,
                               @RequestParam("workplace") String workplace) {
        return userService.createUser(fullName, birthDate, workplace);
    }

    // поиск пользователя по ID
    @Operation(summary = "Поиск пользователя по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "пользователь найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))})
    })

    @GetMapping("/{id}")
    public UserDto getUserById(@Parameter(description = "ID пользователя") @PathVariable("id") Long id) {
        return userService.getUserByIdDto(id);
    }

    // изменение данных пользователя
    @Operation(summary = "Изменение данных пользователя по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные изменены",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))})
    })

    @PatchMapping("/{id}")
    public UserDto updateUser(@PathVariable("id") Long id, @RequestParam("fullName") String fullName,
                           @RequestParam("workplace") String workplace) {
        return userService.updateUser(id, fullName, workplace);
    }

    // удаление пользователя
    @Operation(summary = "Удаление пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "пользователь удален",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))})
    })

    @DeleteMapping("/{id}")
    public User deleteUser(@Parameter(description = "ID пользователя") @PathVariable("id") Long id) {
        userService.deleteUser(id);
        return null;
    }
}
