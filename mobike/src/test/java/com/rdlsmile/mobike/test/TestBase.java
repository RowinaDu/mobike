package com.rdlsmile.mobike.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public abstract class TestBase {
	public ApplicationContext getContext(){
		String[] conf={
				"classpath:conf/spring-mvc.xml",
				"classpath:conf/spring-mybatis.xml"};
//		ApplicationContext ac
//			= new ClassPathXmlApplicationContext(conf);
		
		
		
		ApplicationContext ac = new FileSystemXmlApplicationContext(conf);
		return ac;
		
		
		
		
		
		
	}
}





