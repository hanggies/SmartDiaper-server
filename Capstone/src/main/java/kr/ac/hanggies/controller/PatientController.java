package kr.ac.hanggies.controller;

import java.util.Date;
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
import kr.ac.hanggies.service.HistoryService;
import kr.ac.hanggies.service.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private HistoryService historyService;
	
	@RequestMapping("/allPatients")
	public String getAllPatients(Model model) {
		List<Patient> patients = patientService.getAllPatients();
		model.addAttribute("patients", patients);
		
		return "patients";
	}
	
	@RequestMapping("/roomPatients/{room}")
	public String getRoomPatients(@PathVariable("room") String room, Model model) {
		List<Patient> patients = patientService.getRoomPatients(room);
		model.addAttribute("patients", patients);
		model.addAttribute("roomNumber", patients.get(0).getRoom());
		return "patients";
	}
	
	@RequestMapping(value = "/updatePatient/{sid}", method = RequestMethod.GET)
	public String updatePatient(@PathVariable String sid, Model model) {

		Patient patient = patientService.getPatientById(sid);

		model.addAttribute("patient", patient);

		return "updatePatient";
	}

	@RequestMapping(value = "/updatePatient", method = RequestMethod.POST)
	public String updatePatientPost(@Valid Patient patient, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors)
				System.out.println(error.getDefaultMessage());

			return "updatePatient";
		}

		if (!patientService.updatePatient(patient))
			System.out.println("Updating patient cannot be done");

		return "redirect:/allPatients";
	}
	
	@RequestMapping(value = "/addPatient", method = RequestMethod.GET)
	public String addPatient(Model model) {

		Patient patient = new Patient();

		model.addAttribute("patient", patient);

		return "addPatient";
	}
	
	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
	public String addPatientPost(@Valid Patient patient, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors)
				System.out.println(error.getDefaultMessage());

			return "addPatient";
		}
		String sid = patient.getSid();
		String signal = "등록";
		if (!(patientService.addPatient(patient)&&historyService.addHistory(sid, signal)))
			System.out.println("Adding patient cannot be done");

		return "redirect:/allPatients";
	}
	
	@RequestMapping(value = "/deletePatient/{sid}", method = RequestMethod.GET)
	public String deletePatient(@PathVariable String sid) {

		if (!patientService.deletePatient(sid))
			System.out.println("Deleting patient cannot be done");

		return "redirect:/allPatients";
	}
}
