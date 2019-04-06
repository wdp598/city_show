package com.skss.city_show.entity;

import java.util.Date;
import java.util.List;

/**
 * @author weidp 商品类
 *
 */
public class Product {
	/**
	 * 商品id
	 */
	private Long productId;
	/**
	 * 商品名称
	 */
	private String productName;
	/**
	 * 商品描述
	 */
	private String productDesc;
	/**
	 * 商品图片地址
	 */
	private String imgAddr;
	/**
	 * 商品原价
	 */
	private String normalPrice;
	/**
	 * 商品折后价
	 */
	private String promotionPrice;
	/**
	 * 商品权重
	 */
	private Integer priority;
	/**
	 * 商品创建时间
	 */
	private Date createTime;
	/**
	 * 商品更新时间
	 */
	private Date lastEditTime;
	/**
	 * 商品状态 0下架，1在展示系统前端显示
	 */
	private Integer enableStuts;
	/**
	 * 商品图片详情列表
	 */
	private List<ProductImg> productList;
	/**
	 * 该所属商品类别
	 */
	private ProductCategory productCategory;
	/**
	 * 该商品所属店铺
	 */
	private Shop shop;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public String getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(String normalPrice) {
		this.normalPrice = normalPrice;
	}

	public String getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(String promotionPrice) {
		this.promotionPrice = promotionPrice;
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

	public Integer getEnableStuts() {
		return enableStuts;
	}

	public void setEnableStuts(Integer enableStuts) {
		this.enableStuts = enableStuts;
	}

	public List<ProductImg> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductImg> productList) {
		this.productList = productList;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

}
