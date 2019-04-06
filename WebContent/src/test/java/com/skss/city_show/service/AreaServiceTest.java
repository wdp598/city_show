package com.skss.city_show.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skss.city_show.BaseTest;
import com.skss.city_show.entity.Area;
import com.skss.city_show.service.impl.AreaServiceImpl;

public class AreaServiceTest extends BaseTest{

	@Autowired
	private AreaServiceImpl areaServoiceImpl;
	
	@Test
	public void getAreaList(){
		List<Area> areaList=areaServoiceImpl.queryAreaList();
		System.out.println(areaList.get(0).getAreaName());
		
	}
	
	
}
