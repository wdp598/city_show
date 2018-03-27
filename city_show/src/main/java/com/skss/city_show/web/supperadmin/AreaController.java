package com.skss.city_show.web.supperadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skss.city_show.entity.Area;
import com.skss.city_show.service.impl.AreaServiceImpl;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping(value="/superadmin")
public class AreaController {
	Logger logger=(Logger) LoggerFactory.getLogger(AreaController.class);
	
@Autowired
private AreaServiceImpl areaServiceImpl;
@RequestMapping(value="/listarea",method=RequestMethod.GET)
@ResponseBody
	private Map<String,Object> listArea(){
	logger.info("===start===");
	long startTime=System.currentTimeMillis();
		Map<String,Object> modelMap= new HashMap<String,Object>();
		List<Area> list=new ArrayList<Area>();
		try {
			list=areaServiceImpl.queryAreaList();
			modelMap.put("rows", list);
			modelMap.put("totals", list.size());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("error", e.getMessage());
		}
		logger.error("test Error!");
		long endTime=System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",endTime-startTime);
		logger.info("===end===");
		return modelMap;	
	}
	
	
}
