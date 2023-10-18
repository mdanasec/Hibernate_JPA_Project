package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hbm.dto.Employee;

public class FindEmpById {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Eneter emp Desgination to fetch record");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

		Employee e = (Employee) manager.find(Employee.class, id);

		if (e != null) {
			System.out.println("name : " + e.getName());
			System.out.println("desg : " + e.getDesg());
			System.out.println("Emp Salary : " + e.getSalary());
		} else
			System.err.println("invalid id !!");

	}

}
