package com.capgemini.onlinetest.controller;

import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.Optional;

import com.capgemini.onlinetest.exceptions.IdNotFoundException;
import com.capgemini.onlinetest.exceptions.UserNotFoundException;
import com.capgemini.onlinetest.service.QuestionsService;
import com.capgemini.onlinetest.service.TestService;
import com.capgemini.onlinetest.service.UserService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinetest.entity.Questions;
import com.capgemini.onlinetest.entity.Test;
import com.capgemini.onlinetest.entity.Userdata;

@RestController
@RequestMapping("/admin")
//@CrossOrigin("http://localhost:4200")
public class AdminController {
	@Autowired
	UserService serviceobj;
	@Autowired
	QuestionsService ser;
	@Autowired
	TestService tser;

	// Add user
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody Userdata u) {
		Userdata e = serviceobj.addUser(u);
		if (e == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("User created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	@PostMapping("/addUserttttt")
	public Userdata addU(@RequestBody Userdata t) {
		return serviceobj.addUser(t);
	}

	
	// Get all users
	@GetMapping("/GetAllUsers")
	public ResponseEntity<List<Userdata>> getAllUsers() {
		List<Userdata> userlist = serviceobj.getAllUsers();
		return new ResponseEntity<List<Userdata>>(userlist, new HttpHeaders(), HttpStatus.OK);
	}
	/*
	 * its is other way for getall users
	// Get all users
		@GetMapping("/GetUsers")
		public ResponseEntity<List<Userdata>> getUsers() {
			List<Userdata> userlist = serviceobj.getUsers();
			return new ResponseEntity<List<Userdata>>(userlist, new HttpHeaders(), HttpStatus.OK);
		}
		*/
	
	//Update User
	@PutMapping("/UpdateUser")
	public ResponseEntity<String> updateUser(@RequestBody Userdata u) {
		Userdata e = serviceobj.updateUser(u);
		if (e == null) {
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("User updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	// Delete User
	@DeleteMapping("/DeleteUser/{userId}")
	private ResponseEntity<String> deleteUser(@PathVariable("userId") int userId) {
		Userdata e = serviceobj.deleteUser(userId);
		System.out.println("controller delete");
		if (e == null) {
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("User deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	
	//To validate Login 
	@PutMapping("/Loginuser")
	public String loginUser(@RequestBody Userdata u)
	{
		 String flag = null;
		 String type=serviceobj.loginUser(u);
		 return type;
	}
	
	//add questions
	@PostMapping("/question")
	public Questions addQ(@RequestBody Questions q) {
		return ser.save(q);
	}
	
	//get all questions
	@GetMapping("/getq")
	public List<Questions> findQ(){
		return ser.getAll();
	}
	
	/*
	//update question
	@PutMapping("/uptquestions/{qid}")
	public ResponseEntity<Questions> updateQ(@PathVariable(value="qid")int qid,@RequestBody Questions q){
		Questions q1=ser.findOne(qid);
		if(q1==null) {
			return ResponseEntity.notFound().build();
		}
		q1.setQtitle(q.getQtitle());
		q1.setOpt1(q.getOpt1());
		q1.setOpt2(q.getOpt2());
		q1.setQans(q.getQans());
		
		Questions q2=ser.save(q1);
		return ResponseEntity.ok().body(q2);
	}
	*/
	
	//update question
	@PutMapping("/uptques")
	public ResponseEntity<Questions> updateQu(@RequestBody Questions q){
		Questions q1=ser.updateQuestion(q);
		return ResponseEntity.ok().body(q1);
	}
	
	//delete question
	@DeleteMapping("/delq/{qid}")
	public ResponseEntity<Questions> deleteQ(@PathVariable(value="qid")int qid)
	{
		Questions q=ser.findOne(qid);
		if(q==null) {
			return ResponseEntity.notFound().build();
		}
		ser.deleteQ(q);
		return ResponseEntity.ok().build();
	}
	
	//add test
	@PostMapping("/test")
	public Test addT(@RequestBody Test t) {
		return tser.save(t);
	}
	
	//get all test
	@GetMapping("/gett")
	public List<Test> findT() {
		return tser.getAll();
	}
	
	//update test
	/*@PutMapping("/upttest/{testid}")
	public ResponseEntity<Test> updateT(@PathVariable(value="testid")int testid,@RequestBody Test t){
		Test t1=tser.findOne(testid);
		if(t1==null) {
			return ResponseEntity.notFound().build();
		}
		t1.setTestTitle(t.getTestTitle());
		t1.setTestMarksScored(t.getTestMarksScored());
		t1.setTestTotalMarks(t.getTestTotalMarks());
		t1.setTestDate(t.getTestDate());
		Test t2=tser.save(t1);
		return ResponseEntity.ok().body(t2);
	}*/
	
	//update test
	@PutMapping("/upttest")
	public ResponseEntity<Test> updateT(@RequestBody Test t){
		Test t1=tser.updateTest(t);
		return ResponseEntity.ok().body(t1);
	}
	
	//delete test
     @DeleteMapping("/delt/{testid}")
	public ResponseEntity<Test> deleteT(@PathVariable(value="testid")int testid)

	{
		Test t=tser.findOne(testid); 
		if(t==null) {
			return ResponseEntity.notFound().build();
		}
		tser.deleteT(t);
		return ResponseEntity.ok().build();
		
	}
     
     /*@DeleteMapping("/delt/{testid}/{questionid}")
		public ResponseEntity<String> deleteT(@PathVariable(value="testid")int testid,@PathVariable(value="questionid")int questionid) {
			Test t = tser.deleteT(testid,questionid);
			if (t == null) {
				throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<>("User deleted successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
     */  
	//delete question
		/*@DeleteMapping("/delt/{tid}/{qid}")
		public ResponseEntity<Test> deleteT(@PathVariable(value="tid")int tid)
		{
			Test t=tser.findOne(tid);
			if(t==null) {
				return ResponseEntity.notFound().build();
			}
			tser.deleteT(t);
			return ResponseEntity.ok().build();
		}*/
	//add test to question to test
	@PutMapping("/test/{testId}/{questionId}")
	public Questions assignQuestion(@PathVariable(value="testId")int testId,
			@PathVariable(value="questionId")int questionId){
		
		return ser.assignTest(questionId, testId);
	}
	
	//assign test to user
	@PutMapping("/user/{userid}/{testId}")
	public Userdata assignTest(@PathVariable(value="userid")int userid,
			@PathVariable(value="testId")int testId) {
		return serviceobj.assignTest(userid,testId);
	}
	/*
	//assign get all user tests
	@GetMapping("/user/test/question")
	public List<Userdata> getUsersTest(){
		return serviceobj.getUserTest();
	}
	*/
	
	//Assigning a questions to test(didn't complete)
	 @PutMapping("/{testId}/{questionId}")
	public ResponseEntity<Test> addqttrial(@PathVariable(value="testId")int testId,@PathVariable(value="questionId")int questionId)
	{
		Test t1=tser.findOne(testId);
		if(t1==null) {
			return ResponseEntity.notFound().build();
		}
		Questions q1=ser.findOne(questionId);
		Set<Questions> l=new TreeSet<>();
		l.add(q1);
		t1.setTestQuestions(l);
		Test t2=tser.save(t1);
		return ResponseEntity.ok().body(t2);
		/*
		Questions q=qrep.getOne(qid);
		Test t=trep.getOne(testid);
		//Test t = null;
		List<Questions> l = null;
		l.add(q);
		t.setTquestions(l);
		trep.save(t);*/
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFound(UserNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}

