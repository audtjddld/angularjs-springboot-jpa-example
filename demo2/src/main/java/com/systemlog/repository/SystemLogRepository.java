package com.systemlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.SystemLog;

public interface SystemLogRepository extends JpaRepository<SystemLog, Long> {

}
