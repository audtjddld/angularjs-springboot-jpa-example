/**
 * 
 */
package com.example.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.School;

/**
 * @author 정명성
 * create date : 2015. 12. 24.
 * com.example.school.repository.SchoolRepository.java
 */
public interface SchoolRepository extends JpaRepository<School, Long>{

}
