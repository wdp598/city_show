package com.skss.city_show.entity;

import javax.xml.crypto.Data;

/**
 * @author weidp 商品图片
 */
public class ProductImg {
	/**
	 * 商品图片id
	 */
	private Long productImgId;
	/**
	 * 商品图片地址
	 */
	private String imgAddr;
	/**
	 * 商品图片描述
	 */
	private String imgDesc;
	/**
	 * 商品图片权重
	 */
	private Integer priority;
	/**
	 * 商品图片创建时间
	 */
	private Data createTime;
	/**
	 * 商品id
	 */
	private Long productId;


	public Long getProductImgId() {
		return productImgId;
	}

	public void setProductImgId(Long productImgId) {
		this.productImgId = productImgId;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Data getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Data createTime) {
		this.createTime = createTime;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	

}
