package org.example.javaLab.repository;

import org.example.javaLab.entity.BankAtm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAtmRepository extends JpaRepository<BankAtm, Long> {
}
