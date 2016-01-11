/**
 * 
 */
package com.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 정명성
 * create date : 2016. 1. 11.
 * com.common.controller.ErrorController.java
 */

@Controller
public class ErrorCustomController implements ErrorController {

	/* (non-Javadoc)
	 * @see org.springframework.boot.autoconfigure.web.ErrorController#getErrorPath()
	 */
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
	/**
	 * 에러 페이지 맵핑
	 * @author 정명성
	 * create date : 2016. 1. 11.
	 * 설명
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/error")
	public String ErrorPage (HttpServletRequest request) {
		
		return "redirect:/";
	}
	
}
