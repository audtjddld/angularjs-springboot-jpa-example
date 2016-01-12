/**
 * 
 */
package com.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.enums.Gender;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.entity.User.java
 */
public class UserVo {

	String name;

	String email;

	Gender gender;

	List<UserFriend> userFriends;

	List<Company> companies;

	List<School> schools;
	
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

	public List<UserFriend> getUserFriends() {
		return userFriends;
	}

	public void setUserFriends(List<UserFriend> userFriends) {
		this.userFriends = userFriends;
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

	
}
