package org.hbm.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hbm.dto.Batch;
import org.hbm.dto.Student;

public class SaveBatchAndStudent {

	public static void main(String[] args) {

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Batch b1 = new Batch();
		b1.setSubject("Hibernayte");
		b1.setTrainer("Satish");
		b1.setBatchCode("JBT-JFRRT-M3");

		Batch b2 = new Batch();
		b2.setSubject("React js");
		b2.setTrainer("prjwal");
		b2.setBatchCode("JBT-JFRCT-A2");

		Batch b3 = new Batch();
		b3.setSubject("J2EE");
		b3.setTrainer("GuruRaj");
		b3.setBatchCode("JBT-JFRTV-M2");

		Student s1 = new Student();
		s1.setName("Md anas");
		s1.setPers(88);
		s1.setPhone(758176202);

		Student s2 = new Student();
		s2.setName("Md anas");
		s2.setPers(84);
		s2.setPhone(75202);

		Student s3 = new Student();
		s3.setName("Md anas");
		s3.setPers(82);
		s3.setPhone(7581202);

		b1.setStudent(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));
		b1.setStudent(new ArrayList<Student>(Arrays.asList(s1, s3)));
		b1.setStudent(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));

		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		transaction.begin();
		transaction.commit();
	}
}
