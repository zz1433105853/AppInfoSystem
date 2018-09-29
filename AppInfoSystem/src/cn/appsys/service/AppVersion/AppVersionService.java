package cn.appsys.service.AppVersion;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppVersion;

public interface AppVersionService {
	/**
	 * 查询所有版本信息
	 * @return
	 */
	public List<AppVersion> getAppVersionList();
	
	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	public List<AppVersion> getAppVersionById(Integer appId);
	
	/**
	 * 新增数据
	 * @param appVersion
	 * @return
	 */
	public int addAppVersion(AppVersion appVersion);
	
	/**
	 * 获取最近新增的id
	 * @return
	 */
	public int getAppVersionId();
	
	
	
	/**
	 * 根据版本id查询版本信息
	 * @param id
	 * @return
	 */
	public AppVersion appVersionInfo(Integer id);
	
	/**
	 * 修改版本信息
	 * @param appVersion
	 * @return
	 */
	public int modifyAppVersion(AppVersion appVersion);
	
	/**
	 * 按id删除apk信息
	 * @param id
	 * @return
	 */
	public int deleteImage(AppVersion appVersion);
	
	/**
	 * 按appid删除版本信息
	 * @param appId
	 * @return
	 */
	public int deleteInfo(Integer appId);
}