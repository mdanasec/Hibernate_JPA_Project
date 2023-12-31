package org.hbm.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id ;
	private String question ;
	private String questionBy;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Answers>answers;
	
	
	
	public List<Answers> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionBy() {
		return questionBy;
	}
	public void setQuestionBy(String questionBy) {
		this.questionBy = questionBy;
	}
	
	
}
