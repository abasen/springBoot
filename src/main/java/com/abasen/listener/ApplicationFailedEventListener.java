package com.abasen.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * spring boot启动异常时执行事件 
 * 在异常发生时，最好是添加虚拟机对应的钩子进行资源的回收与释放，能友善的处理异常信息
 * @author Administrator
 *
 */
public class ApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {

	@Override
	public void onApplicationEvent(ApplicationFailedEvent event) {
		
	}
	
	//在spring boot中已经为大家考虑了这一点，默认情况开启了对应的功能：
//	public void registerShutdownHook() {
//        if (this.shutdownHook == null) {
//            // No shutdown hook registered yet.
//            this.shutdownHook = new Thread() {
//                @Override
//                public void run() {
//                    doClose();
//                }
//            };
//            Runtime.getRuntime().addShutdownHook(this.shutdownHook);
//        }
//    }

}
