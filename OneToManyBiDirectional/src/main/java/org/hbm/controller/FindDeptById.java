package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hbm.dto.Product;

public class FindDeptById {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Eneter dept id to fetch record");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

		Product d = manager.find(Product.class, id);

		if (d != null) {
			System.out.println("department  :" + d.getDeptName());
			System.out.println("desg :" + d.getLocation());

		} else
			System.out.println("you have entred invalid id");

	}
}
