package org.example.javaLab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank_atm")
public class BankAtm {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Boolean status;

    @ManyToOne
    private Bank bank;

    @ManyToOne
    private BankOffice location;

    @ManyToOne
    private Employee servicingEmployee;

    @Column(nullable = false)
    private Boolean isIssuingMoney;

    @Column(nullable = false)
    private Boolean isDepositingMoney;

    @Column(nullable = false)
    private Integer amountOfMoney;

    @Column(nullable = false)
    private Integer servicingCost;
}

