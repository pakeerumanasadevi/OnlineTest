package com.capgemini.onlinetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetest.entity.Test;
import com.capgemini.onlinetest.entity.Userdata;
@Repository
public interface UserRepository extends JpaRepository<Userdata,Integer>{
	@Query("select u from Userdata u where u.username=:username")

	public Userdata getByName(@Param("username")String username);

	/*

	@Query("select u.userid,t.testId,t.testTitle,t.testTotalMarks from Userdata u INNER JOIN Test t on u.usertest=t.testId and u.username=:username")

	public Userdata get(@Param("username")String username);

	*/



	

	@Query("select t from Userdata u,Test t where u.usertest=t.testId and u.username=:username")

	public Test get(@Param("username")String username);

	

	
}
