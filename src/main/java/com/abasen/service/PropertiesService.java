package com.abasen.service;

import org.springframework.stereotype.Repository;

@Repository
public class PropertiesService {
	
	private String msg = "123d";

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
