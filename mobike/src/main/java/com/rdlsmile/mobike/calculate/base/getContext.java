package com.rdlsmile.mobike.calculate.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class getContext {

	
	public static ApplicationContext getBean(){
		String[] conf={
				"classpath:conf/spring-mvc.xml",
				"classpath:conf/spring-mybatis.xml"};
		ApplicationContext ac = new FileSystemXmlApplicationContext(conf);
		return ac;
	}
	
	
}
