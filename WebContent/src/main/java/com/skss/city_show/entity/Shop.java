package com.skss.city_show.entity;

import java.util.Date;

/**
 * @author weidp 店铺类
 */
public class Shop {
	/**
	 * 店铺id
	 */
	private Long shopId;
	/**
	 * 店铺名称
	 */
	private String shopName;
	/**
	 * 店铺描述
	 */
	private String shopDesc;
	/**
	 * 店铺地址
	 */
	private String shopAddr;
	/**
	 * 店铺电话
	 */
	private String phone;
	/**
	 * 店铺图片
	 */
	private String shopImg;
	/**
	 * 店铺权重
	 */
	private Integer priority;
	/**
	 * 店铺创建时间
	 */
	private Date createTime;
	/**
	 * 店铺更新时间
	 */
	private Date lastEditTime;
	/**
	 * 店铺状态 -1不可用，0审核中，1可用
	 */
	private Integer enableStatus;
	/**
	 * 超级管理员对店家的提醒
	 */
	private String advice;
	/**
	 * 店铺所属区域
	 */
	private Area area;
	/**
	 * 店主
	 */
	private PersonInfo owner;
	
	/**
	 * 该店铺所属店铺类别
	 */
	private ShopCategory shopCategory;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopDesc() {
		return shopDesc;
	}

	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}

	public String getShopAddr() {
		return shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShopImg() {
		return shopImg;
	}

	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public PersonInfo getOwner() {
		return owner;
	}

	public void setOwner(PersonInfo owner) {
		this.owner = owner;
	}

	public ShopCategory getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(ShopCategory shopCategory) {
		this.shopCategory = shopCategory;
	}

}
