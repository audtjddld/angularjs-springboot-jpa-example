package com.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 정명성
 * create date : 2015. 12. 24.
 * com.example.main.controller.MainController.java
 */
@Controller
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 메인 페이지
	 * @author 정명성
	 * create date : 2015. 12. 24.
	 * 설명
	 * @return
	 */
	@RequestMapping(value="/")
	public String indexPage() {
		
		return "index";
	}
	/**
	 * 메인 컨텐츠
	 * @author 정명성
	 * create date : 2015. 12. 24.
	 * 설명
	 * @return
	 */
	@RequestMapping(value="/main")
	public String mainContent(){
		logger.info("asdfasdfasdf");
		
		return "main/content";
	}
}
