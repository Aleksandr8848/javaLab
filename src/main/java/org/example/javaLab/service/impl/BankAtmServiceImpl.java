package org.example.javaLab.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.javaLab.dto.BankAtmDto;
import org.example.javaLab.entity.*;
import org.example.javaLab.repository.BankAtmRepository;
import org.example.javaLab.repository.BankRepository;
import org.example.javaLab.service.BankAtmService;
import org.example.javaLab.service.BankOfficeService;
import org.example.javaLab.service.BankService;
import org.example.javaLab.service.EmployeeService;
import org.example.javaLab.service.mapper.BankAtmMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAtmServiceImpl implements BankAtmService {

    private final BankAtmRepository bankAtmRepository;
    private final BankRepository bankRepository;
    private final BankService bankService;
    private final BankOfficeService bankOfficeService;
    private final EmployeeService employeeService;
    private final BankAtmMapper bankAtmMapper;

    @Override
    public BankAtmDto createBankAtm(String name, String address, Boolean status, Long bankId,
                                    Long bankOfficeId, Long employeeId, Boolean isIssuingMoney,
                                    Boolean isDepositingMoney, Integer servicingCost) {
        BankAtm bankAtm = new BankAtm();
        bankAtm.setName(name);
        bankAtm.setAddress(address);
        bankAtm.setStatus(status);
        Bank bank = bankService.getBankById(bankId);
        bank.setCountAtms(bank.getCountAtms() + 1);
        bankAtm.setBank(bank);
        bankAtm.setLocation(bankOfficeService.getBankOfficeById(bankOfficeId));
        bankAtm.setServicingEmployee(employeeService.getEmployeeById(employeeId));
        bankAtm.setIsIssuingMoney(isIssuingMoney);
        bankAtm.setIsDepositingMoney(isDepositingMoney);
        bankAtm.setAmountOfMoney((int)(Math.random() * bank.getTotalMoney()));
        bankAtm.setServicingCost(servicingCost);
        bankRepository.save(bank);
        bankAtmRepository.save(bankAtm);
        return bankAtmMapper.toDto(bankAtm);
    }

    @Override
    public BankAtm getBankAtmById(Long id) {
        return bankAtmRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Bank Atm not found with id " + id));
    }

    public BankAtmDto getBankAtmByIdDto(Long id) {
        return bankAtmMapper.toDto(getBankAtmById(id));
    }



    @Override
    public BankAtmDto updateBankAtm(Long id, String name, String address, Boolean status, Long bankId,
                              Long bankOfficeId, Long employeeId, Boolean isIssuingMoney,
                              Boolean isDepositingMoney, Integer servicingCost) {
        BankAtm bankAtm = getBankAtmById(id);
        bankAtm.setName(name);
        bankAtm.setAddress(address);
        bankAtm.setStatus(status);
        Bank bank = bankService.getBankById(bankId);
        bankAtm.setBank(bank);
        bankAtm.setLocation(bankOfficeService.getBankOfficeById(bankOfficeId));
        bankAtm.setServicingEmployee(employeeService.getEmployeeById(employeeId));
        bankAtm.setIsIssuingMoney(isIssuingMoney);
        bankAtm.setIsDepositingMoney(isDepositingMoney);
        bankAtm.setServicingCost(servicingCost);
        bankAtmRepository.save(bankAtm);
        return bankAtmMapper.toDto(bankAtm);
    }

    @Override
    public void deleteBankAtm(Long id) {
        BankAtm bankAtm = getBankAtmById(id);
        Bank bank = bankAtm.getBank();
        bank.setCountAtms(bank.getCountAtms() - 1);
        bankRepository.save(bank);
        bankAtmRepository.deleteById(id);
    }
}
