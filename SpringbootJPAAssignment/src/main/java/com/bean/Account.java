package com.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
@Scope("prototype")
public class Account {
	
	@Id
	private int accNumber;
	private String name;
	private float amount;
	public Account(int accNumber, String name, float amount) {
		super();
		this.accNumber = accNumber;
		this.name = name;
		this.amount = amount;
	}
	
	public Account() {
		super();
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [accNumber=" + accNumber + ", name=" + name + ", amount=" + amount + "]";
	}
	
	
	

}
