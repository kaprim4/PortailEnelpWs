package com.winxo.PortailEnelpWs.service.impl;

import com.winxo.PortailEnelpWs.entities.Company;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.CompanyRepository;
import com.winxo.PortailEnelpWs.service.CompanyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService
{

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company findCompanyById(Integer id) {
        return companyRepository
                .findCompanyById(id)
                .orElseThrow(() -> new NotFoundException("Company by id " + id + " was not found"));
    }

    public void deleteCompany(Integer id) {
        companyRepository.deleteById(id);
    }
}
