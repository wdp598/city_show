package com.skss.city_show.service.impl;

import java.io.InputStream;
import java.util.Date;

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
import com.skss.city_show.util.PathUtil;
@Service
public class ShopServiceImpl implements IshopService{
    @Autowired
	private IshopDao iShopDao;
	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) {
		// TODO Auto-generated method stub
		if(shop==null){
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			//给店铺信息赋初始值
			shop.setEnableStatus(0);//添加进去之后是“审核中”的状态
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			//添加店铺信息
			int effectedNum=iShopDao.insertShop(shop);
			if(effectedNum<=0){
				throw new ShopOperationException("insert the shop is faile");//ShopOperationException 停止事物并回滚
			}else{
				if(shopImgInputStream!=null){
					//存储图片
					addShopImg(shop,shopImgInputStream,fileName);
				//	System.out.println("执行addShopImg方法");
					//更新店铺图片地址
					effectedNum=iShopDao.updateShop(shop);
					//System.out.println("上传的地址是"+shopImg);
					if(effectedNum<=0){
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ShopOperationException("添加店铺失败"+e.getMessage());
		}
	System.out.println("shop添加成功");
	
		return new ShopExecution(ShopStateEnum.CHCK,shop);
	}
	/**
	 * 保存图片，并更新shopImg的值
	 * @param shop
	 * @param shopImgInputStream
	 * 
	 */
	private void addShopImg(Shop shop, InputStream shopImgInputStream,String fileName) {
		// TODO Auto-generated method stub
		//获取shop图片的相对路径
		String relativeAddr=PathUtil.getShopImgPath(shop.getShopId());
		String shopImgAddr=ImgUtil.generateThumbnail(shopImgInputStream, fileName,relativeAddr);
		/*System.out.println("写入数据库的相对路径是"+shopImgAddr);*/
		shop.setShopImg(shopImgAddr);
	}

}
