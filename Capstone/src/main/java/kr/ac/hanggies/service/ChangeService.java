package kr.ac.hanggies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hanggies.dao.ChangeDao;

@Service
public class ChangeService {

	@Autowired
	private ChangeDao changeDao;

	public boolean updateChangeState(String sid) {
		
		return changeDao.updateChangeState(sid);
	}
}
