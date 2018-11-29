package com.skss.city_show.main;

import org.junit.Test;

import com.skss.city_show.BaseTest;

public class TestMain extends BaseTest{
	private static String basePath =Thread.currentThread().getContextClassLoader().getResource("").getPath();
	@Test
	public void testiImgUtil() {
		System.out.println("basePath+++"+basePath);
		
	}
	
}
