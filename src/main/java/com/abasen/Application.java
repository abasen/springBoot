package com.abasen;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.abasen.listener.ApplicationStartEventListener;


//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement //启用事务管理
public class Application extends SpringBootServletInitializer {
	
	/**
	 * spring boot在启动过程中增加事件监听机制
	 * ApplicationStartedEvent
     * ApplicationEnvironmentPreparedEvent
     * ApplicationPreparedEvent
     * ApplicationReadyEvent
     * ApplicationFailedEvent
     * 实现监听步骤：
     * 1.监听类实现ApplicationListener接口
     * 2.将监听类添加到SpringApplication实例
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception {
        //SpringApplication.run(Application.class, args);
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new ApplicationStartEventListener());
        //app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
    
    
    /**
     * 如果是web项目，需要继承SpringBootServletInitializer并重写configure方法
     */
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
    	return application.sources(Application.class);
    }
    
    /**
     * 自定义事务管理器
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource){
    	return new DataSourceTransactionManager(dataSource);
    }
    
    /**
     * 上传附件容量限制
     * @return
     */
    @Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("102400KB");  
        factory.setMaxRequestSize("112400KB");  
        return factory.createMultipartConfig();  
    } 
}
