package kr.ac.hanggies.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hanggies.model.Patient;
import kr.ac.hanggies.service.PatientService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PatientService patientService;

	@RequestMapping
	public String adminPage() {
		return "admin";
	}

/*	@RequestMapping("/patientInventory")
	public String getPatients(Model model) { // controller -> model -> view
		List<Patient> patients = produceService.getPatients();
		model.addAttribute("patients", patients);

		return "patientInventory";
	}

	@RequestMapping(value = "/patientInventory/addPatient", method = RequestMethod.GET)
	public String addPatient(Model model) {

		Patient patient = new Patient();

		model.addAttribute("patient", patient);

		return "addPatient";
	}

	@RequestMapping(value = "/patientInventory/addPatient", method = RequestMethod.POST)
	public String addPatientPost(@Valid Patient patient, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors)
				System.out.println(error.getDefaultMessage());

			return "addPatient";
		}

		if (!produceService.addPatient(patient))
			System.out.println("Adding patient cannot be done");

		return "redirect:/admin/patientInventory";
	}

	@RequestMapping(value = "/patientInventory/deletePatient/{id}", method = RequestMethod.GET)
	public String deletePatient(@PathVariable int id) {

		if (!produceService.deletePatient(id))
			System.out.println("Deleting patient cannot be done");

		return "redirect:/admin/patientInventory";
	}

	@RequestMapping(value = "/patientInventory/updatePatient/{id}", method = RequestMethod.GET)
	public String updatePatient(@PathVariable int id, Model model) {

		Patient patient = produceService.getPatientById(id);

		model.addAttribute("patient", patient);

		return "updatePatient";
	}

	@RequestMapping(value = "/patientInventory/updatePatient", method = RequestMethod.POST)
	public String updatePatientPost(@Valid Patient patient, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors)
				System.out.println(error.getDefaultMessage());

			return "updatePatient";
		}

		if (!produceService.updatePatient(patient))
			System.out.println("Updating patient cannot be done");

		return "redirect:/admin/patientInventory";
	}*/
}
