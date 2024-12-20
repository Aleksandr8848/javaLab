package org.example.javaLab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.javaLab.dto.BankDto;
import org.example.javaLab.entity.Bank;
import org.example.javaLab.service.BankService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService;

    // создание банка
    @Operation(summary = "Создание банка")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Банк создан",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankDto.class))})
    })

    @PostMapping
    public BankDto createBank(@Parameter(description = "Название банка") @RequestParam("name") String name) {
        return bankService.createBank(name);
    }

    // поиск банка по ID
    @Operation(summary = "Поиск банка по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Банк найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankDto.class))})
    })

    @GetMapping("/{id}")
    public BankDto getBankById(@Parameter(description = "ID банка") @PathVariable("id") Long id) {
        return bankService.getBankByIdDto(id);
    }

    // изменение данных в банке
    @Operation(summary = "Изменение данных в банке по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные изменены",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankDto.class))})
    })

    @PatchMapping("/{id}")
    public BankDto updateBank(@Parameter(description = "ID банка") @PathVariable("id") Long id,
                           @RequestParam("name") String name) {
        return bankService.updateBank(id, name);
    }

    // удаление банка
    @Operation(summary = "Удаление банка")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Банк удален",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankDto.class))})
    })

    @DeleteMapping("/{id}")
    public Bank deleteBank(@Parameter(description = "ID банка") @PathVariable("id") Long id) {
        bankService.deleteBank(id);
        return null;
    }

}
