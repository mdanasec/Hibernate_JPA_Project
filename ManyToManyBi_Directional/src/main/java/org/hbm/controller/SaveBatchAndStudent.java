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
		b1.setBatchCode("UBY");

		Batch b2 = new Batch();
		b2.setSubject("React js");
		b2.setTrainer("prjwal");
		b2.setBatchCode("DTC");

		Batch b3 = new Batch();
		b3.setSubject("J2EE");
		b3.setTrainer("GuruRaj");
		b3.setBatchCode("BTM");

		Student s1 = new Student();
		s1.setSname("Md anas");
		s1.setPerc(88);
		s1.setPhone(758176202);

		Student s2 = new Student();
		s2.setSname("Rathore");
		s2.setPerc(84);
		s2.setPhone(75202);

		Student s3 = new Student();
		s3.setSname("Avinash");
		s3.setPerc(82);
		s3.setPhone(7581202);

		s1.setBatches(new ArrayList<Batch>(Arrays.asList(b1, b2, b3)));
		s2.setBatches(new ArrayList<Batch>(Arrays.asList(b1, b3)));
		s3.setBatches(new ArrayList<Batch>(Arrays.asList(b1, b2, b3)));

		b1.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));
		b2.setStudents(new ArrayList<Student>(Arrays.asList(s1, s3)));
		b3.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));

		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);

		manager.persist(s1);
		manager.persist(s2);
		manager.persist(s3);

		transaction.begin();
		transaction.commit();

	}

}
