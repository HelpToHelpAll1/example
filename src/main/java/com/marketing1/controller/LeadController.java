package com.marketing1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing1.dto.LeadDto;
import com.marketing1.entities.Lead;
import com.marketing1.service.LeadService;

@Controller
public class LeadController {

	
	@Autowired
	LeadService leadService;
	
		@RequestMapping("/create")     // WebServlet
		public String viewCreateLeadForm() {
			return"create_lead";    //Request Dispacture
		}
		
		@RequestMapping("/saveReg")
		public String saveOneLead(Lead lead) {
			leadService.saveReg(lead);
			System.out.println(lead.getFirstName());
			System.out.println(lead.getLastName());
			System.out.println(lead.getEmail());
			System.out.println(lead.getMobile());
			leadService.saveReg(lead);
			
			return "create_lead";
		}
		
		@RequestMapping("/listall")
		public String getAllLeads(Model model) {
			List<Lead> leads = leadService.findAllLeads();
			System.out.println(leads);
			model.addAttribute("leads", leads);
			return "list_leads";
		}
		
		@RequestMapping("/delete")
		public String deletLeadById(@RequestParam("id") long id,Model model) {
			System.out.println(id);
			leadService.deleteById(id);
			
			List<Lead> leads = leadService.findAllLeads();
			System.out.println(leads);
			model.addAttribute("leads", leads);
			return "list_leads";
		}
		
		@RequestMapping("/update")  //Geeting update Data
		public String updateById(@RequestParam("id") long id,Model model) { //get The Record
			Lead lead = leadService.findLeadById(id);
			model.addAttribute("lead", lead);
			return "update_lead";
		}
		
		@RequestMapping("/editReg")
		public String editReg(LeadDto dto,Model model) {
			Lead l = new Lead();
			
			l.setFirstName(dto.getFirstName());
			l.setLastName(dto.getLastName());
			l.setEmail(dto.getEmail());
			l.setMobile(dto.getMobile());
			
			leadService.saveReg(l);
			List<Lead> leads = leadService.findAllLeads();
			System.out.println(leads);
			model.addAttribute("leads", leads);
			return "list_leads";
		}
		
}
