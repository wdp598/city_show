package com.skss.city_show.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skss.city_show.dao.IareaDao;
import com.skss.city_show.entity.Area;
import com.skss.city_show.service.IareaService;

@Service	
public class AreaServiceImpl implements IareaService {

	@Autowired
	private IareaDao areaDao;
	@Override
	public List<Area> queryAreaList() {
		// TODO Auto-generated method stub
		List<Area> areaList=areaDao.queryArea();
		return areaList;
	}

	
}
