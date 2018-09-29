package cn.appsys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.AppCategory.AppCategoryService;
import cn.appsys.service.AppInfo.AppInfoService;
import cn.appsys.service.AppVersion.AppVersionService;
import cn.appsys.service.DataDictionary.DataDictionaryService;
import cn.appsys.service.backendUser.BackendUserService;
import cn.appsys.service.devUser.DevUserService;
import cn.appsys.tools.Constants;
import cn.appsys.tools.PageSupport;

@RequestMapping("/manager")
@Controller
public class BackendUserController {
	
	@Resource
	private BackendUserService backendUserService;
	
	@Resource
	private AppInfoService appInfoService;
	
	@Resource
	private AppVersionService appVersionService;
	
	@Resource
	private DataDictionaryService dataDictionaryService;
	
	@Resource
	private AppCategoryService appCategoryService;

	
	/**
	 * 查询APP信息
	 * @param model
	 * @param pageIndex
	 * @param querySoftwareName
	 * @param queryFlatformId
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @return
	 */
	@RequestMapping("/backend/app/list")
	public String devList(Model model, @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
			@RequestParam(value = "querySoftwareName", required = false) String querySoftwareName,
			@RequestParam(value = "queryFlatformId", required = false) Integer queryFlatformId,
			@RequestParam(value = "queryCategoryLevel1", required = false) Integer queryCategoryLevel1,
			@RequestParam(value = "queryCategoryLevel2", required = false) Integer queryCategoryLevel2,
			@RequestParam(value = "queryCategoryLevel3", required = false) Integer queryCategoryLevel3) {
		// 设置页面容量
		int pageSize = Constants.pageSize;
		// 当前页码
		int currentPageNo = 1;
		if (pageIndex != null) {
			currentPageNo = pageIndex;
		}
		// 总数量
		int totalCount = appInfoService.getAppInfoCount(querySoftwareName, queryFlatformId, queryFlatformId,
				queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3);
		// 总页数
		PageSupport pages = new PageSupport();
		pages.setPageSize(pageSize);
		pages.setCurrentPageNo(currentPageNo);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		// 控制首页和尾页
		if (currentPageNo < 1)
			currentPageNo = 1;
		else if (currentPageNo > totalPageCount)
			currentPageNo = totalPageCount;
		// 获取分页数据
		List<AppInfo> appInfoList = appInfoService.getAppInfoByParam(querySoftwareName, 1,
				queryFlatformId, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3,
				(currentPageNo - 1) * pageSize, pages.getPageSize());
		// 获取APP状态
		List<DataDictionary> statusList = dataDictionaryService.getDataDictionaryByTypeCode("APP_STATUS");
		// 获取平台
		List<DataDictionary> flatFormList = dataDictionaryService.getDataDictionaryByTypeCode("APP_FLATFORM");
		// 获取一级分类
		List<AppCategory> categoryLevel1List = appCategoryService.getAppCategoryLevel1();
		// 获取所有分类
		List<AppCategory> categoryList = appCategoryService.getAppCategoryList();
		// 获取二级分类
		List<AppCategory> categoryLevel2List = new ArrayList<AppCategory>();
		List<AppCategory> categoryLevel3List = new ArrayList<AppCategory>();
		// 循环出该id下的二、三级分类
		for (AppCategory app : categoryList) {
			if (queryCategoryLevel1 == app.getParentId())
				categoryLevel2List.add(app);
			else if (queryCategoryLevel2 == app.getParentId() && queryCategoryLevel2 != null)
				categoryLevel3List.add(app);
		}
		model.addAttribute("appInfoList", appInfoList);
		model.addAttribute("statusList", statusList);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("categoryLevel1List", categoryLevel1List);
		model.addAttribute("statusList", statusList);
		model.addAttribute("pages", pages);
		model.addAttribute("querySoftwareName", querySoftwareName);
		model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
		model.addAttribute("queryFlatformId", queryFlatformId);
		model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
		model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);
		model.addAttribute("categoryLevel2List", categoryLevel2List);
		model.addAttribute("categoryLevel3List", categoryLevel3List);
		return "/backend/applist";
	}


	/**
	 * 审核
	 * @return
	 */
	@RequestMapping("/check")
	public String check(@RequestParam(value="aid",required=false) String aid,
			@RequestParam(value="vid",required=false) String vid,Model model){
		AppInfo appInfo = appInfoService.getAppInfoByIdInfo(Integer.valueOf(aid));
		AppVersion appVersion = appVersionService.appVersionInfo(Integer.valueOf(vid));
		model.addAttribute("appInfo",appInfo);
		model.addAttribute("appVersion",appVersion);
		return "/backend/appcheck";
	}
	
	
	@RequestMapping("/checksave")
	public String checksave(AppInfo appInfo,HttpSession session){
		if(appInfoService.modify(appInfo) > 0){
			return "redirect:/manager/backend/app/list";
		} else {
			return "forward:/manager/check?aid="+appInfo.getId()+"&vid="+appInfo.getVersionId();
		}
	}
}
