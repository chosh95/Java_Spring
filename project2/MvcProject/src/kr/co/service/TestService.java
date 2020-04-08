package kr.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dao.TestDao;

@Service
public class TestService {

	@Autowired
	private TestDao testDao;
	
	public String testMethod() {
		String str = testDao.test();
		
		return str;
	}
}
