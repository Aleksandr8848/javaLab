package org.example.javaLab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String position;

    @ManyToOne
    private Bank bank;

    @Column(nullable = false)
    private Boolean isRemote;

    @ManyToOne
    private BankOffice office;

    @Column(nullable = false)
    private Boolean canIssueLoans;

    @Column(nullable = false)
    private Integer salary;
}
