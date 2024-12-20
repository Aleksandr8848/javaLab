package org.example.javaLab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank_office")
public class BankOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Bank bank;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private Boolean canPlaceAtm;

    @Column(nullable = false)
    private Integer countOfAtms;

    @Column(nullable = false)
    private Boolean canIssueLoan;

    @Column(nullable = false)
    private Boolean isIssuingMoney;

    @Column(nullable = false)
    private Boolean isDepositingMoney;

    @Column(nullable = false)
    private Integer amountOfMoney;

    @Column(nullable = false)
    private Integer rentalCost;
}
