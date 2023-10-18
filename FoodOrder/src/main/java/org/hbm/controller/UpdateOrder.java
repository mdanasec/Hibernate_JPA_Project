package org.hbm.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hbm.dto.FoodOrder;

public class UpdateOrder {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		FoodOrder order = manager.find(FoodOrder.class, 1);
		
		order.setFoodItem("Leg Biryani");
		order.setCost(250.00);
		manager.persist(order);
		transaction.begin();
		transaction.commit();

	}

}
