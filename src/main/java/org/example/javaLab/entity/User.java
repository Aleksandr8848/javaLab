package org.example.javaLab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String workplace;

    @Column(nullable = false)
    private Integer monthlyIncome;

    @ManyToMany
    @JoinTable(name = "user_bank", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "bank_id"))
    private List<Bank> banks;

    @OneToMany
    @JoinTable(name = "user_credit_account", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<CreditAccount> creditAccounts;

    @OneToMany
    @JoinTable(name = "user_payment_account", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<PaymentAccount> paymentAccounts;

    @Column(nullable = false)
    private Integer creditRating;
}
