package org.example.javaLab.service;

import org.example.javaLab.dto.BankDto;
import org.example.javaLab.entity.Bank;

public interface BankService {

    BankDto createBank(String bankName);

    Bank getBankById(Long id);

    BankDto getBankByIdDto(Long id);

    BankDto updateBank(Long id, String name);

    void deleteBank(Long id);
}
