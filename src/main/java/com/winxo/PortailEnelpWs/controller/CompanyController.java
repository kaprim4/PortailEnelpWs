package com.winxo.PortailEnelpWs.controller;

import com.winxo.PortailEnelpWs.entities.Company;
import com.winxo.PortailEnelpWs.repository.CompanyRepository;
import com.winxo.PortailEnelpWs.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompanies () {
        List<Company> companies = companyService.findAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        company.setIsDeleted(false);
        Company user_added = companyService.addCompany(company);
        System.out.println(user_added);
        return new ResponseEntity<>(user_added, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Company> getCompanyById (@PathVariable("id") Integer id) {
        Optional<Company> userOptional = companyRepository.findById(id);
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Company user_found = companyService.findCompanyById(id);
        return new ResponseEntity<>(user_found, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        Optional<Company> userOptional = companyRepository.findCompanyById(company.getId());
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        company.setIsDeleted(false);
        companyRepository.save(company);
        System.out.println(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable("id") Integer id) {
        Optional<Company> companyOptional = companyRepository.findCompanyById(id);
        if (companyOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        companyService.deleteCompany(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
