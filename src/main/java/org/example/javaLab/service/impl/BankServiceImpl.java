package org.example.javaLab.service.impl;


import lombok.RequiredArgsConstructor;
import org.example.javaLab.dto.BankDto;
import org.example.javaLab.entity.Bank;
import org.example.javaLab.repository.BankRepository;
import org.example.javaLab.service.BankService;
import org.example.javaLab.service.mapper.BankMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;
    private final BankMapper bankMapper;

    @Override
    public BankDto createBank(String name) {
        Bank bank = new Bank();
        bank.setName(name);
        bank.setCountOffices(0);
        bank.setCountAtms(0);
        bank.setCountEmployees(0);
        bank.setCountClients(0);
        bank.setRating((int)(Math.random() * 101));
        bank.setTotalMoney((int)(Math.random() * 1_000_001));
        bank.setInterestRate((float)(Math.random() * (20 - (bank.getRating() / 5.0)) + 1));
        bankRepository.save(bank);
        return bankMapper.toDto(bank);
    }

    @Override
    public Bank getBankById(Long id) {
        return bankRepository.findById(id).orElseThrow(() -> new RuntimeException("Bank not found with id " + id));
    }

    @Override
    public BankDto getBankByIdDto(Long id) {
        return bankMapper.toDto(getBankById(id));
    }

    @Override
    public BankDto updateBank(Long id, String name) {
        Bank bank = getBankById(id);
        bank.setName(name);
        bankRepository.save(bank);
        return bankMapper.toDto(bank);
    }

    @Override
    public void deleteBank(Long id) {
        bankRepository.deleteById(id);
    }
}
