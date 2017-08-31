package com.abasen.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abasen.dao.UserDao;
import com.abasen.domain.User;

@Repository
public class UserService {
	
	private UserDao userDao;
	
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	@Transactional
	public void saveUser(User user){
		
	}
	
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
