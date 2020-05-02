package com.capgemini.onlinetest.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="test")
public class Test {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int testId;
	@Column(length=50)
	private String testTitle;
	@OneToMany(mappedBy="test")
	private Set<Questions> testQuestions;
	private int testTotalMarks;
	private int testMarksScored;
	@Column(name="testDate",nullable=false)
	private LocalDate testDate;

	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	
	public Set<Questions> getTestQuestions() {
		return testQuestions;
	}
	public void setTestQuestions(Set<Questions> testQuestions) {
		this.testQuestions = testQuestions;
	}
	public int getTestTotalMarks() {
		return testTotalMarks;
	}
	public void setTestTotalMarks(int testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}
	public int getTestMarksScored() {
		return testMarksScored;
	}
	public void setTestMarksScored(int testMarksScored) {
		this.testMarksScored = testMarksScored;
	}
	public LocalDate getTestDate() {
		return testDate;
	}
	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}	

	
}


























/*


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="Test_otm")
public class Test {
	
	@Id
//	@GeneratedValue
	@Column(name="t_id")
	private int testId;
	private String testTitle;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToMany(targetEntity=Questions.class,cascade=CascadeType.ALL)
	@JoinColumn(name="testId",referencedColumnName="t_id")
	private List<Questions> testQuestions;
	private int testTotalMarks;
	private int testMarksScored;
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public List<Questions> getTestQuestions() {
		return testQuestions;
	}
	public void setTestQuestions(List<Questions> testQuestions) {
		this.testQuestions = testQuestions;
	}
	public int getTestTotalMarks() {
		return testTotalMarks;
	}
	public void setTestTotalMarks(int testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}
	public int getTestMarksScored() {
		return testMarksScored;
	}
	public void setTestMarksScored(int testMarksScored) {
		this.testMarksScored = testMarksScored;
	}
}
*/
