package cn.smbms.service.user;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.smbms.dao.role.RoleMapper;
import cn.smbms.pojo.Role;
import cn.smbms.tools.MyBatisUtil;

public class RoleMapperTest {
	Logger logger= Logger.getLogger("ProviderServiceTset");
	SqlSession sqlSession=null;
	List<Role> rolelist=new ArrayList<Role>();
	@Test
	/**
	 * 增加一个用户
	 */
	public void addRole() {		
		int count=-1;
		try{
			sqlSession =MyBatisUtil.createSqlSession();
			Role  role= new Role();
			role.setRoleCode("SMBMS_Sum");
			role.setRoleName("执行CEO");
			role.setCreatedBy(1);
			role.setCreationDate(new Date());
			count = sqlSession.getMapper(RoleMapper.class).addRole(role);
			sqlSession.commit();
		}catch( Exception e){			
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		if(count >0){
			logger.info("增加成功");
		}
	
	}
	@Test
	/**
	 * 修改一个用户信息
	 */
	public void upRole() {		
		int count=-1;
		try{
			sqlSession =MyBatisUtil.createSqlSession();
//			count = sqlSession.getMapper(RoleMapper.class).upRole(5, "执行董事");
			sqlSession.commit();
		}catch( Exception e){			
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		if(count >0){
			logger.info("修改成功");
		}
	
	}
	
	/**
	 * 删除一个角色用户
	 */
	@Test
	public void delRole() {		
		int count=-1;
		try{
			Integer id= 6;
			sqlSession =MyBatisUtil.createSqlSession();
			rolelist=sqlSession.getMapper(RoleMapper.class).getRoleByUser(id);
			if(rolelist.size()>0){
				logger.info("对不起，用户角色存在用户");				
			}else {
				count = sqlSession.getMapper(RoleMapper.class).delRole(id);
				sqlSession.commit();
					if(count>0){
						logger.info("删除成功");	
					}else{
						logger.info("删除失败");	
					}
				
			}
		}catch( Exception e){			
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
	}
	@Test
	/**
	 * 模糊查询一个角色信息
	 */
	public void getRoleByName() {		
		int count=-1;
		try{
			sqlSession =MyBatisUtil.createSqlSession();
			Role  role= new Role();
			role.setRoleName("执行");
			role.setCreationDate(new Date());
			rolelist = sqlSession.getMapper(RoleMapper.class).getRoleByName(role);
			sqlSession.commit();
		}catch( Exception e){			
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		if(rolelist.size() >0){
			for(Role r:rolelist){
				logger.info("角色名称为"+r.getRoleName()+"角色编号为"+r.getRoleCode());
				
			}
		}
	
	}
	
	@Test
	/**
	 * 模糊查询一个角色信息分页显示
	 */
	public void getRolelistBypage() {		
		try{
			sqlSession =MyBatisUtil.createSqlSession();		
			 String RoleName="执行";		
			rolelist = sqlSession.getMapper(RoleMapper.class).getRolelistBypage(RoleName, 0, 2);
			sqlSession.commit();
		}catch( Exception e){			
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		logger.info("查询结果为多少条"+rolelist.size());
		if(rolelist.size() >0){
			for(Role r:rolelist){
				logger.info("角色名称为"+r.getRoleName()+"角色编号为"+r.getRoleCode());
				
			}
		}
	
	}
	
}
