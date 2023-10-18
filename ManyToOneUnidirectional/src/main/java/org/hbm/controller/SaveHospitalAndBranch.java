package org.hbm.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hbm.dto.Branch;
import org.hbm.dto.Hospital;

public class SaveHospitalAndBranch {

	public static void main(String[] args) {

		Hospital h = new Hospital();
		h.setFounder("Anas");
		h.setName("AIIMS Hospital");
		
		Branch b1 = new Branch();
		b1.setEmail("abc@gmail.com");
		b1.setName("Helth Care Delhi");
		b1.setPhone(75814);
		b1.setHospital(h);
		
		Branch b2 = new Branch();
		b2.setEmail("abcd@gmail.com");
		b2.setName("Helth Care Banglore");
		b2.setPhone(7581558);
		b2.setHospital(h);
		
		Branch b3 = new Branch();
		b3.setEmail("abuhse@gmail.com");
		b3.setName("Helth Care Mysore");
		b3.setPhone(75795161);
		b3.setHospital(h);
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		
		transaction.begin();
		transaction.commit();
	}
}



