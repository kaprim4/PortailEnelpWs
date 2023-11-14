package com.winxo.PortailEnelpWs.service;

import com.winxo.PortailEnelpWs.entities.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAllCompanies();

    Company findCompanyById(Integer id);

    Company addCompany(Company role);

    Company updateCompany(Company role);

    void deleteCompany(Integer id);
}
