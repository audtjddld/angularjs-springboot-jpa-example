package com.systemlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.entity.SystemLog;
import com.systemlog.repository.SystemLogRepository;

@Service
public class SystemLogService {
	
	@Autowired
	private SystemLogRepository systemLogRepository;
	
	/**
	 * 시스템 로그 조회
	 * @param pageable
	 * @return
	 */
	public Page<SystemLog> selectSystemLogs(Pageable pageable) {
		return systemLogRepository.findAll(pageable);
	}
}
