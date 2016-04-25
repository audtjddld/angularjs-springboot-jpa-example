/**
 * 
 */
package com.company.service;

import java.net.BindException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.repository.CompanyRepository;
import com.entity.Company;
import com.entity.User;
import com.entity.vo.CompanyVo;
import com.user.repository.UserRepository;

/**
 * @author 정명성
 * create date : 2015. 12. 24.
 * com.example.company.service.CompanyService.java
 */
@Service
public class CompanyService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 회사 등록
	 * @author 정명성
	 * create date : 2016. 1. 14.
	 * 설명
	 * @param companies
	 */
	@Transactional
	public void updateCompany(CompanyVo companyVo) throws Exception {
		
		User user = userRepository.findByUserId(companyVo.getUserId());
		if(user == null) {
			throw new BindException();
		}
		Company company = new Company();
		BeanUtils.copyProperties(companyVo, company);
		company.setUser(user);
		company = companyRepository.save(company);
		
		logger.info(company.getName() + " " + company.getSalary() + " " + company.getCompanyId());
		
	}
}
