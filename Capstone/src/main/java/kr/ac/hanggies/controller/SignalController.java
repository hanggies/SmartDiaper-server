package kr.ac.hanggies.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.hanggies.service.ChangeService;
import kr.ac.hanggies.service.FcmService;
import kr.ac.hanggies.service.SensingService;

@Controller
public class SignalController {
	
	@Autowired
	private SensingService sensingService;
	@Autowired
	private ChangeService changeService;
	@Autowired
	private FcmService fcm;
	
	@RequestMapping(value = "/sensing", headers="Accept=*/*", method = RequestMethod.POST, 
			produces = { "application/json" })
	public @ResponseBody String sensingSignal(@RequestBody Map<String, Object> info) {
	
		String sid = (String) info.get("sid");
		String signal = (String) info.get("signal");
		System.out.println("sid: " + sid);
		System.out.println("signal: " + signal);
		
		//sensingservice
		if( !sensingService.updateSensingState(sid) )
			System.out.println("Updating sensing state cannot be done");
		
		try {
			fcm.sendPush("기저귀를 교체해야합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	
	@RequestMapping(value = "/change", headers="Accept=*/*", 
			produces = { "application/json" })
	public @ResponseBody String changeSignal(@RequestBody Map<String, Object> info) {
	
		String sid = (String) info.get("sid");
		String signal = (String) info.get("signal");
		System.out.println("sid: " + sid);
		System.out.println("signal: " + signal);
		
		//sensingservice
		if( !changeService.updateChangeState(sid) )
			System.out.println("Updating change state cannot be done");
		
		return "home";
	}
	
}
