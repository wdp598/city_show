package com.skss.city_show.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skss.city_show.entity.Area;

/**
 * @author weidp
 *areaDao的接口
 */
@Repository
public interface IareaDao {
	/**
	 * 列出区域列表
	 * @return areaList
	 */
	public List<Area> queryArea();
}
