package org.example.javaLab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentAccountDto {
    private Long id;

    private Long userId;

    private Long bankId;

    private Integer amount;
}
