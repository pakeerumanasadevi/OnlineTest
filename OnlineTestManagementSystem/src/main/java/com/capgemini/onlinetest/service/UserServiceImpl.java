package com.capgemini.onlinetest.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetest.entity.Test;
import com.capgemini.onlinetest.entity.Userdata;
import com.capgemini.onlinetest.dao.TestRepository;
import com.capgemini.onlinetest.dao.UserDaoImpl;
import com.capgemini.onlinetest.dao.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
@Autowired
UserDaoImpl dao;
@Autowired
TestRepository trep;
@Autowired
UserRepository urep;

@Override
public Userdata addUser(Userdata u) {
return dao.addUser(u);
}

@Override
public List<Userdata> getAllUsers()
{
return dao.getAllUsers();
}


@Override
public Userdata deleteUser(int userId)
{
return dao.deleteUser(userId);
}

@Override
public Userdata updateUser(Userdata u) {
return dao.updateUser(u);
}
/*
@Override
public Boolean loginUser(Userdata u)
{
return dao.loginUser(u);
}
*/
@Override
public String loginUser(Userdata u)
{
return dao.loginUser(u);
}

@Override
public Userdata assignTest(int uid, int tid) {
	Userdata u=dao.getById(uid);
	if(u!=null) {
		Test t=trep.getOne(tid);
		u.setUsertest(t);
	}
	Userdata u1=urep.save(u);
	return u1;
}


@Override
public List<Userdata> getUsers() {
	// TODO Auto-generated method stub
	return urep.findAll();
}

@Override
public List<Userdata> getUserTest() {
	// TODO Auto-generated method stub
	return dao.getUserTest();
}


@Override

public Userdata getById(int uid) {

	// TODO Auto-generated method stub

	return dao.getById(uid);

}



@Override

public Userdata getByName(String name) {

	// TODO Auto-generated method stub

	return urep.getByName(name);

}

/////////////////////////////////////////////////

@Override

public Test get(String name) {

	// TODO Auto-generated method stub

	return urep.get(name);

}
}





