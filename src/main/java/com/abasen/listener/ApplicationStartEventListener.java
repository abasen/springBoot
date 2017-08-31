package com.abasen.listener;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * spring boot启动开始时执行的事件
 * @author Administrator
 *
 */
public class ApplicationStartEventListener implements ApplicationListener<ApplicationStartingEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		SpringApplication app = event.getSpringApplication();
		app.setBannerMode(Banner.Mode.OFF);// 不显示banner信息
		System.out.println("<<<<<<<<<<<<<ApplicationStartingEvent>>>>>>>>>>>>>>>>>>>>>");
	}

	
}
