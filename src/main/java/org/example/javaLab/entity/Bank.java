package org.example.javaLab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer countOffices;

    @Column(nullable = false)
    private Integer countAtms;

    @Column(nullable = false)
    private Integer countEmployees;

    @Column(nullable = false)
    private Integer countClients;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private Integer totalMoney;

    @Column(nullable = false)
    private Float interestRate;

}
