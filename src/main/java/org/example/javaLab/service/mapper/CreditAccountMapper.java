package org.example.javaLab.service.mapper;

import org.example.javaLab.dto.CreditAccountDto;
import org.example.javaLab.entity.CreditAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreditAccountMapper {

    @Mapping(source = "user.fullName", target = "userName")
    @Mapping(source = "bank.name", target = "bankName")
    @Mapping(source = "issuingEmployee.fullName", target = "issuingEmployeeName")
    @Mapping(source = "paymentAccount.amount", target = "paymentAccountAmount")
    CreditAccountDto toDto(CreditAccount creditAccount);

}
