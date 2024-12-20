package org.example.javaLab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String fullName;

    private LocalDate birthDate;

    private String workplace;

    private Integer monthlyIncome;

    private List<String> bankNames;

    private List<Long> creditAccountsId;

    private List<Long> paymentAccountsId;

    private Integer creditRating;
}
