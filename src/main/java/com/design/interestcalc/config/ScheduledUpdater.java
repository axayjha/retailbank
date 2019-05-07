package com.design.interestcalc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.design.interestcalc.repository.InterestRepository;

@Component
public class ScheduledUpdater {
	@Autowired
	InterestRepository ir;
	 
	@Scheduled(fixedRate = 5000)
	public void updateInterestSchedule() {
		ir.calculateFixedDailyInterest();
		ir.calculateDailyInterest();
		 	// System.out.println();
	}
}
