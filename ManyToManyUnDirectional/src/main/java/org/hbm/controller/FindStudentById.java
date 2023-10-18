package org.hbm.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hbm.dto.Student;

public class FindStudentById {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter  student id ");
		int id = sc.nextInt();
		
		EntityManager manager= Persistence.createEntityManagerFactory("dev").createEntityManager();
		Student s = manager.find(Student.class, id);
		
		if(s!=null) {
			System.out.println("name "+ s.getName());
			System.out.println("phone " +s.getPhone());
			System.out.println("percentage " +s.getPers());
			
		}
		else 
			System.err.println("invalid id ");
		
		
	}
}
