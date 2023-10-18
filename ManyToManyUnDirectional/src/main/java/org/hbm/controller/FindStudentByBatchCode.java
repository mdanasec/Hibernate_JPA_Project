package org.hbm.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hbm.dto.Student;

public class FindStudentByBatchCode {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Eneter Batch Code to fetch record");
		String batchCode = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		 String qry = "select b.student from Batch b where b.batchCode=?1";
	     Query query = manager.createQuery(qry);
		 query.setParameter(1, batchCode);

		List<Student> st = query.getResultList();
		
		if (st.size()>0) {
			for (Student s : st) {
				System.out.println("name " + s.getName());
				System.out.println("phone " + s.getPhone());
				System.out.println("percentage " + s.getPers());
				System.out.println("------------------------");
			}

		} else
			System.err.println("invalid batch code  ");
	}
}
