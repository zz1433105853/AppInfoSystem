package cn.smbms.service.user.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.service.user.UserServce;
import cn.smbms.tools.MyBatisUtil;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserServce {
	SqlSession sqlSession = MyBatisUtil.createSqlSession();;
	List<User> userlist = new ArrayList<User>();
	User user = new User();
	int count = 0;
	@Autowired
	private UserMapper userMapper;

	@Override
	/**
	 * 根据传入的用户名称和id查询相关记录
	 */
	public List<User> getUserListByMap(Map<String, String> userMap) {
		userlist = sqlSession.getMapper(UserMapper.class).getUserListByMap(
				userMap);
		return userlist;
	}

	@Override
	/**
	 * 增加一个用户
	 */
	public int add(User user) {
		return count = sqlSession.getMapper(UserMapper.class).add(user);
	}

	@Override
	/**
	 * 修改用户信息
	 */
	public int modify(User user) {
		return count = sqlSession.getMapper(UserMapper.class).modify(user);
	}

	@Override
	/**
	 * 更新用户信息
	 */
	public int updatePwd(Integer id, String pwd) {
		return count = sqlSession.getMapper(UserMapper.class)
				.updatePwd(id, pwd);
	}

	@Override
	/**
	 * 删除用户信息
	 */
	public int deleteUser(Integer id) {
		return count = sqlSession.getMapper(UserMapper.class).deleteUser(id);
	}

	@Override
	/**
	 * 根据角色iD获取所有用户
	 */
	public List<User> getUserListByRoleId(Integer roleId) {
		return userlist = sqlSession.getMapper(UserMapper.class)
				.getUserListByRoleId(roleId);
	}

	@Override
	/**
	 * 根据用户ID查询相关具体地址信息
	 */
	public List<User> getAddressListByUserId(Integer userId) {
		return userlist = sqlSession.getMapper(UserMapper.class)
				.getAddressListByUserId(userId);
	}

	@Override
	/**
	 * 根据用户角色ID删除用户
	 * 
	 */
	public int delUserByRoleid(Integer roleId) {

		return count = sqlSession.getMapper(UserMapper.class).delUserByRoleid(
				roleId);
	}

	@Override
	/**
	 * 根据用户名称和密码查询用户
	 */
	public User getUser(User user) {

		return user = sqlSession.getMapper(UserMapper.class).getUser(user);
	}

	@Override
	public User getUserByid(int id) {
		return user = sqlSession.getMapper(UserMapper.class).getUserByid(id);
	}

	@Override
	/**
	 * 根据用户名查询是否存在该用户
	 */
	public User selectUserCodeExist(String userCode) {
		return user = sqlSession.getMapper(UserMapper.class)
				.selectUserCodeExist(userCode);
	}

	@Override
	/**
	 * 分页显示用户信息
	 */
	public List<User> getUselistP(String userName, Integer roleId,
			Integer currentPageNo, Integer pageSize) {

		return userlist = sqlSession.getMapper(UserMapper.class).getUselistP(
				userName, roleId, (currentPageNo - 1) * pageSize, pageSize);
	}

	/**
	 * 查询用户列表信息
	 */
	public List<User> getUserList(String userName, Integer roleId) {
		// TODO Auto-generated method stub
		return userlist = sqlSession.getMapper(UserMapper.class).getUserList(
				user);
	}

	@Override
	public List<User> getUserList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUsersWithConditions(User user) {
		try {
			return userMapper.getUserList(user);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}

	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public boolean addNewUser(User user) {
		boolean result = false;
		try {
			if (userMapper.add(user) == 1)
				result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return result;
	}
}
