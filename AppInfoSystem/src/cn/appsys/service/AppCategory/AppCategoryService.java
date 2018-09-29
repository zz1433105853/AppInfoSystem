package cn.appsys.service.AppCategory;

import java.util.List;

import cn.appsys.pojo.AppCategory;

public interface AppCategoryService {
	public List<AppCategory> getAppCategoryList();
	
	public List<AppCategory> getAppCategoryLevel1();
}
