package com.capgemini.onlinetest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetest.dao.TestRepository;
import com.capgemini.onlinetest.entity.Questions;
import com.capgemini.onlinetest.entity.Test;
import com.capgemini.onlinetest.entity.Userdata;



@Service
@Transactional
public class TestServiceImp implements TestService{
	@Autowired
	TestRepository trep;
	
	@Override
	public Test save(Test t) {
		return trep.save(t);
	}

	@Override
	public Test findOne(int testid) {
		// TODO Auto-generated method stub
		return trep.getOne(testid);
	}
	
	@Override
	public void deleteT(Test t) {
		trep.delete(t);
	}
	
	
	
	
	
	
	
	@Override
	public Test updateTest(Test t) {
		Test tt=trep.getOne(t.getTestId());
		if(tt!=null) {
			tt.setTestTitle(t.getTestTitle());
			tt.setTestMarksScored(t.getTestMarksScored());
			tt.setTestTotalMarks(t.getTestTotalMarks());
			tt.setTestDate(t.getTestDate());
			
		}
		Test t1=trep.save(tt);
		return t1;
		
		
		
	}
	@Override
	public List<Test> getAll() {
		// TODO Auto-generated method stub
		return trep.findAll();
	}
}