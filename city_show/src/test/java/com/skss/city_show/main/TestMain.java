package com.skss.city_show.main;

import org.junit.Test;

import com.skss.city_show.BaseTest;
import com.skss.city_show.util.WriteExcelUtil;

public class TestMain extends BaseTest{
	private static String basePath =Thread.currentThread().getContextClassLoader().getResource("").getPath();
	@Test
	public void testiImgUtil() {
		WriteExcelUtil.WriteExcel();
		System.out.println("basePath+++"+basePath);
		
	}
	
}
