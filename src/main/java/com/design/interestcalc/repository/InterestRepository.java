package com.design.interestcalc.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.design.interestcalc.models.Interest;

public interface InterestRepository extends JpaRepository<Interest,Long>{
	Interest findByAccNo(Long accNo);
	ArrayList<Interest> findAll();
	
	@Modifying
	@Query(value="update interest_tbl set acc_bal = (acc_bal + ?2), last_updated = ?3 where acc_no = ?1",nativeQuery=true)
	@Transactional
	int addBalance(Long accNo, Double amt, Date date);
	
	@Modifying
	@Query(value="update interest_tbl set acc_bal = (acc_bal - ?2), last_updated = ?3 where acc_no = ?1",nativeQuery=true)
	@Transactional
	int subBalance(Long accNo, Double amt, Date date);
	
	@Modifying
	@Query(value="update interest_tbl set daily_interest = (acc_bal*interest_rate)/(365*100)",nativeQuery=true)
	@Transactional
	int calculateFixedDailyInterest();
	
	@Modifying
	@Query(value="update interest_tbl set cumulative_interest = cumulative_interest + daily_interest",nativeQuery=true)
	@Transactional
	int calculateDailyInterest();
	
	@Modifying
	@Query(value="DELETE FROM  INTEREST_TBL where ACC_NO = ?1",nativeQuery=true)
	@Transactional
	public void deleteByAccNo(Long accNo);
	
}
