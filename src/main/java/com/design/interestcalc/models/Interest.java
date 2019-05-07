package com.design.interestcalc.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Temporal;

@Entity
@Table(name="interest_tbl")
public class Interest implements Serializable{
	
	@Id
	@Column(name = "acc_no")
	private Long accNo;
	
	@Column(name = "acc_bal")
	private Double accBal;
	
	@Column(name = "interest_rate")
	private Double intRate;
	
	@Column(name = "daily_interest")
	private Double dailyInt;
	
	@Column(name = "cumulative_interest")
	private Double cumulativeInt;

	@Column(name = "last_updated")
	private Date lastUpdated;
	
	
	public Interest() {
		super();
	}

	public Interest(Long accNo, Double accBal, Double intRate, Double dailyInt, Double cumulativeInt, Date lastUpdated) {
		super();
		this.accNo = accNo;
		this.accBal = accBal;
		this.intRate = intRate;
		this.dailyInt = dailyInt;
		this.cumulativeInt = cumulativeInt;
		this.lastUpdated = lastUpdated;
	}

	public Long getAccNo() {
		return accNo;
	}

	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}

	public Double getAccBal() {
		return accBal;
	}

	public void setAccBal(Double accBal) {
		this.accBal = accBal;
	}

	public Double getIntRate() {
		return intRate;
	}

	public void setIntRate(Double intRate) {
		this.intRate = intRate;
	}

	public Double getDailyInt() {
		return dailyInt;
	}

	public void setDailyInt(Double dailyInt) {
		this.dailyInt = dailyInt;
	}

	public Double getCumulativeInt() {
		return cumulativeInt;
	}

	public void setCumulativeInt(Double cumulativeInt) {
		this.cumulativeInt = cumulativeInt;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "Interest [accNo=" + accNo + ", accBal=" + accBal + ", intRate=" + intRate + ", dailyInt="
				+ dailyInt + ", cumulativeInt=" + cumulativeInt + ",lastUpdated=" + lastUpdated + "]";
	}

}
