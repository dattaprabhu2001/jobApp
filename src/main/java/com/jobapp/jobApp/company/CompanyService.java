package com.jobapp.jobApp.company;

import java.util.List;

public interface CompanyService {
	List<Company> getAll();
	boolean updateCompany(Long id,Company company);
	void createCompany(Company company);
	boolean deleteCompanyById(Long id);
	
	Company getById(Long id);
	
}
