package cn.smbms.dao.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;



public interface UserMapper {
	/**
	 * 获取用户集合
	 * @return
	 */
	public List<User>getUserList(User user);
	/**
	 * 获取用户集合
	 * @return
	 */
	public List<User>getUserList1( @Param ("userName")String userName,@Param("userRole") Integer roleId);
	
	/**
	 * 通过map集合获取用户
	 * @param userMap
	 * @return
	 */
	public List<User>getUserListByMap( Map<String ,String> userMap);
	/**
	 * 新增一个用户
	 * @return
	 */
	public  int  add(User user);
	/**
	 * 修改用户
	 */
	public int modify(User user);
	/**
	 * 修改用户密码
	 */
	public int updatePwd(@Param("id") Integer id,@Param("userPassword") String pwd);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteUser(@Param("id") Integer id);
	/**
	 * 根据用户id查询用户角色信息
	 */
	public List<User> getUserListByRoleId(@Param("userRole") Integer roleId);
	/**
	 * 根据用户Id获取地址信息
	 */
	public List<User> getAddressListByUserId(@Param("id") Integer userId);
	/**
	 * 根据用户角色ID删除用户
	 */
	public int delUserByRoleid(@Param("userRole") Integer roleId);
	/**
	 * 根据用户名和密码查询用户
	 * 
	 */
	public User getUser(User user);
	/**
	 * 根据ID查询相关用户
	 */
	public User getUserByid(int id);
	
	/**
	 * 根据用户角色列表 获取该角色列表下的用户列表信息--foreach_array
	 */
	public List<User> getUserByRoleId_foreach_array(Integer[] roleIds);
	/**
	 * 根据用户角色列表获取角色列表下的用户信息 使用list对象传输
	 * @param roleList
	 * @return
	 */
	public List<User> getUserByRoleId_foreach_list(List<Integer> roleList);
	/**
	 * 根据用户角色列表获取角色列表下的用户信息 使用map对象传输
	 */
	public List<User> getUserByRoleId_foreach_Map(Map <String,Object> conditionMap);
	/**
	 * 根据用户角色列表获取角色列表下的用户信息 使用map对象传输
	 */
	public List<User> getUserByRoleId_foreach_Map1(Map <String,Object> roleMap);
	/**
	 * 查询用户列表
	 * @param userName
	 * @param roleId
	 * @param userCode
	 * @param creationDate
	 * @return
	 */
	public List<User> getUselist_choose( @Param ("userName")String userName,
										@Param("userRole") Integer roleId,
										@Param("userCode" )String userCode,
										@Param("creationDate") Date creationDate);
	/**
	 * 查询用户列表（分页显示）
	 * @param userName
	 * @param roleId
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	public List<User> getUselistP (@Param ("userName")String userName,
									@Param("userRole") Integer roleId,
									@Param("from") Integer currentPageNo,
									@Param("pageSize") Integer pageSize);
	
	/**
	 * 根据用户名称查询是否存在用户
	 * 
	 */
	public User selectUserCodeExist(String userCode);
}
