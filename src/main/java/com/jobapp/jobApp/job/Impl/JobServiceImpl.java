package com.jobapp.jobApp.job.Impl;

import com.jobapp.jobApp.job.Job;
import com.jobapp.jobApp.job.JobRepository;
import com.jobapp.jobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
	JobRepository jobRepository;
	
	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}
	//	private List<Job> jobs = new ArrayList<>();
//	private Long nextId = 1L;
	
	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
	}
	
	@Override
	public void createJob(Job job) {
//		job.setId(nextId++);
		jobRepository.save(job);
		
	}
	
	@Override
	public Job getById(Long id) {
		
		return jobRepository.findById(id).orElse(null);
	}
	
	@Override
	public boolean deleteJobById(Long id) {
		try {
			jobRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean updateJob(Long id, Job updatedJob) {
		Optional<Job> jobOptional = jobRepository.findById(id);
		if (jobOptional.isPresent()) {
			Job job = jobOptional.get();
			job.setTitle(updatedJob.getTitle());
			job.setDescription(updatedJob.getDescription());
			job.setLocation(updatedJob.getLocation());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setLocation(updatedJob.getLocation());
			jobRepository.save(job);
			
			return true;
		}
		return false;
	}
}

