package com.design.interestcalc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_tbl")
public class Employee implements Serializable {
	
	@Id
	@Column(name = "emp_id")
	private Long empId;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;
	
	public Employee() {
		super();
	}

	public Employee(Long empId, String password, String name, String address) {
		super();
		this.empId = empId;
		this.password = password;
		this.name = name;
		this.address = address;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", password=" + password + ", name=" + name + ", address=" + address + "]";
	}

}
