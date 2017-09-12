/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rdlsmile.mobike.dao;

import java.util.List;

import com.rdlsmile.mobike.entity.Train;

public interface TrainDao{

	void save(Train train);

	List<Train> findList(Train train);

	Train get(String id);

	void delete(Train train);
	
	
	void insertAll(List<Train> trainList);
}