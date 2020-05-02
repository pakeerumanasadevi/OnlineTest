package com.capgemini.onlinetest.service;

import java.util.List;

import com.capgemini.onlinetest.entity.Test;
import com.capgemini.onlinetest.entity.Userdata;

public interface UserService {

	Userdata addUser(Userdata u);


	List<Userdata> getAllUsers();

	Userdata deleteUser(int userId);

	Userdata updateUser(Userdata u);
	
    //Boolean loginUser(Userdata u);
	String loginUser(Userdata u);
	public Userdata assignTest(int uid,int tid);
	public List<Userdata> getUsers();
	public List<Userdata> getUserTest();
	public Userdata getById(int uid);



	//select u by name

	public Userdata getByName(String name);

	//////////////////////////////////////

	public Test get(String name);
}