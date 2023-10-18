package org.hbm.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hbm.dto.Product;
import org.hbm.dto.Employee;



public class SaveDeptAndEmp {

		public static void main(String[] args) {
			
			Product d = new Product();
			d.setLocation("Bhopal");
			d.setDeptName("Testing");
			
			Employee e = new Employee();
			e.setName("Siddique");
			e.setDesg("Bhopal");
			e.setSalary(1500.00);
			e.setDept(d);
			
			Employee e2 = new Employee();
			e2.setName("Shad");
			e2.setDesg("Bhopal");
			e2.setSalary(15000.00);
			e2.setDept(d);
			
			d.setEmps(new ArrayList<Employee>(Arrays.asList(e,e2)));
			EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
			EntityTransaction t = m.getTransaction();
			m.persist(d);
			t.begin();
			t.commit();
		}
}
