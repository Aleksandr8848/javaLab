package org.example.javaLab.service;

import org.example.javaLab.dto.PaymentAccountDto;
import org.example.javaLab.entity.PaymentAccount;


public interface PaymentAccountService {
    PaymentAccountDto createPaymentAccount(Long userId, Long bankId);

    PaymentAccount getPaymentAccountById(Long id);

    PaymentAccountDto getPaymentAccountByIdDto(Long id);

    PaymentAccountDto updatePaymentAccount(Long id, Integer amount);

    void deletePaymentAccount(Long id);
}
