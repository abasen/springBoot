package com.abasen.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abasen.domain.User;

@Repository
public class UserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public User findByUsername(String username){
		return null;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

}
