package com.skss.city_show.entity;

import java.util.Date;

/**
 * @author weidp 用戶信息表
 */
public class PersonInfo {
	/**
	 * @author weidp 用戶id
	 */

	private Long userid;
	/**
	 * 用戶姓名
	 */
	private String name;
	/**
	 * 用戶头像地址
	 */
	private String profileImg;

	/**
	 * 用戶邮箱
	 */
	private String email;
	/**
	 * 用戶性别
	 */
	private String gender;
	/**
	 * 用戶状态
	 */
	private Integer enableStatus;
	/**
	 * 用戶类型 1顾客，2店家，3超级管理员
	 */
	private Integer userType;
	/**
	 * 用戶创建时间
	 */
	private Date createTime;
	/**
	 * 用戶修改时间
	 */
	private Date lastEidtTime;

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEidtTime() {
		return lastEidtTime;
	}

	public void setLastEidtTime(Date lastEidtTime) {
		this.lastEidtTime = lastEidtTime;
	}

}
