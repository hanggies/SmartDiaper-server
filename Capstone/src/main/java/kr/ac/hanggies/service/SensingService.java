package kr.ac.hanggies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hanggies.dao.SensingDao;

@Service
public class SensingService {

	@Autowired
	private SensingDao sensingDao;

	public boolean updateSensingState(String sid) {
		
		return sensingDao.updateSensingState(sid);
	}
	
}
