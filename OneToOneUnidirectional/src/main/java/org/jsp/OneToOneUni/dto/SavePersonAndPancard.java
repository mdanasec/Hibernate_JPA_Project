package org.jsp.OneToOneUni.dto;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePersonAndPancard {

	public static void main(String[] args) {
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Scanner scanner = new Scanner(System.in);

		Person p = new Person();
		System.out.println("Enter name:");
		String name = scanner.nextLine();

		System.out.println("Enter phone number:");
		long phone = scanner.nextLong();
		scanner.nextLine(); // Consume the newline character
		
		 // Transient state
		p.setName(name);
		p.setPhone(phone);

		PanCard card = new PanCard();
		System.out.println("Enter PAN card number:");
		String panNumber = scanner.nextLine();

		System.out.println("Enter a pincode:");
		int pincode = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		System.out.println("Enter date of birth (yyyy-MM-dd):");
		LocalDate dob = LocalDate.parse(scanner.nextLine());



		 // Transient state
		card.setNumber(panNumber);
		card.setPincode(pincode);
		card.setDob(dob);

		p.setCard(card);

		transaction.begin();
		manager.persist(p);
		transaction.commit();
		System.out.println("record is saved Sucessfully");
	

		// Close the scanner when done
		manager.close();
		
	}

}
