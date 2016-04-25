/**
 * 
 */
package com.entity.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.entity.User;
import com.enums.SchoolKind;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.entity.School.java
 */
@Entity
public class SchoolVo {

	@Id
	Long schoolId;
	
	@ManyToOne
	User user;

	String name;
	
	SchoolKind schoolKind;
	
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
	
}
