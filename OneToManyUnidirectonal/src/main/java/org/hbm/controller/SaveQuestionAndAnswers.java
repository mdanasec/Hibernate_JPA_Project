package org.hbm.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hbm.dto.Answers;
import org.hbm.dto.Question;

public class SaveQuestionAndAnswers {

	public static void main(String[] args) {
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Question q = new Question();
		q.setQuestion("What is Hibernayte ? ");
		q.setQuestionBy("Avinash");
		
		Answers a1 = new Answers();
		a1.setAnswers(" Hibernate ia a open source ");
		a1.setAnswersBy("anas");
		
		Answers a2 = new Answers();
		a2.setAnswers(" Hibernate ia a non-invasive lightweight ORM tool ");
		a2.setAnswersBy("rathore");
		
		Answers a3 = new Answers();
		a3.setAnswers(" Hibernate ia a frame-work");
		a3.setAnswersBy("vignesh");
		
//		1st way
		List<Answers> answer = new ArrayList<Answers>();
		answer.add(a1);
		answer.add(a2);
		answer.add(a3);
		q.setAnswers(answer);
//		2nd way
//		q.setAnswers(new ArrayList<Answers>(Arrays.asList(a1,a2,a3)));
		
		manager.persist(q);
		transaction.begin();
		transaction.commit();
		

	}

}
