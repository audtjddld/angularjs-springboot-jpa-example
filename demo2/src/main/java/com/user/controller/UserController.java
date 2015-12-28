package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.user.controller.UserController.java
 */
@Controller
public class UserController {

	/**
	 * 사용자 디폴트 페이지
	 */
	@RequestMapping(value="/users/**")
	public String userDefaultPage(){
		
		return "user/list";
	}
}
