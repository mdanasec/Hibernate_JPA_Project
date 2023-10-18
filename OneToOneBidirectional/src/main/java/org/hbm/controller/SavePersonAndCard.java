package org.hbm.controller;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hbm.dto.AadharCard;
import org.hbm.dto.Person;

public class SavePersonAndCard {

	public static void main(String[] args) {

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Scanner s = new Scanner(System.in);
		Person p = new Person();
		

		System.out.println("Enter your name ");
		String name = s.nextLine();

		System.out.println("Enter Your Phone Number ");
		long phone = s.nextLong();
		s.nextLine(); // Consume the newline character

		p.setName(name);
		p.setPhone(phone);

		AadharCard card = new AadharCard();
		System.out.println("Enter Your Aadhar Number");
		long number = s.nextLong();
		s.nextLine();

		System.out.println("Enter date of birth (yyyy-MM-dd):");
		LocalDate dob = LocalDate.parse(s.nextLine());

		System.out.println("Enetr your Pincode");
		int pincode = s.nextInt();

		card.setNumber(number);
		card.setDob(dob);
		card.setPincode(pincode);

		p.setCard(card); // Assigning AadharCard for Person
		card.setPerson(p); // Assigning Person for AadharCard



		transaction.begin(); // Begin the transaction before persisting
		manager.persist(p);
		transaction.commit();
		manager.close(); // Close the EntityManager to release resources

	}

}
