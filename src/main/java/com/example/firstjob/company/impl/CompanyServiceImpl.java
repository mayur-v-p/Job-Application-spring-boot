package com.example.firstjob.company.impl;

import com.example.firstjob.company.Company;
import com.example.firstjob.company.CompanyRepositery;
import com.example.firstjob.company.CompanyService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyServiceImpl implements CompanyService {


    private CompanyRepositery companyRepositery;

    public CompanyServiceImpl(CompanyRepositery companyRepositery) {
        this.companyRepositery = companyRepositery;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepositery.findAll();
    }

    @Override
    public Boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepositery.findById(id);
        if (companyOptional.isPresent()){
            Company companyToUpdate = companyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(company.getName());
            companyToUpdate.setJobs(company.getJobs());
            companyRepositery.save(companyToUpdate);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public void createCompany(Company company) {

        companyRepositery.save(company);
    }

    @Override
    public boolean deleteComp(Long id) {

        companyRepositery.deleteById(id);
        return true;
    }

    @Override
    public Company companyById(Long id) {

        Optional<Company> comp = companyRepositery.findById(id);
        return comp.orElse(null);

    }
}
