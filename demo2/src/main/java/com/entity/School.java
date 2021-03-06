/**
 * 
 */
package com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.enums.SchoolKind;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.entity.School.java
 */
@Entity
public class School {

	@Id
	@GeneratedValue
	Long schoolId;
	
	@JsonIgnore
	@ManyToOne
	User user;

	String name;
	
	@Enumerated(EnumType.STRING)
	SchoolKind schoolKind;
	
	Date registerDt;
	
	@PrePersist
	void prePersist() {
		registerDt = new Date();
	}
	
	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
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

	public SchoolKind getSchoolKind() {
		return schoolKind;
	}

	public void setSchoolKind(SchoolKind schoolKind) {
		this.schoolKind = schoolKind;
	}

	public Date getRegisterDt() {
		return registerDt;
	}

	public void setRegisterDt(Date registerDt) {
		this.registerDt = registerDt;
	}
	
}
