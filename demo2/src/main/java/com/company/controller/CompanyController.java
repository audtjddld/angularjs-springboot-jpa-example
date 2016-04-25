package com.company.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.service.CompanyService;
import com.entity.vo.CompanyVo;

/**
 * @author 정명성
 * create date : 2015. 12. 24.
 * com.example.company.controller.CompanyController.java
 */
@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	/**
	 * 회사 정보 등록
	 * @author 정명성
	 * create date : 2016. 1. 14.
	 * 설명
	 * @param companyVo
	 * @return
	 */
	@RequestMapping(value="/rest/companies", method=RequestMethod.PUT)
	public ResponseEntity<String> put(@RequestBody CompanyVo companyVo) throws Exception {
		
		companyService.updateCompany(companyVo);
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/**
	 * 
	 * @author 정명성
	 * create date : 2016. 1. 14.
	 * 설명
	 * @param companyVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/rest/companies", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestBody CompanyVo companyVo) throws Exception{
		
		return new ResponseEntity(HttpStatus.OK);
	}
}
