package com.marketing1.service;

import java.util.List;

import com.marketing1.entities.Lead;

public interface LeadService {
	public void saveReg(Lead lead);

	public List<Lead> findAllLeads();

	public void deleteById(long id);

	public Lead findLeadById(long id);
}
