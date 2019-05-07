package com.design.interestcalc.controller;

import java.util.ArrayList;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.design.interestcalc.models.Customer;
import com.design.interestcalc.models.Employee;
import com.design.interestcalc.models.Interest;
import com.design.interestcalc.repository.CustomerRepository;
import com.design.interestcalc.repository.EmployeeRepository;
import com.design.interestcalc.repository.InterestRepository;

@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = "http://localhost:4200")
public class BankController {
	
	@Autowired
	public CustomerRepository customerRepository;
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	@Autowired
	public InterestRepository interestRepository;
	
	Customer cust;
	
//	The basics PostMapping -> RequestBody
//	GetMapping -> RequestParam
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		cust = customerRepository.save(customer);
		return cust;
	}
	public Interest addInterest(@RequestBody Double intRate) {
		Interest intrst = new Interest(cust.getAccNo(),0.0,intRate,0.0,0.0,new Date());
		return interestRepository.save(intrst);
	}

	@GetMapping("/test1")
	public String test1() {
		return "Hello";
	}
	
	@PostMapping("/login_emp") 
	public  boolean employeeLogin(@RequestBody Employee employee) { 
		return employeeRepository.findByEmpIdAndPassword(employee.getEmpId(), employee.getPassword())!=null;
		
	}
	
	@PostMapping("/new_accnt")
	public boolean addNew(@RequestBody Interest intr) {
		if (interestRepository.findByAccNo(intr.getAccNo()) != null ) {
			return false;
		}
		if (customerRepository.findByAccNo(intr.getAccNo()) == null ) {
			return false;
		}
		interestRepository.calculateFixedDailyInterest();
		interestRepository.calculateDailyInterest();
		intr.setCumulativeInt(0.0);
		intr.setDailyInt(0.0);
		intr.setLastUpdated(new Date());
		return interestRepository.save(intr) != null;
	}
	
//	@PostMapping("/withdraw")
//	public int withdraw(@RequestBody Interest intr, Double amt, Date date) {
//		return interestRepository.subBalance(intr.getAccNo(), amt, date);
//	}
	
	@RequestMapping(path = "withdraw/{accNo}/{amt}/{date}", method = RequestMethod.GET)
	public boolean withdraw(@PathVariable Long accNo, @PathVariable Double amt, @PathVariable("date") @DateTimeFormat(pattern = "ddMMyyyy") Date date) {
		return interestRepository.subBalance(accNo, amt, date) != 0;
	}
	
	@RequestMapping(path = "deposit/{accNo}/{amt}/{date}", method = RequestMethod.GET)
	public boolean deposit(@PathVariable Long accNo, @PathVariable Double amt, @PathVariable("date") @DateTimeFormat(pattern = "ddMMyyyy") Date date) {
		return interestRepository.addBalance(accNo, amt, date) != 0;
	}
	
	@PostMapping("/signup_cust") 
	public  boolean customerSingup(@RequestBody Customer customer) { 
		return customerRepository.save(customer) != null;
		
	}
	@PostMapping("/signup_emp") 
	public  boolean employeeSingup(@RequestBody Employee employee) { 
		return employeeRepository.save(employee)!=null;
		
	}
	
	@PostMapping("/login_cust") 
	public  boolean customerLogin(@RequestBody Customer customer) { 
		return customerRepository.findByAccNoAndPassword(customer.getAccNo(), customer.getPassword())!=null;
		
	}
	
	
	
	@PostMapping("/viewCustomerDetails")
	public Customer getCustomerDetails(@RequestBody Long accNo) {
		return customerRepository.findByAccNo(accNo);
	}
	@GetMapping("/viewAll")
	public ArrayList<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	@GetMapping("/viewAllAccnts")
	public ArrayList<Interest> getAllAccnts(){
		return interestRepository.findAll();
	}
	
	@PostMapping("/viewAccountDetails")
	public Interest getAccountDetails(@RequestBody Long accNo) {
		return interestRepository.findByAccNo(accNo);
	}
	
	@PostMapping("/viewEmployeeDetails")
	public Employee getEmployeeDetails(@RequestBody Long empId) {
		return employeeRepository.findByEmpId(empId);
	}
	
	@DeleteMapping("/deleteCustomer/{accNo}")
	public void deleteCustomer(@PathVariable Long accNo) {
		customerRepository.deleteByAccNo(accNo);		
	}
	
	@DeleteMapping("/deleteAccount/{accNo}")
	public void deleteAccount(@PathVariable Long accNo) {
		interestRepository.deleteByAccNo(accNo);		
	}
	
//	@PostMapping("/depositAmount")
//	public Interest depositAmount(@RequestBody Customer cus, @RequestBody Long amt) {
//		interestRepository.addBalance(cus.getAccNo(),amt);
//		return interestRepository.findByAccNo(cus.getAccNo());
//	}
//	
//	@PostMapping("/withdrawAmount")
//	public Interest withdrawAmount(@RequestBody Customer cus, Long amt) {
//		interestRepository.subBalance(cus.getAccNo(),amt);
//		return interestRepository.findByAccNo(cus.getAccNo());
//	}
//	
}
