package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hbm.dto.Product;

public class FindDeptByName {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Eneter employee name  to fetch record");
		String name = s.nextLine();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		String qry = "SELECT e.dept FROM Employee e WHERE e.name = ?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		
	     // Retrieve the department
        Product dept = (Product) q.getSingleResult();

        // Print department details if found
        if (dept != null) {
            System.out.println("Department ID: " + dept.getId());
            System.out.println("Department Name: " + dept.getDeptName());
            System.out.println("Department Location: " + dept.getLocation());
        } else {
            System.out.println("you have wr");
        }

		
	}
}
