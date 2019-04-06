package com.skss.city_show.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skss.city_show.dao.IshopDao;
import com.skss.city_show.dto.ShopExecution;
import com.skss.city_show.entity.Shop;
import com.skss.city_show.enums.ShopStateEnum;
import com.skss.city_show.exceptions.ShopOperationException;
import com.skss.city_show.service.IshopService;
import com.skss.city_show.util.ImgUtil;
import com.skss.city_show.util.PageCalculator;
import com.skss.city_show.util.PathUtil;

@Service
public class ShopServiceImpl implements IshopService {
	@Autowired
	private IshopDao iShopDao;

	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
		// TODO Auto-generated method stub
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			// 给店铺信息赋初始值
			shop.setEnableStatus(0);// 添加进去之后是“审核中”的状态
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			// 添加店铺信息
			int effectedNum = iShopDao.insertShop(shop);
			if (effectedNum <= 0) {
				throw new ShopOperationException("insert the shop is faile");// ShopOperationException 停止事物并回滚
			} else {
				if (shopImgInputStream != null) {
					// 存储图片
					addShopImg(shop, shopImgInputStream, fileName);
					// System.out.println("执行addShopImg方法");
					// 更新店铺图片地址
					effectedNum = iShopDao.updateShop(shop);
					// updateShop没有service的接口与impl,最终更新的img地址必须融合到参数shop中，才会把图片地址更新成功----这是一个bug
					if (effectedNum <= 0) {
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ShopOperationException("添加店铺失败" + e.getMessage());
		}
		System.out.println("shop添加成功");

		return new ShopExecution(ShopStateEnum.CHCK, shop);
	}

	/**
	 * 保存图片，并更新shopImg的值
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * 
	 */
	private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
		// TODO Auto-generated method stub
		// 获取shop图片的相对路径
		String relativeAddr = PathUtil.getShopImgPath(shop.getShopId());
		String shopImgAddr = ImgUtil.generateThumbnail(shopImgInputStream, fileName, relativeAddr);
		/* System.out.println("写入数据库的相对路径是"+shopImgAddr); */
		shop.setShopImg(shopImgAddr);
	}

	/**
	 * 根据店铺id查询店铺信息
	 *
	 */
	@Override
	public Shop queryShopByShopId(long shopId) {
		// TODO Auto-generated method stub

		return iShopDao.queryShopByShopId(shopId);
	}

	/**
	 * 修改店铺信息包括图片信息 1.判断是否需要修改图片 2.修改店铺信息
	 */
	@Override
	public ShopExecution modifyShop(Shop shop, InputStream inputStreamShopImg, String fileName) {
		// TODO Auto-generated method stub
		if (shop == null || shop.getShopId() == null) {// shop为null
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		} else {
			// 1.判断是否需要修改图片
			if (inputStreamShopImg != null && fileName != null && !"".equals(fileName)) {// 图片不为null
				Shop dbshop = iShopDao.queryShopByShopId(shop.getShopId());
				if (dbshop == null)
					System.out.println("dbshop参数为null");
				if (dbshop.getShopImg() != null) {
					System.out.println("从数据库查询出来的img地址是：" + dbshop.getShopImg());
					ImgUtil.deleteImgFile(dbshop.getShopImg());
					dbshop.setShopImg(null);
					System.out.println("清空数据库img地址后为：" + dbshop.getShopImg());
					// String
					// s=Thread.currentThread().getContextClassLoader().getResource("").getPath()+dbshop.getShopImg();
					// System.out.println("================="+s);
				} else {
					addShopImg(shop, inputStreamShopImg, fileName);
				}
			}
			// 2.修改店铺信息
			shop.setLastEditTime(new Date());
			int effectedNum = iShopDao.updateShop(shop);
			if (effectedNum <= 0) {
				return new ShopExecution(ShopStateEnum.INNER_ERROR);
			} else {
				shop = iShopDao.queryShopByShopId(shop.getShopId());
				return new ShopExecution(ShopStateEnum.SUCESS, shop);
			}
		}
	}

	/**
	 * 
	 * 分页查询店铺信息（店铺列表）
	 * 
	 * @param pageIndex
	 *            页码
	 * @param pageSize
	 *            每页的数量
	 */
	@SuppressWarnings("unused")
	@Override
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		int rowIndex = PageCalculator.calculatorRowIndex(pageIndex, pageSize);
		List<Shop> shopList = iShopDao.queryShopList(shopCondition, rowIndex, pageSize);
		int countShop = iShopDao.queryShopCount(shopCondition);
		ShopExecution se=new ShopExecution();
		if(!shopList.isEmpty()) {
			se.setShopList(shopList);
			se.setCount(countShop);
		}else {
			se.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return se;
	}

}
