package kr.ac.hanggies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hanggies.model.Patient;
import kr.ac.hanggies.service.PatientService;;

@Controller
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping("/patients")
	public String getProducts(Model model) {
		List<Patient> products = patientService.getPatients();
		
		model.addAttribute("products", products);
		
		return "products";
	}
}
