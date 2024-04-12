package com.example.firstjob.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompany();

    Boolean updateCompany(Company company, Long id);

    void createCompany(Company company);

    boolean deleteComp(Long id);

    Company companyById(Long id);
}
