/**
 * 
 */
package com.react.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 정명성
 * create date : 2016. 1. 20.
 * com.react.controller.ReactController.java
 */
@Controller
public class ReactController {
	
	@RequestMapping(value="/react")
	public String reactIndex() {
	
		return "react/index";
	}
}
