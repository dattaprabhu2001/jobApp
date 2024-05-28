package com.jobapp.jobApp.company.Impl;

import com.jobapp.jobApp.company.Company;
import com.jobapp.jobApp.company.CompanyRepository;
import com.jobapp.jobApp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
	private CompanyRepository companyRepository;
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	@Override
	public List<Company> getAll() {
		return companyRepository.findAll();
	}
	
	@Override
	public boolean updateCompany(Long id, Company company) {
		Optional<Company> companyOptional = companyRepository.findById(id);
		if (companyOptional.isPresent()) {
			Company updatedCompany = companyOptional.get();
			updatedCompany.setDescription(company.getDescription());
			updatedCompany.setName(company.getName());
			updatedCompany.setJobs(company.getJobs());
			companyRepository.save(updatedCompany);
			return true;
		}
		return false;
	}
	
	@Override
	public void createCompany(Company company) {
		companyRepository.save(company);
	}
	
	@Override
	public boolean deleteCompanyById(Long id) {
		if (companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public Company getById(Long id) {
		Company company=companyRepository.findById(id).orElse(null);
		return company;
	}
}
