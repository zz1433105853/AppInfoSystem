package cn.appsys.service.AppCategory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppCategory.AppCategoryMapper;
import cn.appsys.pojo.AppCategory;

@Service
public class AppCategoryServiceImpl implements AppCategoryService {

	@Resource
	private AppCategoryMapper appCategoryMapper;

	@Override
	public List<AppCategory> getAppCategoryList() {
		List<AppCategory> appList = null;
		try {
			appList = appCategoryMapper.getAppCategoryList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appList;
	}

	@Override
	public List<AppCategory> getAppCategoryLevel1() {
		List<AppCategory> appList = null;
		try {
			appList = appCategoryMapper.getAppCategoryLevel1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appList;
	}
	
}
