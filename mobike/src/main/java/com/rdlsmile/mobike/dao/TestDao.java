/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rdlsmile.mobike.dao;

import java.util.List;

import com.rdlsmile.mobike.entity.Test;

public interface TestDao{

	void save(Test test);

	List<Test> findList(Test test);

	Test get(String id);

	void delete(Test test);
	
	
	void insertAll(List<Test> testList);
}