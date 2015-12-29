package com.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.entity.UserVo;
import com.user.service.UserService;

/**
 * @author 정명성 create date : 2015. 12. 22.
 *         com.example.user.controller.UserRestController.java
 */
@RestController
public class UserRestController {

	@Autowired
	private UserService userService;
	
	/**
	 * 사용자 리스트
	 * 
	 * @author 정명성 create date : 2015. 12. 22. 설명
	 * @param user
	 * @param pageable
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/rest/users", method = RequestMethod.GET)
	public Page<User> list(@ModelAttribute UserVo userVo, Pageable pageable) throws Exception {

		return userService.userList(pageable);
	}

	/**
	 * 사용자 정보 입력
	 * 
	 * @author 정명성 create date : 2015. 12. 22. 설명
	 * @param user
	 * @param biresult
	 * @return
	 */
	@RequestMapping(value = "/rest/users", method = RequestMethod.POST)
	public User createUser(@RequestBody @Valid User user, BindingResult biresult) throws Exception {

		if(biresult.hasErrors()){
			throw new Exception("파라미터 Error!! ");
		}

		userService.saveUser(user);
		
		return user;
	}

	/**
	 * 사용자 정보 상세
	 * 
	 * @author 정명성 create date : 2015. 12. 22. 설명
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/rest/user/{userId}", method = RequestMethod.GET)
	public void searchUser(@PathVariable Long userId) {

		userService.findUser(userId);
	}

	/**
	 * 사용자 정보 상세
	 * 
	 * @author 정명성 create date : 2015. 12. 22. 설명
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/rest/user/{userId}", method = RequestMethod.PUT)
	public void updateUser(@PathVariable Long userId, @RequestBody UserVo userVo) throws Exception {

		userService.updateUser(userVo, userId);
	}

	/**
	 * 사용자 정보 삭제
	 * 
	 * @author 정명성 create date : 2015. 12. 22. 설명
	 * @param userId
	 */
	@RequestMapping(value = "/rest/user/{userId}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}

}