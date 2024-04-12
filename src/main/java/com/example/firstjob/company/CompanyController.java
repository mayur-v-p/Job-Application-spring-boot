package com.example.firstjob.company;



import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/company")
public class CompanyController {


    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompany();
    }

    @PutMapping("/{id}")
    public String updateCompany(@RequestBody Company company, @PathVariable Long id){

        companyService.updateCompany(company,id);
        return "updates";
    }

    @PostMapping
    public String addCompany(@RequestBody Company company){
        if (company.getName()!=null && company.getDescription()!=null){
            companyService.createCompany(company);
            return "saved";
        }else return "NOttttttt";

    }


    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable Long id){
        boolean yes =  companyService.deleteComp(id);
        if (yes){
            return "delete";
        }else {
            return "not delete";
        }
    }

    @GetMapping("/{id}")
    public Company getCompanyBiId(@PathVariable Long id){
        return companyService.companyById(id);
    }

}
