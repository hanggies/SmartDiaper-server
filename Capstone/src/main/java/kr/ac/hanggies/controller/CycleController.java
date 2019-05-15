package kr.ac.hanggies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hanggies.dao.PatientDao;
import kr.ac.hanggies.model.Patient;
import kr.ac.hanggies.service.FcmService;

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
					fcmService.sendPush(patients.get(i).getRoom() + "호실 " + patients.get(i).getName() + "환자 분 기저귀 교체 바랍니다.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
        	}
        }
        return "home";
    }
}

/*List<BookDTO> items = bookService.bookList();
JSONArray jArray = new JSONArray(); // json배열
for(int i=0; i<items.size(); i++){
    BookDTO dto = items.get(i);
    JSONObject row = new JSONObject();
    // json객체.put("변수명",값)
    row.put("book_code", dto.getBook_code());
    row.put("book_name", dto.getBook_name());
    row.put("press", dto.getPress());
    row.put("price", dto.getPrice());
    row.put("amount", dto.getAmount());
    // 배열에 추가
    // json배열.add(인덱스,json객체)
    jArray.add(i,row);
}
// json객체에 배열을 넣음
jsonMain.put("sendData", jArray);*/
