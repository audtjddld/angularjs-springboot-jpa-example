/**
 * 
 */
package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.School;
import com.school.repository.SchoolRepository;

/**
 * @author 정명성
 * create date : 2016. 1. 14.
 * com.school.service.SchoolService.java
 */
@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;
	
	/**
	 * 학교 입력
	 * @author 정명성
	 * create date : 2016. 1. 14.
	 * 설명
	 * @param school
	 */
	@Transactional
	public void insertSchool(List<School> school) {
		school.forEach(s -> {
			schoolRepository.save(s);
		});
	}
}
