package org.example.javaLab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.javaLab.dto.BankAtmDto;
import org.example.javaLab.entity.BankAtm;
import org.example.javaLab.service.BankAtmService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/bank_atm")
public class BankAtmController {

    private final BankAtmService bankAtmService;

    // создание банкомата
    @Operation(summary = "Создание банкомата")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "банкомат создан",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtmDto.class))})
    })

    @PostMapping
    public BankAtmDto createBankAtm(@RequestParam("name") String name, @RequestParam("address") String address,
                                    @RequestParam("status") Boolean status, @RequestParam("bankId") Long bankId,
                                    @RequestParam("bankOfficeId") Long bankOfficeId,
                                    @RequestParam("employeeId") Long employeeId,
                                    @RequestParam("isIssuingMoney") Boolean isIssuingMoney,
                                    @RequestParam("isDepositingMoney") Boolean isDepositingMoney,
                                    @RequestParam("servicingCost") Integer servicingCost) {
        return bankAtmService.createBankAtm(name, address, status, bankId, bankOfficeId,
                employeeId, isIssuingMoney, isDepositingMoney, servicingCost);
    }

    // поиск банкомата по ID
    @Operation(summary = "Поиск банкомата по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "банкомат найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtmDto.class))})
    })

    @GetMapping("/{id}")
    public BankAtmDto getBankAtmById(@Parameter(description = "ID банкомата") @PathVariable("id") Long id) {
        return bankAtmService.getBankAtmByIdDto(id);
    }

    // изменение данных банкомата
    @Operation(summary = "Изменение данных банкомата по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные изменены",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtm.class))})
    })

    @PatchMapping("/{id}")
    public BankAtmDto updateBankAtm(@PathVariable("id") Long id, @RequestParam("name") String name,
                                 @RequestParam("address") String address, @RequestParam("status") Boolean status,
                                 @RequestParam("bankId") Long bankId, @RequestParam("bankOfficeId") Long bankOfficeId,
                                 @RequestParam("employeeId") Long employeeId,
                                 @RequestParam("isIssuingMoney") Boolean isIssuingMoney,
                                 @RequestParam("isDepositingMoney") Boolean isDepositingMoney,
                                 @RequestParam("servicingCost") Integer servicingCost) {
        return bankAtmService.updateBankAtm(id, name, address, status, bankId, bankOfficeId,
                employeeId, isIssuingMoney, isDepositingMoney, servicingCost);
    }

    // удаление банкомата
    @Operation(summary = "Удаление банкомата")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "банкомат удален",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtm.class))})
    })

    @DeleteMapping("/{id}")
    public BankAtm deleteBankAtm(@Parameter(description = "ID банкомата") @PathVariable("id") Long id) {
        bankAtmService.deleteBankAtm(id);
        return null;
    }
}
