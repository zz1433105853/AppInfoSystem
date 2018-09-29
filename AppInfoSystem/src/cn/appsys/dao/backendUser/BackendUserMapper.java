package cn.appsys.dao.backendUser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;

public interface BackendUserMapper {
	
	/**
	 * 后台登录
	 * @param userCode
	 * @return
	 */
	public BackendUser login(@Param("userCode")String userCode);
}
