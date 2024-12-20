package org.example.javaLab.service.mapper;

import org.example.javaLab.dto.PaymentAccountDto;
import org.example.javaLab.entity.PaymentAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentAccountMapper {

    @Mapping(source = "bank.id", target = "bankId")
    @Mapping(source = "user.id", target = "userId")
    PaymentAccountDto toDto(PaymentAccount paymentAccount);

}
