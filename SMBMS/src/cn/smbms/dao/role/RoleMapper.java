package cn.smbms.dao.role;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Role;

public interface RoleMapper {
	//创建一个Role的mapper的接口
	/**
	 * 增加一个角色
	 */
	public int addRole(Role role);
	/**
	 * 修改用户信息
	 * 
	 */
	
	public int upRole(Role role);
	/**
	 * 删除一个角色用户
	 *785* */
	public  int  delRole(@Param("id") Integer id);
	/**
	 * 查询用户角色信息
	 */
	public List<Role> getRoleByName(Role role);
	/**
	 * 根据用户角色查询用户信息
	 */
	public List<Role> getRoleByUser(@Param("id") Integer id);
	
	/**
	 * 获得所有用户角色信息
	 */
	public List<Role> getRoleList();
	/**
	 * 分页显示用户角色信息
	 */
	public List<Role> getRolelistBypage(@Param("roleName") String roleName,
										@Param("from") Integer currentPageNo,
										@Param("pageSize") Integer pageSize);
}
