
package com.capgemini.onlinetest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetest.dao.QuestionsRepository;
import com.capgemini.onlinetest.dao.TestRepository;
import com.capgemini.onlinetest.entity.Questions;
import com.capgemini.onlinetest.entity.Test;



@Service
@Transactional
public class QuestionsServiceImp implements QuestionsService{
	@Autowired
	QuestionsRepository qrep;
	@Autowired
	TestRepository trep;
	
	@Override
	public Questions save(Questions q) {
		return qrep.save(q);
	}

	@Override
	public Questions findOne(int qid) {
		return qrep.getOne(qid);
	}

	@Override
	public Optional<Questions> findQuestionById(int qid) {
		return qrep.findById(qid);
	}

	@Override
	public void deleteQ(Questions q) {
		qrep.delete(q);
	}

	@Override
	public List<Questions> getAll() {
		return qrep.findAll();
	}

	@Override
	public Questions updateQuestion(Questions q) {
		Questions qt=qrep.getOne(q.getQuestionId());
		if(qt!=null) {
			qt.setQuestionTitle(q.getQuestionTitle());
			qt.setOptionOne(q.getOptionOne());
			qt.setOptionTwo(q.getOptionTwo());
			qt.setOptionThree(q.getOptionThree());
			qt.setOptionFour(q.getOptionFour());
			qt.setRightAnswer(q.getRightAnswer());
			qt.setMarksScored(q.getMarksScored());
		}
		Questions q1=qrep.save(qt);
		return q1;
		
	}

	@Override
	public Questions assignTest(int qid, int tid) {
		// TODO Auto-generated method stub
		Questions q=qrep.getOne(qid);
		if(q!=null) {
			Test t=trep.getOne(tid);
			q.setTest(t);
		}
		Questions q1=qrep.save(q);
		return q1;
	}
	@Override

	public List<Questions> getUQuestions(int tid) {

		// TODO Auto-generated method stub

		Test t=trep.getOne(tid);

		List<Questions> uq=new ArrayList<>();

		if(t!=null) {

			uq=qrep.getUserQuestion(tid);

		}

		return uq;

	}
}