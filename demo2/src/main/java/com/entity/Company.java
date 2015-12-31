/**
 * 
 */
package com.entity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.entity.Company.java
 */
@Entity
public class Company {
	
	@Id
	@GeneratedValue
	Long CompanyId;
	
	@JsonIgnore
	@ManyToOne
	User user;

	// 회사 이름
	String name;
	// 연봉
	int salary;
	
	// 등록일
	Date registerDt;
	
	@PrePersist
	void prePersist() {
		registerDt = new Date();
	}
	
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

	public Date getRegisterDt() {
		return registerDt;
	}

	public void setRegisterDt(Date registerDt) {
		this.registerDt = registerDt;
	}

}
