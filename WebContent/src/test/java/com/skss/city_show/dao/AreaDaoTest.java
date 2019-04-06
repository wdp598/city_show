package com.skss.city_show.dao;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skss.city_show.BaseTest;
import com.skss.city_show.entity.Area;

public class AreaDaoTest extends BaseTest{
  @Autowired
  private IareaDao iareaDao;
  
 @Test
 public void testQueryArea(){
 	 List<Area> areaList=iareaDao.queryArea();
 	System.out.println("区域列表的长度是："+areaList.size()); 
	  
 }
/* public static void main(String[] args) {
	 AreaDaoTest t =new  AreaDaoTest();
	 List<Area> areaList=t.testQueryArea();
	 System.out.println("测试完成");
	 
}*/
	
}
