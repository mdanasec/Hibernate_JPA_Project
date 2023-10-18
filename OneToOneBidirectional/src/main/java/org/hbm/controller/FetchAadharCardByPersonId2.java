package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hbm.dto.AadharCard;

public class FetchAadharCardByPersonId2 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("eneter a person id to fetch a data : ");
		int pid = s.nextInt();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
//		we can fetch a data in two ways 
//      1st way
		String qry ="select a from AadharCard a where a.person.id=?1"; 
//		2nd way
		String qry2 = "select p.card from Person p where p.id=?1";
		Query a = manager.createQuery(qry2);
		a.setParameter(1, pid);
		
		try {
			AadharCard card =(AadharCard)a.getSingleResult();
			System.out.println("id : "+ card.getId());
			System.out.println("Aadhar Number : " + card.getNumber());
			System.out.println(" DOB : "+ card.getDob());
			System.out.println("pincode : " + card.getPincode());
		}
		catch(NoResultException e) {
			System.err.println("invalid person id !!");
		}
		

	}

}
