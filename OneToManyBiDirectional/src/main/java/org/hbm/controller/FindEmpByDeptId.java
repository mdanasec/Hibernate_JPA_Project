package org.hbm.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hbm.dto.Product;
import org.hbm.dto.Employee;

public class FindEmpByDeptId {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Eneter Dept Id to fetch record");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		String qry = "SELECT  d.emps from Department d WHERE d.id=?1";
		Query query = manager.createQuery(qry);
		query.setParameter(1, id);
		
		List<Employee> emps = query.getResultList();

		if (emps.size() > 0) {
			for (Employee e : emps) {
				
				System.out.println("name : " + e.getName());
				System.out.println("desg : " + e.getDesg());
				System.out.println("Emp Salary : " + e.getSalary());
				System.out.println("_____________________________");
			}
		} else
			System.err.println("invalid department id !!");
	}
}
