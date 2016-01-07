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

import com.company.repository.CompanyRepository;
import com.entity.User;
import com.entity.UserVo;
import com.school.repository.SchoolRepository;
import com.user.repository.UserRepository;
import com.userfriend.repository.UserFriendRepository;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.user.service.UserService.java
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserFriendRepository userFriendRepository;
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	/**
	 * 사용자 리스트
	 * @author 정명성
	 * create date : 2015. 12. 24.
	 * 설명
	 * @param pageable
	 * @return
	 */
	public Page<User> userList(Pageable pageable) {
		
		return userRepository.findAll(pageable);
	}
	
	/**
	 * 사용자 조회
	 * @author 정명성
	 * create date : 2015. 12. 24.
	 * 설명
	 * @param user
	 * @return
	 */
	public User findUser(Long userId) {
		return userRepository.findByUserId(userId);
	}
	
	/**
	 * 사용자 저장
	 * @author 정명성
	 * create date : 2015. 12. 24.
	 * 설명
	 * @param user
	 */
	@Transactional
	public User saveUser(User user) {
		// 사용자 정보 저장
		return userRepository.save(user);
		// 친구 저장
		//userFriendRepository.save(user.getUserFriends());
		
		/*
		// 회사 저장
		List<Company> companies = user.getCompanies();
		companies.stream().forEach(company -> {
			company.setUser(user);
		});
		companyRepository.save(companies);
		
		// 학교 저장
		List<School> schools = user.getSchools();
		schools.stream().forEach(school -> {
			school.setUser(user);
		});
		schoolRepository.save(schools);
		
		// 친구 저장
		List<UserFriend> userFriends = user.getUserFriends();
		userFriends.stream().forEach(friend -> {
			friend.setUser(user);
		});
		userFriendRepository.save(userFriends);
		*/
	}
	
	/**
	 * 사용자 정보 수정
	 * @author 정명성
	 * create date : 2015. 12. 24.
	 * 설명
	 * @param userVo
	 * @param userId
	 */
	@Transactional
	public void updateUser(UserVo userVo, Long userId) throws Exception {
		
		User user = userRepository.findByUserId(userId);
		
		if( user == null ) {
			throw new Exception("사용자가 존재하지 않습니다. userId : " + userId);
		}
		// 사용자 정보 변경
		BeanUtils.copyProperties(userVo, user);
		
	}
	
	/**
	 * 사용자 정보 삭제
	 * @author 정명성
	 * create date : 2015. 12. 24.
	 * 설명
	 * @param userId
	 */
	@Transactional
	public void deleteUser(Long userId) {
		userRepository.delete(userId);
	}
}
