package com.design.interestcalc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// import org.springframework.data.annotation.Id;

@Entity
@Table(name="cust_tbl")
public class Customer implements Serializable {
	
	@Id
	@Column(name = "acc_no")
	private Long accNo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "pan_no")
	private String panno;

	@Column(name = "aadhar_no")
	private String aadhar;
	
	@Column(name = "password")
	private String password;
	
	public Customer() {
		super();
	}

	public Customer(Long accNo, String name, String address, String PANno, String aadharNo, String password) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.address = address;
		this.panno = PANno;
		this.aadhar = aadharNo;
		this.password = password;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadharNo(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getAccNo() {
		return accNo;
	}

	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPANno() {
		return panno;
	}

	public void setPANno(String PANno) {
		this.panno = PANno;
	}

	@Override
	public String toString() {
		return "Customer [accNo=" + accNo + ", name=" + name + ", address=" + address + ", panno="
				+ panno + ", aadhar=" + aadhar + "]";
	}
	
}
