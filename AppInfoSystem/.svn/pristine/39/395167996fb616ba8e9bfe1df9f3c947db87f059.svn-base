package cn.appsys.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.AppCategory.AppCategoryService;
import cn.appsys.service.AppInfo.AppInfoService;
import cn.appsys.service.AppVersion.AppVersionService;
import cn.appsys.service.DataDictionary.DataDictionaryService;
import cn.appsys.service.devUser.DevUserService;
import cn.appsys.tools.Constants;
import cn.appsys.tools.PageSupport;

@RequestMapping("/dev")
@Controller
public class DevUserController {
	@Resource
	private DevUserService devUserService;

	@Resource
	private DataDictionaryService dataDictionaryService;

	@Resource
	private AppInfoService appInfoService;

	@Resource
	private AppCategoryService appCategoryService;

	@Resource
	private AppVersionService appVersionService;

	

	/**
	 * App信息列表
	 * 
	 * @param model
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping("/flatform/app/list")
	public String devList(Model model, @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
			@RequestParam(value = "querySoftwareName", required = false) String querySoftwareName,
			@RequestParam(value = "queryStatus", required = false) Integer queryStatus,
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
		List<AppInfo> appInfoList = appInfoService.getAppInfoByParam(querySoftwareName, queryStatus,
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
		model.addAttribute("queryStatus", queryStatus);
		model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
		model.addAttribute("queryFlatformId", queryFlatformId);
		model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
		model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);
		model.addAttribute("categoryLevel2List", categoryLevel2List);
		model.addAttribute("categoryLevel3List", categoryLevel3List);
		// List<DataDictionary> dictiList =
		// dataDictionaryService.getDataDictionaryList();
		return "/developer/appinfolist";
	}

	/**
	 * Ajax获取级分类
	 * 
	 * @return
	 */
	@RequestMapping("/categorylevellist")
	@ResponseBody
	public String categorylevellist(@RequestParam(value="pid",required=false) String pid) {
		if (pid == null || pid.equals("")) {
			List<AppCategory> categoryLevel1List = appCategoryService.getAppCategoryLevel1();
			// 获取一级分类
			return JSON.toJSONString(categoryLevel1List);
		} else {
			// 获取所有分类
			List<AppCategory> categoryList = appCategoryService.getAppCategoryList();
			List<AppCategory> categoryLevel2List = new ArrayList<AppCategory>();
			// 循环出该id下的二、三级分类
			for (AppCategory app : categoryList) {
				if (Integer.valueOf(pid) == app.getParentId())
					categoryLevel2List.add(app);
			}
			return JSON.toJSONString(categoryLevel2List);
		}
	}

	/**
	 * 所属平台列表
	 * 
	 * @return
	 */
	@RequestMapping("/datadictionarylist")
	@ResponseBody
	public String datadictionarylist(@RequestParam(value="tcode",required=false) String tcode) {
		// 获取平台
		List<DataDictionary> flatFormList = dataDictionaryService.getDataDictionaryByTypeCode(tcode);
		return JSON.toJSONString(flatFormList);
	}

	/**
	 * 判断APK名称是否存在
	 * 
	 * @param APKName
	 * @return
	 */
	@RequestMapping("/apkexist")
	@ResponseBody
	public String apkexist(@RequestParam(value="APKName",required=false) String APKName) {
		if (APKName == null || APKName.equals("")) {
			return "empty";
		} else {
			AppInfo appInfo = appInfoService.getAppInfoByApk(APKName);
			if (appInfo != null)
				return "exist";
			else
				return "noexist";
		}
	}

	/**
	 * 跳转到新增界面
	 * 
	 * @return
	 */
	@RequestMapping("/flatform/app/appinfoadd")
	public String add() {
		return "/developer/appinfoadd";
	}

	/**
	 * 新增数据
	 * 
	 * @param appInfo
	 * @return
	 */
	@RequestMapping("appinfoaddsave")
	public String addSave(AppInfo appInfo, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "a_logoPicPath", required = false) MultipartFile attach) {
		String logoPicPath = ""; // LOGO图片URL路径
		String logoLocPath = ""; // LOGO图片的服务器存储路径
		if (!attach.isEmpty()) {
			String path = "F:/Y2/SSM" + request.getContextPath() + "/statics" + File.separator + "uploadfiles";
			// 原文件名
			String oldFileName = attach.getOriginalFilename();
			// 原文件后缀
			String prefix = FilenameUtils.getExtension(oldFileName);
			// 上传文件大小(50kb)
			int fileSize = 50000;
			if (attach.getSize() > fileSize) {
				request.setAttribute("fileUploadError", "上传大小不得超过50KB");
				return "redirect:/dev/flatform/app/appinfoadd";
			} else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("jpeg")
					|| prefix.equalsIgnoreCase("png")) {
				String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000) + "_Personal.jpg";
				File targetFile = new File(path, fileName);
				if (!targetFile.exists())
					targetFile.mkdirs();
				// 保存
				try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("fileUploadError", " 上传失败！ ");
					return "redirect:/dev/flatform/app/appinfoadd";
				}
				logoPicPath = request.getContextPath() + "/statics/uploadfiles/" + fileName;
				logoLocPath = path + File.separator + fileName;
				appInfo.setLogoPicPath(logoPicPath);
				appInfo.setLogoLocPath(logoLocPath);
			} else {
				request.setAttribute("fileUploadError", " 上传的图片格式不正确!");
				return "redirect:/dev/flatform/app/appinfoadd";
			}
		}
		appInfo.setCreatedBy(((DevUser) session.getAttribute(Constants.DEV_USER_SESSION)).getId());
		appInfo.setCreationDate(new Date());
		if (appInfoService.addAppInfo(appInfo) > 0)
			return "redirect:/dev/flatform/app/list";
		else
			return "redirect:/dev/flatform/app/appinfoadd";

	}

	/**
	 * 跳转修改页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/appinfomodify")
	public String modify(@RequestParam(value="id",required=false) String id, Model model) {
		AppInfo appInfo = appInfoService.getAppInfoById(Integer.valueOf(id));
		model.addAttribute("appInfo", appInfo);
		return "/developer/appinfomodify";
	}

	/**
	 * 保存修改APP信息
	 * 
	 * @param appInfo
	 * @return
	 */
	@RequestMapping("/appinfomodifysave")
	public String modifySave(AppInfo appInfo, Model model, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "attach", required = false) MultipartFile attach) {

		String logoPicPath = ""; // LOGO图片URL路径
		String logoLocPath = ""; // LOGO图片的服务器存储路径
		if (!attach.isEmpty()) {
			String path = "F:/Y2/SSM" + request.getContextPath() + "/statics" + File.separator + "uploadfiles";
			// 原文件名
			String oldFileName = attach.getOriginalFilename();
			// 原文件后缀
			String prefix = FilenameUtils.getExtension(oldFileName);
			// 上传文件大小(50kb)
			int fileSize = 50000;
			if (attach.getSize() > fileSize) {
				request.setAttribute("fileUploadError", "上传大小不得超过50KB");
				return "redirect:/dev/flatform/app/appinfoadd";
			} else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("jpeg")
					|| prefix.equalsIgnoreCase("png")) {
				String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000) + "_Personal.jpg";
				File targetFile = new File(path, fileName);
				if (!targetFile.exists())
					targetFile.mkdirs();
				// 保存
				try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("fileUploadError", " 上传失败！ ");
					return "redirect:/dev/flatform/app/appinfoadd";
				}
				logoPicPath = request.getContextPath() + "/statics/uploadfiles/" + fileName;
				logoLocPath = path + File.separator + fileName;
				appInfo.setLogoPicPath(logoPicPath);
				appInfo.setLogoLocPath(logoLocPath);
			} else {
				request.setAttribute("fileUploadError", " 上传的图片格式不正确!");
				return "redirect:/dev/flatform/app/appinfoadd";
			}
		}
		appInfo.setModifyBy(((DevUser) session.getAttribute(Constants.DEV_USER_SESSION)).getId());
		appInfo.setModifyDate(new Date());
		if (appInfoService.modify(appInfo) > 0) {
			model.addAttribute("appInfo", appInfo);
			return "redirect:/dev/flatform/app/list";
		} else {
			return "redirect:/dev/flatform/app/appinfoadd";
		}
	}

	/**
	 * 删除图片
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delfile")
	@ResponseBody
	public String delfile(@RequestParam(value="id",required=false) String id, @RequestParam(value = "flag", required = false) String flag,
			HttpSession session) {
		if (id == null || id.equals("")) {
			return "error";
		} else {
			if (flag.equals("apk")) {
				AppVersion appVersion = new AppVersion();
				appVersion.setId(Integer.valueOf(id));
				appVersion.setModifyBy(((DevUser) session.getAttribute(Constants.DEV_USER_SESSION)).getId());
				appVersion.setModifyDate(new Date());
				if (appVersionService.deleteImage(appVersion) > 0) {
					return "success";
				} else {
					return "failed";
				}
			} else {

				AppInfo appInfo = appInfoService.getAppInfoById(Integer.valueOf(id));
				File file = new File(appInfo.getLogoLocPath());
				file.delete();
				if (appInfoService.modifyLogo(Integer.valueOf(id)) > 0) {
					return "success";
				} else {
					return "failed";
				}
			}
		}
	}

	/**
	 * 按Appid查询版本信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/appversionadd")
	public String appversionadd(@RequestParam(value="id",required=false) String id, Model model) {
		List<AppVersion> appList = appVersionService.getAppVersionById(Integer.valueOf(id));
		model.addAttribute("appVersionList", appList);
		model.addAttribute("appId", id);
		return "/developer/appversionadd";
	}

	/**
	 * 新增版本信息
	 * 
	 * @param appVersion
	 * @return
	 */
	@RequestMapping("/addversionsave")
	public String addversionsave(AppVersion appVersion, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "a_downloadLink", required = false) MultipartFile attach) {
		String apkLocPath = ""; // apk文件的服务器存储路径
		String apkFileName = ""; // 上传的 apk文件名称
		if (!attach.isEmpty()) {
			String path = "F:/Y2/SSM" + request.getContextPath() + "/statics/apk";
			// 原文件名
			String oldFileName = attach.getOriginalFilename();
			// 原文件后缀
			String prefix = FilenameUtils.getExtension(oldFileName);
			// 上传文件大小(50kb)
			int fileSize = 512000000;
			if (attach.getSize() > fileSize) {
				request.setAttribute("fileUploadError", "上传大小不得超过500MB");
				return "forward:/dev/appversionadd?id=" + appVersion.getAppId();
			} else if (prefix.equalsIgnoreCase("apk")) {
				File targetFile = new File(path, oldFileName);
				if (!targetFile.exists())
					targetFile.mkdirs();
				// 保存
				try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("fileUploadError", " 上传失败！ ");
					return "forward:/dev/appversionadd?id=" + appVersion.getAppId();
				}
				apkFileName = oldFileName;
				apkLocPath = path + File.separator + oldFileName;
				appVersion.setApkLocPath(apkFileName);
				appVersion.setApkFileName(apkLocPath);
				appVersion.setDownloadLink(apkLocPath);
			} else {
				request.setAttribute("fileUploadError", " 上传的apk格式不正确!");
				return "forward:/dev/appversionadd?id=" + appVersion.getAppId();
			}
		}
		appVersion.setCreatedBy(((DevUser) session.getAttribute(Constants.DEV_USER_SESSION)).getId());
		appVersion.setCreationDate(new Date());
		if (appVersionService.addAppVersion(appVersion) > 0) {
			int versionId = appVersionService.getAppVersionId();
			if (appInfoService.modifyVersionId(versionId, appVersion.getAppId()) > 0)
				return "redirect:/dev/flatform/app/list";
			else
				return "forward:/dev/appversionadd?id=" + appVersion.getAppId();
		} else
			return "forward:/dev/appversionadd?id=" + appVersion.getAppId();
	}

	/**
	 * 修改APP版本信息
	 * 
	 * @return
	 */
	@RequestMapping("/appversionmodify")
	public String appversionmodify(@RequestParam(value="vid",required=false) String vid, 
			@RequestParam(value="aid",required=false) String aid, Model model) {
		List<AppVersion> appList = appVersionService.getAppVersionById(Integer.valueOf(aid));
		AppVersion appVersion = appVersionService.appVersionInfo(Integer.valueOf(vid));
		model.addAttribute("appVersionList", appList);
		model.addAttribute("appVersion", appVersion);
		return "/developer/appversionmodify";
	}

	/**
	 * 修改版本信息
	 * 
	 * @return
	 */
	@RequestMapping("/appversionmodifysave")
	public String appversionmodifysave(AppVersion appVersion, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "attach", required = false) MultipartFile attach) {
		String apkLocPath = ""; // apk文件的服务器存储路径
		String apkFileName = ""; // 上传的 apk文件名称
		if (!attach.isEmpty()) {
			String path = "F:/Y2/SSM" + request.getContextPath() + "/statics/apk";
			// 原文件名
			String oldFileName = attach.getOriginalFilename();
			// 原文件后缀
			String prefix = FilenameUtils.getExtension(oldFileName);
			// 上传文件大小(50kb)
			int fileSize = 512000000;
			if (attach.getSize() > fileSize) {
				request.setAttribute("fileUploadError", "上传大小不得超过500MB");
				return "forward:/dev/appversionadd?aid=" + appVersion.getAppId() + "&vid=" + appVersion.getId();
			} else if (prefix.equalsIgnoreCase("apk")) {
				File targetFile = new File(path, oldFileName);
				if (!targetFile.exists())
					targetFile.mkdirs();
				// 保存
				try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("fileUploadError", " 上传失败！ ");
					return "forward:/dev/appversionadd?aid=" + appVersion.getAppId() + "&vid=" + appVersion.getId();
				}
				apkFileName = oldFileName;
				apkLocPath = path + File.separator + oldFileName;
				appVersion.setApkLocPath(apkLocPath);
				appVersion.setApkFileName(apkFileName);
				appVersion.setDownloadLink(apkLocPath);
			} else {
				request.setAttribute("fileUploadError", " 上传的apk格式不正确!");
				return "forward:/dev/appversionadd?aid=" + appVersion.getAppId() + "&vid=" + appVersion.getId();
			}
		}
		appVersion.setModifyBy(((DevUser) session.getAttribute(Constants.DEV_USER_SESSION)).getId());
		appVersion.setModifyDate(new Date());
		if (appVersionService.modifyAppVersion(appVersion) > 0) {
			return "redirect:/dev/flatform/app/list";
		} else
			return "forward:/dev/appversionadd?aid=" + appVersion.getAppId() + "&vid=" + appVersion.getId();
	}

	/**
	 * 以REST风格查看
	 * 
	 * @return
	 */
	@RequestMapping(value = "/appview/{id}", method = RequestMethod.GET)
	public String appview(@PathVariable String id, Model model) {
		List<AppVersion> appList = appVersionService.getAppVersionById(Integer.valueOf(id));
		AppInfo appInfo = appInfoService.getAppInfoByIdInfo(Integer.valueOf(id));
		model.addAttribute("appVersionList", appList);
		model.addAttribute("appInfo", appInfo);
		return "/developer/appinfoview";
	}

	/**
	 * 删除APP信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delapp")
	@ResponseBody
	public String delapp(@RequestParam(value="id",required=false) String id) {
		if (id == null) {
			return "notexist";
		} else {
			if (appVersionService.deleteInfo(Integer.valueOf(id)) >= 0)
				if (appInfoService.deleteApp(Integer.valueOf(id)) > 0)
					return "true";
				else
					return "false";
			else
				return "false";
		}
	}

	/**
	 * APP上下架
	 * 
	 * @param appId
	 * @return
	 */
	@RequestMapping("sale")
	@ResponseBody
	public String sale(@RequestParam(value="appId",required=false) String appId,HttpSession session) {
		Map<String, String> mapInfo = new HashMap<String, String>();
		
		if (appId != null) {
			mapInfo.put("errorCode", "0");
			AppInfo appInfo = appInfoService.getAppInfoByIdInfo(Integer.valueOf(appId));
			if (appInfo.getStatus() == 2 || appInfo.getStatus() == 5) {
				appInfo.setStatus(4);
				appInfo.setOnSaleDate(new Date());
			} else if (appInfo.getStatus() == 4	) {
				appInfo.setStatus(5);
				appInfo.setOffSaleDate(new Date());
			} else {
				mapInfo.put("errorCode", "exception000001");
			}
			appInfo.setModifyBy(((DevUser) session.getAttribute(Constants.DEV_USER_SESSION)).getId());
			appInfo.setModifyDate(new Date());
			appInfo.setUpdateDate(new Date());
			int result = appInfoService.modify(appInfo);
			if (result > 0) {
				mapInfo.put("resultMsg", "success");
			} else {
				mapInfo.put("resultMsg", "failed");
			}
		} else {
			mapInfo.put("errorCode", "param000001");
		}
		return JSON.toJSONString(mapInfo);
	}
}
