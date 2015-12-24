/**
 * 
 */
package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.user.repository.UserRepository.java
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserId(Long userId);
}
