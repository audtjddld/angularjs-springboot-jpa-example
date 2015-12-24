/**
 * 
 */
package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.entity.Friend.java
 */
@Entity
public class UserFriend {
	
	@EmbeddedId
	UserFriendId id;
	
	@ManyToOne
	@JoinColumn(name="user_id", insertable=false, updatable=false)
	User user;
	
	@ManyToOne
	@JoinColumn(name="friend_user_id", insertable=false, updatable=false)
	User friend;
	

	public UserFriendId getId() {
		return id;
	}


	public void setId(UserFriendId id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public User getFriend() {
		return friend;
	}


	public void setFriend(User friend) {
		this.friend = friend;
	}
	
	@SuppressWarnings("serial")
	@Embeddable
	public static class UserFriendId implements Serializable {
		
		@Column(name="user_id")
		Long userId;

		@Column(name="friend_user_id")
		Long freindUserId;
		
		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public Long getFreindUserId() {
			return freindUserId;
		}

		public void setFreindUserId(Long freindUserId) {
			this.freindUserId = freindUserId;
		}
		
	}
}
