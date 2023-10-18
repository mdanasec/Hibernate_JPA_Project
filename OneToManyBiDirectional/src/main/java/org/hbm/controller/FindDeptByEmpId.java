package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hbm.dto.Product;
import org.hbm.dto.Employee;

public class FindDeptByEmpId {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Eneter emp id to fetch record");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		String qry = "select e.dept from Employee e where e.id=?1";
		Query query= manager.createQuery(qry);
		query.setParameter(1, id);
		
		Product dept = (Product) query.getSingleResult();
		if(dept!=null) {
			
			System.out.println("blong to : " + dept.getDeptName() + " department ");
		}
		else 
			System.err.println("invalid dept name !!");
	}
}
