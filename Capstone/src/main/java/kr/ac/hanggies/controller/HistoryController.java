package kr.ac.hanggies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hanggies.model.History;
import kr.ac.hanggies.service.HistoryService;

@Controller
public class HistoryController {
	@Autowired
	private HistoryService historyService;

	@RequestMapping("/allHistory")
	public String getAllHistory(Model model) {
		List<History> history = historyService.getAllHistory();
		model.addAttribute("allHistory", history);

		return "allHistory";
	}

	@RequestMapping("/history/{sid}")
	public String getHistoryById(@PathVariable("histoty") String room, Model model) {
		List<History> history = historyService.getHistoryById(room);
		model.addAttribute("allHistory", history);
		return "patients";
	}
}
