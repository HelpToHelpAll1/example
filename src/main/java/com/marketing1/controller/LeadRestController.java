package com.marketing1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing1.dto.LeadDto;
import com.marketing1.entities.Lead;
import com.marketing1.repositories.LeadRepository;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {

	@Autowired
	LeadRepository leadRepo;
	
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	//localhost:8080/api/leads/{id}
	
	@DeleteMapping("/{id}")
	public void DeleteOneLeadById(@PathVariable("id") long id) {
		leadRepo.deleteById(id);
	}
	
	//Update A Records
	@PutMapping
	public void UpdateOneLead(@RequestBody LeadDto leadDto) {
		Lead lead = new Lead();
		lead.setId(leadDto.getId());
		lead.setFirstName(leadDto.getFirstName());
		lead.setLastName(leadDto.getLastName());
		lead.setEmail(leadDto.getEmail());
		lead.setMobile(leadDto.getMobile());
		leadRepo.save(lead);
	}
	
	//Get lead By ID
	
	// localhost:8080/api/leads/{id}
	@GetMapping("/{id}")
	public Lead getLeadById(@PathVariable("id") long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
}
