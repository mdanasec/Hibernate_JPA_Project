package org.hbm.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String answers;
	private String answersBy;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	public String getAnswersBy() {
		return answersBy;
	}
	public void setAnswersBy(String answersBy) {
		this.answersBy = answersBy;
	}
	
	
}
