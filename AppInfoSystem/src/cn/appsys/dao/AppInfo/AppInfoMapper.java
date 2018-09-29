package cn.appsys.dao.AppInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;
import cn.appsys.tools.PageSupport;

public interface AppInfoMapper {
	
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
	public List<AppInfo> getAppInfoByParam(@Param("softwareName")String softwareName,
			@Param("status")Integer status,
			@Param("flatformId")Integer flatformId,
			@Param("categoryLevel1")Integer categoryLevel1,
			@Param("categoryLevel2")Integer categoryLevel2,
			@Param("categoryLevel3")Integer categoryLevel3,
			@Param("currentPageNo")Integer currentPageNo,
			@Param("pageSize")Integer pageSize);
	
	/**
	 * 按条件查询总数
	 * @param appInfo
	 * @return
	 */
	public int getAppInfoCount(@Param("softwareName")String softwareName,
			@Param("status")Integer status,
			@Param("flatformId")Integer flatformId,
			@Param("categoryLevel1")Integer categoryLevel1,
			@Param("categoryLevel2")Integer categoryLevel2,
			@Param("categoryLevel3")Integer categoryLevel3);
	
	
	/**
	 * 按APK名称查询
	 * @param APKName
	 * @return
	 */
	public AppInfo getAppInfoByApk(@Param("APKName")String APKName);
	
	
	/**
	 * 新增App信息
	 * @param appInfo
	 * @return
	 */
	public int addAppInfo(AppInfo appInfo);
	
	/**
	 * 按id查询APP状态
	 * @param id
	 * @return
	 */
	public AppInfo getAppInfoById(@Param("id")Integer id);
	
	
	
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
	public int modifyLogo(@Param("id")Integer id);
	
	/**
	 * 按id修改版本信息
	 * @param versionId
	 * @return
	 */
	public int modifyVersionId(@Param("versionId")Integer versionId,@Param("id")Integer id);
	
	/**
	 * 根据appid查询app信息
	 * @param id
	 * @return
	 */
	public AppInfo getAppInfoByIdInfo(@Param("id")Integer id);
	
	
	/**
	 * 按id删除app信息
	 * @param id
	 * @return
	 */
	public int deleteApp(@Param("id")Integer id);
	
	
}
