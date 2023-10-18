package org.hbm.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hbm.dto.Student;

public class FindStudentByPhone {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Eneter student Name to fetch record");
		long phone = sc.nextLong();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry = "select s from Student s where s.phone=?1";
		Query query = manager.createQuery(qry);
		query.setParameter(1, phone);

		List<Student> st = (List<Student>) query.getResultList();
		
		if (st != null) {
			for (Student s : st) {
				System.out.println("name " + s.getName());
				System.out.println("phone " + s.getPhone());
				System.out.println("percentage " + s.getPers());
			}

		} else
			System.err.println("invalid id ");
	}
}
