package com.design.interestcalc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.design.interestcalc.models.Customer;
import com.design.interestcalc.repository.CustomerRepository;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	public CustomerRepository customerRepository;
	
	@PostMapping("/login") 
	public  Customer customerLogin(@RequestBody Customer customer) { 
		return customerRepository.findByAccNoAndPassword(customer.getAccNo(),customer.getPassword());
		
	}
	@PostMapping("/viewDetails")
	public Customer viewCustomerDetails(@RequestBody Customer customer) {
		return customer;
	}
	

}
