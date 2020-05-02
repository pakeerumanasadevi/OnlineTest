package com.capgemini.onlinetest.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="questions")
public class Questions {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int questionId;
	@Column(length=100)
	private String questionTitle;
	@Column(length=30)
	private String optionOne;
	@Column(length=30)
	private String optionTwo;
	@Column(length=30)
	private String optionThree;
	@Column(length=30)
	private String optionFour;
	@Column(length=30)
	private int rightAnswer;
	@ManyToOne
	@JoinColumn(name="testId")
	private Test test;
	@Column(length=30)
	private int questionMarks;
	@Column(length=30)
	private int choosenAnswer;
	@Column(length=30)
	private int marksScored;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getOptionOne() {
		return optionOne;
	}
	public void setOptionOne(String optionOne) {
		this.optionOne = optionOne;
	}
	public String getOptionTwo() {
		return optionTwo;
	}
	public void setOptionTwo(String optionTwo) {
		this.optionTwo = optionTwo;
	}
	public String getOptionThree() {
		return optionThree;
	}
	public void setOptionThree(String optionThree) {
		this.optionThree = optionThree;
	}
	public String getOptionFour() {
		return optionFour;
	}
	public void setOptionFour(String optionFour) {
		this.optionFour = optionFour;
	}
	public int getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(int rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	@JsonIgnore
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public int getQuestionMarks() {
		return questionMarks;
	}
	public void setQuestionMarks(int questionMarks) {
		this.questionMarks = questionMarks;
	}
	public int getChoosenAnswer() {
		return choosenAnswer;
	}
	public void setChoosenAnswer(int choosenAnswer) {
		this.choosenAnswer = choosenAnswer;
	}
	public int getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(int marksScored) {
		this.marksScored = marksScored;
	}

	
}


































/*
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Questions_otm")
public class Questions {
	@Id
	@Column(name="qid")
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tesId")
    private int questionId;
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private int questionAnswer;
	private int questionMarks;
	private int choosenAnswer;
	private int marksScored;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public int getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public int getQuestionMarks() {
		return questionMarks;
	}
	public void setQuestionMarks(int questionMarks) {
		this.questionMarks = questionMarks;
	}
	public int getChoosenAnswer() {
		return choosenAnswer;
	}
	public void setChoosenAnswer(int choosenAnswer) {
		this.choosenAnswer = choosenAnswer;
	}
	public int getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(int marksScored) {
		this.marksScored = marksScored;
	}
	
}

/*
@Entity
@Table(name="QuestionsO")
public class Questions {

	@Id
	private int qid;
	private String qtitle;
	@JsonProperty("qo")
	private HashMap<Integer,String> qoptions;
	private int qans;
	private long qmarks;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQtitle() {
		return qtitle;
	}
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}
	public HashMap<Integer, String> getQoptions() {
		return qoptions;
	}
	public void setQoptions(HashMap<Integer, String> qoptions) {
		this.qoptions = qoptions;
	}
	public int getQans() {
		return qans;
	}
	public void setQans(int qans) {
		this.qans = qans;
	}
	public long getQmarks() {
		return qmarks;
	}
	public void setQmarks(long qmarks) {
		this.qmarks = qmarks;
	}
}
*/