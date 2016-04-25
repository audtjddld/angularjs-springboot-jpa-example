/**
 * 
 */
package com.entity.vo;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.entity.Company.java
 */
public class CompanyVo {
	
	// 사용자 아이디
	long userId;
	// 회사 이름
	String name;
	// 연봉
	int salary;

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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
