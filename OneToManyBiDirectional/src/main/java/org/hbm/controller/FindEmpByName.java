package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hbm.dto.Employee;

public class FindEmpByName {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Eneter emp name to fetch record");
		String name = s.nextLine();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

		String qry = "select e from Employee e where e.name=?1";
		Query query = manager.createQuery(qry);
		query.setParameter(1, name);

		Employee emps = (Employee) query.getSingleResult();
		
		if (emps != null) {
			System.out.println("emp Id : " + emps.getId());
			System.out.println("name : " + emps.getName());
			System.out.println("desg : " + emps.getDesg());
			System.out.println("Emp Salary : " + emps.getSalary());
		} else
			System.err.println("you have entred invalid name !!");
	}
}
