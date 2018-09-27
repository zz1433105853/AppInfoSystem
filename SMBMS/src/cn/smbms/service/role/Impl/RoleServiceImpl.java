package cn.smbms.service.role.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.smbms.dao.role.RoleMapper;
import cn.smbms.pojo.Role;
import cn.smbms.service.role.RoleService;
import cn.smbms.tools.MyBatisUtil;

public class RoleServiceImpl implements RoleService {
	SqlSession sqlSession=MyBatisUtil.createSqlSession();
	List<Role> rolelist=new ArrayList<Role>();
	Role role=new Role();
	
	/**
	 * 获取所有的用户角色信息
	 */
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return rolelist=sqlSession.getMapper(RoleMapper.class).getRoleList();
	}

}
