package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hbm.dto.AadharCard;

public class FindPersonByAadharNumber {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("enter person Aadhar number : ");
		long number = s.nextLong();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

		String qry = "SELECT a FROM AadharCard a WHERE a.number = :aadharNumber";
		Query query = manager.createQuery(qry);
		query.setParameter("aadharNumber", number);

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
