package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hbm.dto.AadharCard;
import org.hbm.dto.Person;

public class FetchAadharCardByPersonId {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a Person Id : ");
		int pid = s.nextInt();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p = manager.find(Person.class, pid); 
		
		if(p!=null) {
			AadharCard card = p.getCard();
			if(card!=null) {
				System.out.println("id : "+ card.getId());
				System.out.println("Aadhar Number : " + card.getNumber());
				System.out.println(" DOB : "+ card.getDob());
				System.out.println("pincode : " + card.getPincode());
			}
			
		}
		else
			System.err.println("you have entered invalid id !!");
		
		
		
	}
}




















