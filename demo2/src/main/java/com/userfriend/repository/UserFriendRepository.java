/**
 * 
 */
package com.userfriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.UserFriend;

/**
 * @author 정명성
 * create date : 2015. 12. 24.
 * com.example.friend.repository.friendRepository.java
 */
public interface UserFriendRepository extends JpaRepository<UserFriend, Long>{

}
