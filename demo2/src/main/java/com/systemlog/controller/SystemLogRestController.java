package com.systemlog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.SystemLog;
import com.systemlog.service.SystemLogService;

@RestController
@RequestMapping(value = "/rest/systemLogs")
public class SystemLogRestController {

	@Autowired
	private SystemLogService systemLogService;
	
	@RequestMapping
	public Page<SystemLog> selectSystemLogs(Pageable pageable) {
		return systemLogService.selectSystemLogs(pageable);
	}
}
