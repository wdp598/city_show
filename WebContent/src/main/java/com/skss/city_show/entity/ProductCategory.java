package com.skss.city_show.entity;

import java.util.Date;

/**
 * @author weidp 商品类别
 */
public class ProductCategory {
	/**
	 * 商品类别id
	 */
	private Long productCategoryId;
	/**
	 * 商品id
	 */
	private Long shopId;
	/**
	 * 商品类别名称
	 */
	private String productCategoryName;
	/**
	 * 商品类别权重
	 */
	private Integer priority;
	/**
	 * 商品类别创建时间
	 */
	private Date createTime;
	/**
	 * 商品类别更新时间
	 */
	private Date lastEditTime;


	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
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

}
