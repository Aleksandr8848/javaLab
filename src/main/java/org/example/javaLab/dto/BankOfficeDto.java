package org.example.javaLab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankOfficeDto {
    private Long id;

    private String bankName;

    private String name;

    private String address;

    private Boolean status;

    private Boolean canPlaceAtm;

    private Integer countOfAtms;

    private Boolean canIssueLoan;

    private Boolean isIssuingMoney;

    private Boolean isDepositingMoney;

    private Integer amountOfMoney;

    private Integer rentalCost;
}
