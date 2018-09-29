package cn.appsys.dao.devUser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

public interface DevUserMapper {
	/**
	 * 前台用户登录
	 * @param devCode 用户登录名
	 * @return
	 */
	public DevUser login(@Param("devCode")String devCode);
	
	
}
