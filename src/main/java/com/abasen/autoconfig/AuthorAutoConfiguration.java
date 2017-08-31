package com.abasen.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.abasen.service.PropertiesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ConditionalOnClass(PropertiesService.class)
@EnableConfigurationProperties(AuthorProperties.class)
@ConditionalOnProperty(prefix = "author", value = "enabled", matchIfMissing = true)
public class AuthorAutoConfiguration {
	
	private final AuthorProperties authorProperties;
	
	public AuthorAutoConfiguration(AuthorProperties authorProperties) {
		this.authorProperties = authorProperties;
	}
	
	public PropertiesService propertiesService() throws JsonProcessingException {
		
		PropertiesService propertiesService = new PropertiesService();
		propertiesService.setMsg(authorProperties.getName() +" :" + authorProperties.getPwd());

	    ObjectMapper objectMapper = new ObjectMapper();
	    System.out.println("arrayProps: " + objectMapper.writeValueAsString(authorProperties.getArrayProps()));
	    System.out.println("listProp1: " + objectMapper.writeValueAsString(authorProperties.getListProp1()));
	    System.out.println("listProp2: " + objectMapper.writeValueAsString(authorProperties.getListProp2()));
	    System.out.println("mapProps: " + objectMapper.writeValueAsString(authorProperties.getMapProps()));
	    System.out.println("Props: " + objectMapper.writeValueAsString(authorProperties.getProperties()));
	    return propertiesService;
		
	}

}
