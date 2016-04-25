package com.polymer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 정명성
 * create date : 2016. 1. 20.
 * com.polymer.controller.PolymerController.java
 */
@Controller
public class PolymerController {

	@RequestMapping(value="/polymer")
	public String PolymerIndex() {
		
		return "polymer/index";
	}
}
