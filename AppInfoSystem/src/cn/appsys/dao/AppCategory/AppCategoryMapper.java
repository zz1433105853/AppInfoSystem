package cn.appsys.dao.AppCategory;

import java.util.List;

import cn.appsys.pojo.AppCategory;

public interface AppCategoryMapper {
	/**
	 * 查询所有分类
	 * @return
	 */
	public List<AppCategory> getAppCategoryList();
	
	
	/**
	 * 查询父级分类
	 * @return
	 */
	public List<AppCategory> getAppCategoryLevel1();
}