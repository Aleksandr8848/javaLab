package org.example.javaLab.repository;

import org.example.javaLab.entity.BankOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankOfficeRepository extends JpaRepository<BankOffice, Long> {
}
