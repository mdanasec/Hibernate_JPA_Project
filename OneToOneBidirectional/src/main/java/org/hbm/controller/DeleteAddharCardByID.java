package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hbm.dto.Person;

public class DeleteAddharCardByID {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("enter id to delete a record");
		int id = s.nextInt();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p = manager.find(Person.class, id);
		
		if(p!=null) {
			manager.remove(p);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
		}
		else
			System.err.println("you have entred wrong id");

	}

}
