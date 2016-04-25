/**
 * 
 */
package com.entity.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.enums.Gender;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.entity.User.java
 */
public class UserVo {

	@NotNull
	@NotEmpty
	String name;

	@Email
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
