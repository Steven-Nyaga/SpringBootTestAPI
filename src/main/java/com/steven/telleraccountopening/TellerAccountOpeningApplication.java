package com.steven.telleraccountopening;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.steven.telleraccountopening.customer.CustomerResource;

@SpringBootApplication
public class TellerAccountOpeningApplication {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(TellerAccountOpeningApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TellerAccountOpeningApplication.class, args);
	}

}
