package com.abasen.listener;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

/**
 * spring boot 对应Enviroment已经准备完毕，但此时上下文context还没有创建
 * 在该监听中获取到ConfigurableEnvironment后可以对配置信息做操作，例如：修改默认的配置信息，增加额外的配置信息等等
 * @author Administrator
 *
 */
public class ApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
	
	private Logger logger = LoggerFactory.getLogger(ApplicationEnvironmentPreparedEventListener.class);

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		ConfigurableEnvironment envi = event.getEnvironment();
		MutablePropertySources mps = envi.getPropertySources();
		if(mps != null) {
			Iterator<PropertySource<?>> iter = mps.iterator();
			while(iter.hasNext()) {
				PropertySource<?> ps = iter.next();
				logger.info("ps.getName:{};ps.getSource:{};ps.getClass:{}", ps.getName(), ps.getSource(), ps.getClass());
			}
		}
		
	}

}
