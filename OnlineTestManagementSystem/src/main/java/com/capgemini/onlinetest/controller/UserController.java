package com.capgemini.onlinetest.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.onlinetest.entity.Questions;
import com.capgemini.onlinetest.entity.Test;
import com.capgemini.onlinetest.entity.Userdata;
import com.capgemini.onlinetest.service.QuestionsService;
import com.capgemini.onlinetest.service.TestService;
import com.capgemini.onlinetest.service.UserService;

@RestController
@RequestMapping("/user")
//@CrossOrigin("http://localhost:4200")
public class UserController {
	@Autowired
	QuestionsService ser;
	@Autowired
	TestService tser;
	@Autowired
	UserService user;


	//this is not used

	//get all test

	@GetMapping("/gett")

	public List<Test> findT() {

		return tser.getAll();

	}

	

	//this is not used

	//get user details by userid

	@GetMapping("/userid/{userid}")

	public Userdata getUsers(@PathVariable(value="userid")int userid)

	{

		return user.getById(userid);

	}

	

	//get test details of user

	@GetMapping("/username/{username}")

	public Test getUserByName(@PathVariable(value="username") String username)

	{

		return user.get(username);

	}

	

	//get user questions

	@GetMapping("/userQuestions/{testId}")

	public List<Questions> getUserQuestions(@PathVariable(value="testId") int testId)

	{

		return ser.getUQuestions(testId);

	}
}