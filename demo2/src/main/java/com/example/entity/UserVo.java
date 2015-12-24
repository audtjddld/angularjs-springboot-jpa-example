/**
 * 
 */
package com.example.entity;

import java.sql.Date;

import com.example.enums.Gender;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.entity.User.java
 */
public class UserVo {

	String name;
	
	String email;
	
	Gender gender;

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

	
}
