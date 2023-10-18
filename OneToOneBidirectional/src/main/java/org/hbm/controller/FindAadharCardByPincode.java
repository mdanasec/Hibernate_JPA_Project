package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hbm.dto.AadharCard;

public class FindAadharCardByPincode {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("eneter a person pincode to fetch a data : ");
		int pincode = s.nextInt();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

//		we can fetch a data in two ways 
//      1st way
		String qry = "SELECT a FROM AadharCard a WHERE a.pincode = :pincode";

		Query query = manager.createQuery(qry);
		query.setParameter("pincode", pincode);

		try {
			AadharCard card = (AadharCard) query.getSingleResult();
			System.out.println(" id : " + card.getId());
			System.out.println(" Aadhar Number : " + card.getNumber());
			System.out.println(" DOB : " + card.getDob());
			System.out.println(" pincode : " + card.getPincode());
		} catch (NoResultException e) {
			System.err.println("invalid person phone number !!");
		}

	}

}
