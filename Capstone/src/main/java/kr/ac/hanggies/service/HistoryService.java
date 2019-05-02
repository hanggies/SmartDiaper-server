package kr.ac.hanggies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hanggies.dao.HistoryDao;
import kr.ac.hanggies.model.History;

@Service
public class HistoryService {
	
	@Autowired
	private HistoryDao historyDao;
	
	public boolean addHistory(String sid, String signal) {
		
		return historyDao.addHistory(sid, signal);
	}
	
	public List<History> getAllHistory(){
		return historyDao.getAllHistory();
	}
	
	public List<History> getHistoryById(String sid) {
		return historyDao.getHistoryById(sid);
	}

}
