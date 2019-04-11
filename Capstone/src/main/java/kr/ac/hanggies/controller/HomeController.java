package kr.ac.hanggies.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hanggies.model.State;
import kr.ac.hanggies.service.PatientService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private PatientService patientService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<State> rooms = patientService.getRooms();

		model.addAttribute("rooms", rooms);

		return "home";

	}
}