package kr.ac.hanggies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hanggies.dao.SensingDao;


@Service
public class SensingService {

	@Autowired
	private SensingDao sensingDao;

	public boolean updateSensingState(String sid, String signal) {
		
		return sensingDao.updateSensingState(sid, signal);
	}
	
}
