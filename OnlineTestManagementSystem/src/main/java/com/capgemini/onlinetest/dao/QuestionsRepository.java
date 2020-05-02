package com.capgemini.onlinetest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetest.entity.Questions;


@Repository
public interface QuestionsRepository extends JpaRepository<Questions,Integer>{

	/*
	@Modifying	
	@Query("UPDATE q FROM Questions_otm q WHERE q.qid=?")
	public Questions UpdateQuestion(int qid);
	*/
	@Query("select q from Test t,Questions q where q.test=t.testId and t.testId=:testId")

	public List<Questions> getUserQuestion(@Param("testId")int testId);
}
