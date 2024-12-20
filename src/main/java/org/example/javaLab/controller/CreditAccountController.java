package org.example.javaLab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.javaLab.dto.CreditAccountDto;
import org.example.javaLab.entity.CreditAccount;
import org.example.javaLab.service.CreditAccountService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit_account")
public class CreditAccountController {

    private final CreditAccountService creditAccountService;

    // создание кредитного счета
    @Operation(summary = "Создание кредитного счета")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "кредитный счет создан",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreditAccountDto.class))})
    })

    @PostMapping
    public CreditAccountDto createCreditAccount(@RequestParam("userId") Long userId, @RequestParam("bankId") Long bankId,
                                             @RequestParam("startDate") LocalDate startDate,
                                             @RequestParam("endDate") LocalDate endDate,
                                             @RequestParam("loanAmount") Integer loanAmount,
                                             @RequestParam("interestRate") Float interestRate,
                                             @RequestParam("issuingEmployeeId") Long issuingEmployeeId,
                                             @RequestParam("paymentAccountId") Long paymentAccountId) {
        return creditAccountService.createCreditAccount(userId, bankId, startDate, endDate,
                loanAmount, interestRate, issuingEmployeeId, paymentAccountId);
    }

    // поиск кредитного счета по ID
    @Operation(summary = "Поиск кредитного счета по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "кредитный счет найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreditAccountDto.class))})
    })

    @GetMapping("/{id}")
    public CreditAccountDto getCreditAccountById(@Parameter(description = "ID кредитного счета")
                                                  @PathVariable("id") Long id) {
        return creditAccountService.getCreditAccountByIdDto(id);
    }

    // изменение данных кредитного счета
    @Operation(summary = "Изменение данных кредитного счета по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные изменены",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreditAccountDto.class))})
    })

    @PatchMapping("/{id}")
    public CreditAccountDto updateCreditAccount(@PathVariable("id") Long id,
                                        @RequestParam("paymentAccountId") Long paymentAccountId) {
        return creditAccountService.updateCreditAccount(id, paymentAccountId);
    }

    // удаление кредитного счета
    @Operation(summary = "Удаление кредитного счета")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "кредитный счет удален",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreditAccountDto.class))})
    })

    @DeleteMapping("/{id}")
    public CreditAccount deleteCreditAccount(@Parameter(description = "ID кредитного счета")
                                                 @PathVariable("id") Long id) {
        creditAccountService.deleteCreditAccount(id);
        return null;
    }
}
