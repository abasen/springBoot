package com.abasen.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abasen.service.PropertiesService;

@Controller
@EnableAutoConfiguration
public class PropertiesController {
	
	@Autowired
	private PropertiesService propertiesService;
	
	
	@RequestMapping("/testPro")
	@ResponseBody
    public String testPro(){
		System.out.println("123213123");
        return propertiesService.getMsg();
    }

}
