package kr.ac.hanggies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hanggies.dao.PatientDao;
import kr.ac.hanggies.model.Patient;
import kr.ac.hanggies.service.FcmService;
import kr.ac.hanggies.service.HistoryService;

@Controller

public class CycleController {
	
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private FcmService fcmService;
	
	@RequestMapping(value="/cycle",method=RequestMethod.GET)
    public String changeCheck(){
		
        List<Patient> patients = patientDao.getAllPatients();
        for(int i=0;i<patients.size();i++) {
        	if(patients.get(i).getNeedChange() == 1) {
        		try {
					fcmService.sendPush(patients.get(i).getRoom() + "호실 " + patients.get(i).getName() + "환자 분 기저귀 교체 바랍니다.\n" + "감지 시간 : " + patients.get(i).getTime());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
        	}
        }
        return "home";
    }
}