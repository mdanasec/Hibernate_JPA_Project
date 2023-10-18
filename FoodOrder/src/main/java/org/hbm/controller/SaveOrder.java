package org.hbm.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hbm.dto.FoodOrder;

public class SaveOrder {

	public static void main(String[] args) {
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
//		FoodOrder oredr = manager.find(FoodOrder.class, 2);
		FoodOrder order = new FoodOrder();
		order.setFoodItem("Biryani");
		order.setCost(145.02);
		manager.persist(order);
		transaction.begin();
		transaction.commit();
	}
}
