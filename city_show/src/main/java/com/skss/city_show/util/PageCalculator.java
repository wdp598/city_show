package com.skss.city_show.util;

/**
 * @author Administrator 分页查询工具
 */
public class PageCalculator {
	/**
	 * 计算每页从第几条开始选取数据
	 * @param pageIndex
	 *            页码
	 * @param pageSize
	 *            每页的数量
	 * @return int
	 */
	public static int calculatorRowIndex(int pageIndex, int pageSize) {
		return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;

	}

}
