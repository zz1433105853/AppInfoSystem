package cn.smbms.service.role;

import java.util.List;

import cn.smbms.pojo.Role;

public interface RoleService {
	/**
	 * 获得所有用户角色信息
	 */
	public List<Role> getRoleList();
}
