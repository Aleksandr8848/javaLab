package org.example.javaLab.service.mapper;

import org.example.javaLab.dto.BankDto;
import org.example.javaLab.entity.Bank;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankMapper {

    BankDto toDto(Bank bank);

}
