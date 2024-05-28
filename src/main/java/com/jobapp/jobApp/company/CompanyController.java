package com.jobapp.jobApp.company;

import org.apache.catalina.connector.Response;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	private CompanyService companyService;
	
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	@GetMapping
	public ResponseEntity<List<Company>> getAll(){
		return new ResponseEntity<>(companyService.getAll(), HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company){
		companyService.updateCompany(id,company);
		return new ResponseEntity<>("Company Updated Successfully",HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody Company company){
		companyService.createCompany(company);
		return new ResponseEntity<>("Company Created Successfully",HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id){
		boolean isDeleted=companyService.deleteCompanyById(id);
		if(isDeleted){
			return new ResponseEntity<>("Company Deleted Successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Company Not Found",HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
		Company company=companyService.getById(id);
		if(company!=null){
			return new ResponseEntity<>(company,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
