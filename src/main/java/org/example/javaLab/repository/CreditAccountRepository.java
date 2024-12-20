package org.example.javaLab.repository;

import org.example.javaLab.entity.CreditAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditAccountRepository extends JpaRepository<CreditAccount, Long> {
}
