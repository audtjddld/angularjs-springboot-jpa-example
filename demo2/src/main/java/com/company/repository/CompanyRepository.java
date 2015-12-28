/**
 * 
 */
package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Company;

/**
 * @author 정명성
 * create date : 2015. 12. 24.
 * com.example.company.repository.CompanyRepository.java
 */
public interface CompanyRepository extends JpaRepository<Company, Long>{

}
