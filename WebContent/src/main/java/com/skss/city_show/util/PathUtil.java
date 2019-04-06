package com.skss.city_show.util;

/**
 * 图片在服务器上的存储路径
 * @author wdp 
 *
 */
public class PathUtil {
	/* 依据执行环境的不通，提供根路径（项目所有图片存放的路径） */
	static String separator = System.getProperty("file.separator");/* 获取操作系统文件夹的分隔符 */

	/**
	 * @param
	 * @return basePath 保存项目图片的根路径
	 */
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");/* 获取操作系统的名称 */
		
		String basePath = null;
		if (os.toLowerCase()
				.startsWith("win")) {/* toLowerCase()把字母转换成小写 如果是windows系统的 */
			basePath = "D:/apache-tomcat-8.0.47/Img/";
		} else {
			basePath = "/home/Img";
		}
		basePath = basePath.replace("/", separator);
		return basePath;
	}

	/**
	 * @param shopId
	 * @return imgPath.replace("/", separator) 返回上传文件的相对路径
	 */
	public static String getShopImgPath(long shopId) {
		String imgPath = "updload/item/shop" + shopId + "/";

		return imgPath.replace("/", separator);

	}

}
