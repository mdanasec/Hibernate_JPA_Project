package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hbm.dto.Product;
import org.hbm.dto.Employee;

public class FindDeptByEmpDesg {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Eneter emp Desgination to fetch record");
		String desg = s.nextLine();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

		String qry = "select e.dept from Employee e where e.desg=?1";
		Query query = manager.createQuery(qry);
		query.setParameter(1, desg);

		Product dept = (Product) query.getSingleResult();

		if (dept != null) {
			System.out.println("Department By desg is  : " + dept.getDeptName());
			System.out.println("Department Location: " + dept.getLocation());
			System.out.println("Employee ID: " + dept.getId());
		} else {
			System.err.println("you have entred invalid desgnation");
		}

	}
}
