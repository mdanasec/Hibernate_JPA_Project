package org.hbm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id ;
	private String name;
	@Column(nullable = false , unique = true)
	private long phone;
	private double pers;
	
//	Getters and Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public double getPers() {
		return pers;
	}
	public void setPers(double pers) {
		this.pers = pers;
	}
	
	
	
	

}
