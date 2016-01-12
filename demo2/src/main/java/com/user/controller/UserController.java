/**
 * 
 */
package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 정명성
 * create date : 2016. 1. 12.
 * com.user.controller.UserController.java
 */
@Controller
public class UserController {
	
	@RequestMapping(value="/users/**")
	public String userDefaultPage() { 
		
		return "index";
	}
}
