package kr.ac.hanggies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hanggies.dao.HistoryDao;

@Service
public class HistoryService {
	
	@Autowired
	private HistoryDao historyDao;
	
	public boolean addHistory(String sid, String signal) {
		
		return historyDao.addProduct(sid, signal);
	}

}
