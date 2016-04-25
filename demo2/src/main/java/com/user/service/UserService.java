/**
 * 
 */
package com.user.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anntation.ProcessInfo;
import com.company.service.CompanyService;
import com.entity.User;
import com.entity.vo.UserVo;
import com.enums.Actions;
import com.school.service.SchoolService;
import com.user.repository.UserRepository;
import com.userfriend.repository.UserFriendRepository;

/**
 * @author 정명성 create date : 2015. 12. 22.
 *         com.example.user.service.UserService.java
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserFriendRepository userFriendRepository;

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private CompanyService companyService;

	/**
	 * 사용자 리스트
	 * 
	 * @author 정명성 create date : 2015. 12. 24. 설명
	 * @param pageable
	 * @return
	 */
	@ProcessInfo(title = "사용자조회", actions = Actions.select)
	public Page<User> userList(Pageable pageable) {

		return userRepository.findAll(pageable);
	}

	/**
	 * 사용자 조회
	 * 
	 * @author 정명성 create date : 2015. 12. 24. 설명
	 * @param user
	 * @return
	 */
	@Transactional(readOnly = true)
	public User findUser(Long userId) {
		return userRepository.findByUserId(userId);
	}

	/**
	 * 사용자 저장
	 * 
	 * @author 정명성 create date : 2015. 12. 24. 설명
	 * @param user
	 */
	@Transactional
	public User saveUser(UserVo userVo) {

		User user = new User();

		BeanUtils.copyProperties(userVo, user);

		// 사용자 정보 저장
		return userRepository.save(user);
		// 친구 저장
		// userFriendRepository.save(user.getUserFriends());

	}

	/**
	 * 사용자 정보 수정
	 * 
	 * @author 정명성 create date : 2015. 12. 24. 설명
	 * @param userVo
	 * @param userId
	 */
	@Transactional
	public void updateUser(UserVo userVo, Long userId) throws Exception {

		User user = userRepository.findByUserId(userId);

		if (user == null) {
			throw new Exception("사용자가 존재하지 않습니다. userId : " + userId);
		}
		// 사용자 정보 변경
		BeanUtils.copyProperties(userVo, user);

	}

	/**
	 * 사용자 정보 삭제
	 * 
	 * @author 정명성 create date : 2015. 12. 24. 설명
	 * @param userId
	 */
	@Transactional
	public void deleteUser(Long userId) {
		userRepository.delete(userId);
	}
}
