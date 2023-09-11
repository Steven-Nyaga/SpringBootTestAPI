package com.steven.telleraccountopening.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.steven.telleraccountopening.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}
