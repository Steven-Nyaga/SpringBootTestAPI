package com.steven.telleraccountopening.customer;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {
	
	protected Customer() {
		
	}
	
	@Id
	private Integer idNumber;
	
	@Size(min=2, message="Customer Name should have more than one character")
	private String customerName;
	
	@Past(message="Birth date should be in the past")
	private LocalDate dateOfBirth;
	
	@Size(min=2, message="Customer Name should have more than one character")
	private String nextOfKinName;
	
	@Size(min=2, message="Ocupation should have more than one character")
	private String occupation;
	
	public Customer(Integer idNumber, String customerName, LocalDate dateOfBirth, String nextOfKinName,
			String occupation) {
		super();
		this.idNumber = idNumber;
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.nextOfKinName = nextOfKinName;
		this.occupation = occupation;
	}

	public Integer getIdNumber() {
		return idNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getNextOfKinName() {
		return nextOfKinName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setIdNumber(Integer idNumber) {
		this.idNumber = idNumber;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setNextOfKinName(String nextOfKinName) {
		this.nextOfKinName = nextOfKinName;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Override
	public String toString() {
		return "Customer [idNumber=" + idNumber + ", customerName=" + customerName + ", dateOfBirth=" + dateOfBirth
				+ ", nextOfKinName=" + nextOfKinName + ", occupation=" + occupation + "]";
	}
	

}
