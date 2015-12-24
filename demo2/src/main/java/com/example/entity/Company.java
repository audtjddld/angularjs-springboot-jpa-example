/**
 * 
 */
package com.example.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.entity.Company.java
 */
@Entity
public class Company {
	
	@Id
	Long CompanyId;
	
	@ManyToOne
	User user;

	// 회사 이름
	String name;
	// 연봉
	int salary;
	// 등록일
	Date regdate;
	
	public Long getCompanyId() {
		return CompanyId;
	}

	public void setCompanyId(Long companyId) {
		CompanyId = companyId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	
}
