package com.design.interestcalc.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.design.interestcalc.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
	Customer findByAccNo(Long accNo);
	Customer findByAccNoAndPassword(Long accNo,String password);
	ArrayList<Customer> findAll();
	

	@Modifying
	@Query(value="DELETE FROM cust_tbl where ACC_NO = ?1",nativeQuery=true)
	@Transactional
	public void deleteByAccNo(Long accNo);
	
}
