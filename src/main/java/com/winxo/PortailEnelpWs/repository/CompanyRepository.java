package com.winxo.PortailEnelpWs.repository;

import com.winxo.PortailEnelpWs.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findCompanyById(Integer id);
}
