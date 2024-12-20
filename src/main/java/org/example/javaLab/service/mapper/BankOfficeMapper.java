package org.example.javaLab.service.mapper;

import org.example.javaLab.dto.BankOfficeDto;
import org.example.javaLab.entity.BankOffice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BankOfficeMapper {

    @Mapping(source = "bank.name", target = "bankName")
    BankOfficeDto toDto(BankOffice bankOffice);

}
