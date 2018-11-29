package com.skss.city_show.web.shopadmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skss.city_show.dto.ShopExecution;
import com.skss.city_show.entity.Area;
import com.skss.city_show.entity.PersonInfo;
import com.skss.city_show.entity.Shop;
import com.skss.city_show.entity.ShopCategory;
import com.skss.city_show.enums.ShopStateEnum;
import com.skss.city_show.service.IareaService;
import com.skss.city_show.service.IshopCategoryService;
import com.skss.city_show.service.IshopService;
import com.skss.city_show.util.CaptchaCodeUtil;
import com.skss.city_show.util.HttpServerRequestUtil;

@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
	@Autowired
	private IshopCategoryService iShopCategoryService;
	@Autowired
	private IshopService iShopService;
	@Autowired
	private IareaService iAreaService;

	/**
	 * 管理店铺列表信息，只有传入shipId才能对店铺信息进行编辑，否则就重定向到店铺列表页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getshopmanagementinfo", method = RequestMethod.GET)
	@ResponseBody
	@SuppressWarnings("unused")
	private Map<String, Object> getShopManagementInfo(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Long shoId = HttpServerRequestUtil.getLong(request, "shopId");
		if (shoId <= 0) {
			Object currentShopobj = request.getSession().getAttribute("currentShop");
			if (currentShopobj == null) {
				modelMap.put("redirect", true);
				modelMap.put("url", "/city_show/shopadmin/shoplist");
			} else {
				Shop currentShop = (Shop) currentShopobj;
				modelMap.put("redirect", false);
				modelMap.put("shopId", currentShop.getShopId());
			}
		} else {
			Shop currentShop = new Shop();
			currentShop.setShopId(shoId);
			request.getSession().setAttribute("currentShop", currentShop);
			modelMap.put("redirect", false);
		}

		return modelMap;

	}

	/**
	 * 分页获取店铺列列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getshoplist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getShopList(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		PersonInfo user = new PersonInfo();
		user.setUserId(2L);
		user.setCreateTime(new Date());
		user.setEmail("wdp598@126.com");
		user.setName("wdp598");
		request.getSession().setAttribute("user", user);
		user = (PersonInfo) request.getSession().getAttribute("user");
		Shop shopCondition = new Shop();
		shopCondition.setOwner(user);
		try {
			ShopExecution se = iShopService.getShopList(shopCondition, 0, 100);
			List<Shop> shopList = new ArrayList<Shop>();
			shopList = se.getShopList();
			System.out.println("店铺列表长度是：：" + se.getShopList().size());
			modelMap.put("shopList", shopList);
			modelMap.put("user", user);
			modelMap.put("success", true);
		} catch (Exception e) {
			// TODO: handle exception

			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
		}
		return modelMap;

	}

	/**
	 * 修改店铺信息
	 * 
	 * @param request
	 * @return Map
	 */
	@RequestMapping(value = "/modifyshop", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> modifyShop(HttpServletRequest request) {// http请求头中的所有信息全部封装在request里面
		// 用户在前端表格填写的信息，在表格提交的时候都会封装在request里面
		Map<String, Object> modelMap = new HashMap<>();
		boolean verifyCode = CaptchaCodeUtil.comparisonCaptchaCode(request);
		if (!verifyCode == true) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "验证码输入有误");
			return modelMap;
		}
		// 1.接受并转化相应信息，包括店铺信息以及图片信息
		// 1.1接收店铺信息并转换成实体类
		String shopStr = HttpServerRequestUtil.getString(request, "shopStr");// "shopStr"由前端ajax传入
		// 使用jackson将字符串shopStr 转化成实体类
		ObjectMapper objectmapper = new ObjectMapper();
		Shop shop = null;
		try {
			shop = objectmapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			// TODO: handle exception
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		// 1.2接收图片信息并转换成实体类
		CommonsMultipartFile commonsMultipartFile = null;// 这儿实际是一个文件
		// 文件上传解析器 创建一个通用的多部分解析器.
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());// request.getSession().getServletContext()本次会话的上下文内容
		// 判断 request 是否有文件上传,即多部分请求...
		if (commonsMultipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multipartHttpRequest = (MultipartHttpServletRequest) request;// 如果不强制转换成MultipartHttpServletRequest，后续的Contrller就获取不到file
			// 从multipartHttpRequest获取上传文件
			commonsMultipartFile = (CommonsMultipartFile) multipartHttpRequest.getFile("shopImg");// "shopImg"来自前端ajax传入
		} else {
			modelMap.put("ssuccess", false);
			modelMap.put("errMsg", "上传图片为空");
			return modelMap;
		}
		// 2.修改店铺信息
		if (shop != null && shop.getShopId() != null) {
			PersonInfo owner = new PersonInfo();
			owner.setUserId(1L);
			shop.setOwner(owner);
			ShopExecution shopExecution = null;
			try {
				if (commonsMultipartFile == null) {
					shopExecution = iShopService.modifyShop(shop, null, null);
				} else {
					shopExecution = iShopService.modifyShop(shop, commonsMultipartFile.getInputStream(),
							commonsMultipartFile.getOriginalFilename());
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (shopExecution.getState() == ShopStateEnum.SUCESS.getState()) {
				modelMap.put("success", true);
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", shopExecution.getStateInfo());
			}
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入shopId");
			return modelMap;
		}
	}

	/**
	 * 根据店铺id获取店铺信息，并返回到前台
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getshopbyshopid", method = RequestMethod.GET)
	@ResponseBody
	@SuppressWarnings("unused")
	private Map<String, Object> getShopByShopId(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Long shopId = HttpServerRequestUtil.getLong(request, "shopId");
		if (shopId > -1) {
			Shop shop = iShopService.queryShopByShopId(shopId);
			List<Area> areaList = iAreaService.queryAreaList();
			modelMap.put("shop", shop);
			modelMap.put("areaList", areaList);
			modelMap.put("success", true);
		} else {
			modelMap.put("success", false);
			modelMap.put("errmsg", "empty shopId");
		}

		return modelMap;

	}

	@RequestMapping(value = "/getshopinitinfo", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getinitshopinfo(ShopCategory shopCategory) {
		// System.out.println("进入获取店铺类别与区域的方法");
		Map<String, Object> shopCategoryModelMap = new HashMap<String, Object>();
		List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
		List<Area> areaList = new ArrayList<Area>();
		try {
			shopCategoryList = iShopCategoryService.getShopCategoryList(new ShopCategory());
			areaList = iAreaService.queryAreaList();
			shopCategoryModelMap.put("shopCategoryList", shopCategoryList);
			shopCategoryModelMap.put("areaList", areaList);
			shopCategoryModelMap.put("success", true);

			for (ShopCategory shopCategory2 : shopCategoryList) {
				System.out.println("获得店铺列表：" + shopCategory2.getShopCategoryName());
			}
		} catch (Exception e) {
			// TODO: handle exception
			shopCategoryModelMap.put("success", false);
			shopCategoryModelMap.put("errMsg", e.getMessage());
		}

		return shopCategoryModelMap;
	}

	/**
	 * 注册
	 * 
	 * @param request
	 * @return Map
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/registershop", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request) {// http请求头中的所有信息全部封装在request里面
		// 用户在前端表格填写的信息，在表格提交的时候都会封装在request里面
		Map<String, Object> modelMap = new HashMap<>();
		boolean verifyCode = CaptchaCodeUtil.comparisonCaptchaCode(request);
		if (!verifyCode == true) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "验证码输入有误");
			return modelMap;
		}
		// 1.接受并转化相应信息，包括店铺信息以及图片信息
		// 1.1接收店铺信息并转换成实体类
		String shopStr = HttpServerRequestUtil.getString(request, "shopStr");// "shopStr"由前端页面传入
		// 使用jackson将字符串shopStr 转化成实体类
		ObjectMapper objectmapper = new ObjectMapper();
		Shop shop = null;
		try {
			shop = objectmapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		// 1.2接收图片信息并转换成实体类
		CommonsMultipartFile commonsMultipartFile = null;// 这儿实际是一个文件
		// 文件上传解析器 创建一个通用的多部分解析器.
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());// request.getSession().getServletContext()本次会话的上下文内容
		// 判断 request 是否有文件上传,即多部分请求...
		if (commonsMultipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multipartHttpRequest = (MultipartHttpServletRequest) request;// 如果不强制转换成MultipartHttpServletRequest，后续的Contrller就获取不到file
			// 从multipartHttpRequest获取上传文件
			commonsMultipartFile = (CommonsMultipartFile) multipartHttpRequest.getFile("shopImg");// "shopImg"来自前端JS的name
		} else {
			modelMap.put("ssuccess", false);
			modelMap.put("errMsg", "上传图片为空");
			return modelMap;
		}
		// 2.注册
		if (shop != null && commonsMultipartFile != null) {
			// PersonInfo owner=new PersonInfo();
			PersonInfo owner = (PersonInfo) request.getSession().getAttribute("user");
			// owner.setUserId(1L);
			shop.setOwner(owner);
			ShopExecution shopExecution = null;
			try {
				shopExecution = iShopService.addShop(shop, commonsMultipartFile.getInputStream(),
						commonsMultipartFile.getOriginalFilename());
			} catch (IOException e) {
				/* e.printStackTrace(); */
				e.getMessage();
			}
			if (shopExecution.getState() == ShopStateEnum.CHCK.getState()) {
				modelMap.put("success", true);
				// 该用户可以操作的店铺列表
				@SuppressWarnings("unchecked")
				List<Shop> shopList = (List<Shop>) request.getSession().getAttribute("shopList");
				if (shopList == null || shopList.size() == 0) {
					shopList = new ArrayList<Shop>();
				}
				shopList.add(shopExecution.getShop());
				request.getSession().setAttribute("shopList", shopList);
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", shopExecution.getStateInfo());
			}
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "注册失败");
			return modelMap;
		}
	}

	/**
	 * @param inputStream
	 * @param file
	 *            将CommonsMultipartFile 转换成File
	 */
	/*
	 * @SuppressWarnings("unused") private static void inputStreamToFile(InputStream
	 * inputStream,File file){ //输出流 FileOutputStream outputStream=null; try {
	 * outputStream=new FileOutputStream(file); int bytesRead=0; byte[] buffer=new
	 * byte[1024]; while((bytesRead=inputStream.read(buffer))!=-1){
	 * outputStream.write(buffer, 0, bytesRead); } } catch (Exception e) { // TODO:
	 * handle exception throw new
	 * RuntimeException("调用inputStreamToFile异常："+e.getMessage()); }finally{ try {
	 * if(outputStream!=null){ outputStream.close(); } if(inputStream!=null){
	 * inputStream.close(); }
	 * 
	 * } catch (Exception e2) { // TODO: handle exception throw new
	 * RuntimeException("关闭输入or输出流异常:"+e2.getMessage()); } }
	 * 
	 * }
	 */

}
