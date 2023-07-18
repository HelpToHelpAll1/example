package com.marketing1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing1.entities.Lead;
import com.marketing1.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService{

	@Autowired
	LeadRepository leadRepo;
	
	@Override
	public void saveReg(Lead lead) {
		leadRepo.save(lead);
		
	}

	@Override
	public List<Lead> findAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteById(long id) {
		leadRepo.deleteById(id);
	}

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		
		return lead;
	}

}
