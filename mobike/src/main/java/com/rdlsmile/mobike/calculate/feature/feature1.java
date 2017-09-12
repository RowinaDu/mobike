package com.rdlsmile.mobike.calculate.feature;

import org.springframework.context.ApplicationContext;

import com.rdlsmile.mobike.calculate.base.getContext;
import com.rdlsmile.mobike.calculate.base.init;
import com.rdlsmile.mobike.dao.TestDao;
import com.rdlsmile.mobike.entity.Test;

public class feature1 extends init{
	
	private static TestDao testDao;
	
	public static void main(String[] args) {
		
		ApplicationContext ac = getContext.getBean();
		testDao=ac.getBean("testDao", TestDao.class);
		Test test = new Test();
				
		test.setBikeid("123456789");
		//test.setTestid("1010101");
		testDao.save(test);
		
		
		
		
		System.out.println(testDao.findList(new Test()));
		
	}
	
}
