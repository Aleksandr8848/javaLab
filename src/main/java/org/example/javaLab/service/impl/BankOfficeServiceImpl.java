package org.example.javaLab.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.javaLab.dto.BankOfficeDto;
import org.example.javaLab.entity.Bank;
import org.example.javaLab.entity.BankOffice;
import org.example.javaLab.repository.BankOfficeRepository;
import org.example.javaLab.repository.BankRepository;
import org.example.javaLab.service.BankOfficeService;
import org.example.javaLab.service.BankService;
import org.example.javaLab.service.mapper.BankOfficeMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BankOfficeServiceImpl implements BankOfficeService {

    private final BankOfficeRepository bankOfficeRepository;
    private final BankRepository bankRepository;
    private final BankService bankService;
    private final BankOfficeMapper bankOfficeMapper;

    @Override
    public BankOfficeDto createBankOffice(Long bankId, String name, String address, Boolean status,
                                          Boolean canPlaceAtm, Boolean canIssueLoan, Boolean isIssuingMoney,
                                          Boolean isDepositingMoney, Integer rentalCost) {
        BankOffice bankOffice = new BankOffice();
        Bank bank = bankService.getBankById(bankId);
        bank.setCountOffices(bank.getCountOffices() + 1);
        bankOffice.setBank(bank);
        bankOffice.setName(name);
        bankOffice.setAddress(address);
        bankOffice.setStatus(status);
        bankOffice.setCanPlaceAtm(canPlaceAtm);
        bankOffice.setCountOfAtms((int)(Math.random() * bank.getCountAtms()));
        bankOffice.setCanIssueLoan(canIssueLoan);
        bankOffice.setIsIssuingMoney(isIssuingMoney);
        bankOffice.setIsDepositingMoney(isDepositingMoney);
        bankOffice.setAmountOfMoney((int)(Math.random() * bank.getTotalMoney()));
        bankOffice.setRentalCost(rentalCost);
        bankRepository.save(bank);
        bankOfficeRepository.save(bankOffice);
        return bankOfficeMapper.toDto(bankOffice);
    }

    @Override
    public BankOffice getBankOfficeById(Long id) {
        return bankOfficeRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Bank Office not found with id " + id));
    }

    @Override
    public BankOfficeDto getBankOfficeByIdDto(Long id) {
        return bankOfficeMapper.toDto(getBankOfficeById(id));
    }

    @Override
    public BankOfficeDto updateBankOffice(Long id, Long bankId, String name, String address, Boolean status,
                                 Boolean canPlaceAtm, Boolean canIssueLoan, Boolean isIssuingMoney,
                                 Boolean isDepositingMoney, Integer rentalCost) {
        BankOffice bankOffice = getBankOfficeById(id);
        bankOffice.setBank(bankService.getBankById(bankId));
        bankOffice.setName(name);
        bankOffice.setAddress(address);
        bankOffice.setStatus(status);
        bankOffice.setCanPlaceAtm(canPlaceAtm);
        bankOffice.setCanIssueLoan(canIssueLoan);
        bankOffice.setIsIssuingMoney(isIssuingMoney);
        bankOffice.setIsDepositingMoney(isDepositingMoney);
        bankOffice.setRentalCost(rentalCost);
        bankOfficeRepository.save(bankOffice);
        return bankOfficeMapper.toDto(bankOffice);
    }

    @Override
    public void deleteBankOffice(Long id) {
        BankOffice bankOffice = getBankOfficeById(id);
        Bank bank = bankOffice.getBank();
        bank.setCountOffices(bank.getCountOffices() - 1);
        bankRepository.save(bank);
        bankOfficeRepository.deleteById(id);
    }
}
