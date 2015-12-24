/**
 * 
 */
package com.example.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.enums.Gender;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.entity.User.java
 */
@Entity
public class User {

	@Id
	@GeneratedValue
	Long userId;
	
	@OneToMany(mappedBy="user")
	List<UserFriend> userFriends;

	@OneToMany(mappedBy="user")
	List<Company> companies;
	
	@OneToMany(mappedBy="user")
	List<School> schools;

	String name;
	
	String email;
	
	Gender gender;
	
	Date registerDt;	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

	public List<UserFriend> getUserFriends() {
		return userFriends;
	}

	public void setUserFriends(List<UserFriend> userFriends) {
		this.userFriends = userFriends;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getRegisterDt() {
		return registerDt;
	}

	public void setRegisterDt(Date registerDt) {
		this.registerDt = registerDt;
	}

	
}
