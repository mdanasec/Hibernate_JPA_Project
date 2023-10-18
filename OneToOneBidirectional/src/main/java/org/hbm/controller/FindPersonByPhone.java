package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hbm.dto.AadharCard;

public class FindPersonByPhone {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("enter person phone number : ");
		long phone = s.nextLong();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		String qry = "select p.card from Person p where p.phone=?1";
		Query query = manager.createQuery(qry);
		query.setParameter(1, phone);
		
		AadharCard card = (AadharCard) query.getSingleResult();
		
		if(card!=null) {
			System.out.println(" id : " + card.getId());
			System.out.println(" Aadhar Number : " + card.getNumber());
			System.out.println(" DOB : " + card.getDob());
			System.out.println(" pincode : " + card.getPincode());
		}
		 else
				System.err.println("invalid person phone number !!");	
	}
}
