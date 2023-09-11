package com.steven.telleraccountopening.customer;

import java.util.List;
import java.util.Optional;

import org.hibernate.metamodel.mapping.EntityValuedModelPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.steven.telleraccountopening.TellerAccountOpeningApplication;
import com.steven.telleraccountopening.exception.UserNotFoundException;
import com.steven.telleraccountopening.jpa.CustomerRepository;


import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;

@RestController
public class CustomerResource {
	
	private CustomerRepository repository;

	public CustomerResource(CustomerRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping("/customers")
	public List<Customer> retrieveAllUsers(){
		TellerAccountOpeningApplication.LOGGER.info("Retrieved all Customers");
		return repository.findAll();
	}
	
	@GetMapping("/customers/{id}" )
	public EntityModel<Optional<Customer>> retrieveUser(@PathVariable Integer id){
		Optional<Customer> customer = repository.findById(id);
		
		TellerAccountOpeningApplication.LOGGER.info("Finding customer with this ID: " + id);
		
		if (customer.isEmpty()) {
			TellerAccountOpeningApplication.LOGGER.warn("No such customer exists with ID: : " + id);
			throw new UserNotFoundException("id:" + id);
		}
		
		EntityModel<Optional<Customer>> entityModel = EntityModel.of(customer);
		
		TellerAccountOpeningApplication.LOGGER.info("Found customer with this ID: " + id);
		
		return entityModel;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
		//Customer savedCustomer = repository.save(customer);		
		
		repository.save(customer);
		
		TellerAccountOpeningApplication.LOGGER.info("Customer has been created");
		
		return ResponseEntity.created(null).build();
	}
	
	
	@DeleteMapping("/customers/{id}")
	public void deleteByID(@PathVariable Integer id) {
		repository.deleteById(id);
		TellerAccountOpeningApplication.LOGGER.info("Customer has been deleted");
	}
}
