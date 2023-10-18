package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hbm.dto.Product;

public class FindDeptByLocation {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Eneter location to fetch record");
		String location = s.nextLine();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

		String qry = "select d from Department d where d.location=?1";
		Query query = manager.createQuery(qry);
		query.setParameter(1, location);

		Product dept = (Product) query.getSingleResult();

		if (dept != null) {
			System.out.println("department  :" + dept.getDeptName());
		}
		else
			System.err.println("you have entered invalid location !!");
	}

}
