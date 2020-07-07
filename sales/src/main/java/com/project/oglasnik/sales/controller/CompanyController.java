package com.project.oglasnik.sales.controller;

import com.project.oglasnik.sales.domain.repository.CompanyRepository;
import com.project.oglasnik.sales.domain.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import com.project.oglasnik.sales.domain.events.CompanyCreated;

import java.time.Instant;
import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;
    ApplicationEventPublisher eventPublisher;

    @RequestMapping("/companies")
    public List<Company> getCompanies()
    {
        return companyRepository.findAll();
    }

    @RequestMapping("/company/{companyId}")
    public Company getCompany(@PathVariable int companyId) {
        return companyRepository.findByCompanyId(companyId);
    }

    @RequestMapping(method= RequestMethod.POST, value="/companies")
    public void addCompany(@RequestBody Company company) {
        eventPublisher.publishEvent(new CompanyCreated(company.getId(), Instant.now()));
        companyRepository.save(company);
    }

    @PutMapping("/company/{companyId}")
    public void updateCompany(@PathVariable int companyId, @RequestBody Company company) {
        Company newCompany = companyRepository.findByCompanyId(companyId);
        newCompany.setName(company.getName());
        if(company.getOccupation()!= null) {
            newCompany.setOccupation(company.getOccupation());
        }
        newCompany.setTaxNumber(company.getTaxNumber());
        newCompany.setAddress(company.getAddress());
        newCompany.setEmail(company.getEmail());
        newCompany.setApproved(company.getApproved());
        if(company.getSellers()!= null) {
            newCompany.setSellers(company.getSellers());
        }

        companyRepository.save(newCompany);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/company/{companyId}")
    public void deleteCompany(@PathVariable int companyId, @RequestBody Company company) {
        Company newCompany = companyRepository.findByCompanyId(companyId);
        companyRepository.delete(newCompany);
    }
}