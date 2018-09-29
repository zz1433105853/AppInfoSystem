package cn.appsys.service.AppInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;

public interface AppInfoService {
	/**
	 * 根据条件查询APP信息列表并分页
	 * @param softwareName 软件名称
	 * @param status APP状态
	 * @param flatformNameId 所属平台
	 * @param categoryLevel1 一级分类
	 * @param categoryLevel2 二级分类
	 * @param categoryLevel3 三级分类
	 * @param pages 起始位置和结束位置
	 * @return
	 */
	public List<AppInfo> getAppInfoByParam(String softwareName,Integer status,Integer flatformId,
			Integer categoryLevel1,Integer categoryLevel2,Integer categoryLevel3,Integer currentPageNo,Integer pageSize);
	
	/**
	 * 按条件查询总数
	 * @param appInfo
	 * @return
	 */
	public int getAppInfoCount(String softwareName,Integer status,Integer flatformId,Integer categoryLevel1,Integer categoryLevel2,Integer categoryLevel3);
	
	
	/**
	 * 按APK名称查询
	 * @param APKName
	 * @return
	 */
	public AppInfo getAppInfoByApk(String APKName);
	
	
	/**
	 * 新增App信息
	 * @param appInfo
	 * @return
	 */
	public int addAppInfo(AppInfo appInfo);
	
	/**
	 * 按id查询
	 * @param id
	 * @return
	 */
	public AppInfo getAppInfoById(Integer id);
	
	/**
	 * 修改信息
	 * @param appInfo
	 * @return
	 */
	public int modify(AppInfo appInfo);
	
	/**
	 * 按id删除logo
	 * @param id
	 * @return
	 */
	public int modifyLogo(Integer id);
	
	/**
	 * 按id修改版本信息
	 * @param versionId
	 * @return
	 */
	public int modifyVersionId(Integer versionId,Integer id);
	
	/**
	 * 根据appid查询app信息
	 * @param id
	 * @return
	 */
	public AppInfo getAppInfoByIdInfo(Integer id);
	
	
	/**
	 * 按id删除app信息
	 * @param id
	 * @return
	 */
	public int deleteApp(Integer id);
	
}
