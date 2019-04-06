package com.skss.city_show.entity;

import java.util.Date;

//区域类，统一使用引用类型，默认值都为null
  /**
 * 区域类
 */
public class Area {
	/**
	 * 区域id
	 */
	private Integer areaId;
	/**
	 * 区域名称
	 */
	private String areaName;
	/**
	 * 区域权重
	 */
	private Integer priority;
	/**
	 * 区域创建时间
	 */
	private Date creatTime;
	/**
	 * 区域更新时间
	 */
	private Date lastEditTime;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

}
