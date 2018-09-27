package cn.smbms.service.user;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;











import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.Address;
import cn.smbms.pojo.User;
import cn.smbms.tools.MyBatisUtil;

public class UserServiceTest {
	Logger logger = Logger.getLogger("UserMapperTest") ;
	SqlSession sqlSession=null;
	List<User> userlist= new ArrayList<User>();
		@Test
	public void testGetUserList(){
		
//		sqlSession =MyBatisUtil.createSqlSession();
//		userlist=sqlSession.getMapper(UserMapper.class).getUserList1();
//		MyBatisUtil.closeSqlSession(sqlSessio2n);
//		for(User user:userlist){
//			logger.debug("tsetgetuserlist usercode"+user.getUserCode()+"adn username"+user.getUserName());
//		}		
//		
//		sqlSession=MyBatisUtil.createSqlSession();
//		String userName="孙";
//		Integer roleID=null;
//		userlist=sqlSession.getMapper(UserMapper.class).getUserList(userName,roleID);
//		logger.info("查询的条数为"+userlist.size());
//		for(User user1:userlist){
//			logger.debug("tsetgetuserlist usercode \t"+user1.getUserCode()+"\t and username"+user1.getUserName()+
//					"and userRole"+user1.getUserRole()+"and ueseRoleName"+user1.getUserRoleName()+"and age"+user1.getAge()+
//					"and address"+user1.getAddress());
//		}		
//		MyBatisUtil.closeSqlSession(sqlSession);
//		
		
		sqlSession=MyBatisUtil.createSqlSession();
		String userName1="孙";
		Integer roleID1=null;
		userlist=sqlSession.getMapper(UserMapper.class).getUserList1(userName1,roleID1);
		logger.info("查询的条数为"+userlist.size());
		for(User user1:userlist){
			logger.debug("tsetgetuserlist usercode \t"+user1.getUserCode()+"\t and username"+user1.getUserName()+
					"and userRole"+user1.getUserRole()+"and ueseRoleName"+user1.getUserRoleName()+"and age"+user1.getAge()+
					"and address"+user1.getAddress());
		}		
		MyBatisUtil.closeSqlSession(sqlSession);
		
//		
//		sqlSession=MyBatisUtil.createSqlSession();
//		Map <String, String> userMap=new HashMap<String, String>();
//		userMap.put("uName", "赵");
//		userMap.put("uRole","2");			
//		userlist=sqlSession.getMapper(UserMapper.class).getUserListByMap(userMap);
//		for(User user1:userlist){
//			logger.debug("tsetgetuserlist usercode \t"+user1.getUserCode()+"\t adn username"+user1.getUserName());
//		}		
//		MyBatisUtil.closeSqlSession(sqlSession);
		
		
	}
	@Test
	/**
	 * 增加用户信息
	 */
	public void  testAdd(){
		 logger.debug("testAdd !=============");
		 int count=0;
		 try{
			 sqlSession=MyBatisUtil.createSqlSession();
			 User user=new User();
			 user.setUserCode("test001");
			 user.setUserName("测试用户001");
			 user.setUserPassword("1234667");
			 Date birthday= new SimpleDateFormat("yyyy-MM-dd").parse("1984-12-12");
			 user.setAddress("地址测试");
			 user.setBirthday(birthday);
			 user.setGender(1);
			 user.setPhone("13788786584");
			 user.setUserRole(1);
			 user.setCreatedBy(1);
			 user.setCreationDate(new Date());
			count=sqlSession.getMapper(UserMapper.class).add(user);
			//模拟异常，进行回滚
			//int i=2/0;
			sqlSession.commit();		
		 }catch(Exception e){
			 e.printStackTrace();
			 sqlSession.rollback();
			 count=0;
		 }finally{
			 
			 MyBatisUtil.closeSqlSession(sqlSession);
			 
		 }
		
		logger.debug("testadd count"+count);
	}
	@Test
	/**
	 * 修改用户信息
	 */
	public void  testModify(){
		 logger.debug("testModify !=============");
		 int count=0;
		 try{
			 sqlSession=MyBatisUtil.createSqlSession();
			 User user=new User();
			 user.setId(18); 
			 user.setUserCode("testmodify");
			 user.setUserName("测试新新修改");
			 user.setUserPassword("99999999");
//			 Date birthday= new SimpleDateFormat("yyyy-MM-dd").parse("1984-12-12");
//			 user.setAddress("地址测试修改");
//			 user.setBirthday(birthday);
//			 user.setGender(2);
//			 user.setPhone("13788786584");
//			 user.setUserRole(2);
//			 user.setModifyBy(2);
			 user.setModifyDate(new Date());
			count=sqlSession.getMapper(UserMapper.class).modify(user);
			//模拟异常，进行回滚
			//int i=2/0;
			sqlSession.commit();		
		 }catch(Exception e){
			 e.printStackTrace();
			 sqlSession.rollback();
			 count=0;
		 }finally{
			 
			 MyBatisUtil.closeSqlSession(sqlSession);
			 
		 }
		
		logger.debug("testmodify count"+count);
	}
	/**
	 * 更新用户密码
	 */
	@Test
	public void  testupPwd(){
		 logger.debug("testupPassword !=============");
		 int count=0;
		 String pwd="8888888";
		 Integer id=1;
		 try{
			 sqlSession=MyBatisUtil.createSqlSession();	
			count=sqlSession.getMapper(UserMapper.class).updatePwd(id, pwd);
			//模拟异常，进行回滚
			//int i=2/0;
			sqlSession.commit();		
		 }catch(Exception e){
			 e.printStackTrace();
			 sqlSession.rollback();
			 count=0;
		 }finally{
			 
			 MyBatisUtil.closeSqlSession(sqlSession);
			 
		 }
		
		logger.debug("testmodify count"+count);
	}
	/**
	 * 根据id删除用户
	 */
	@Test
	public void  testdeleUser(){
		 logger.debug("testdelteUser !=============");
		 int count=0;
		 Integer id=19;
		 try{
			 sqlSession=MyBatisUtil.createSqlSession();	
			count=sqlSession.getMapper(UserMapper.class).deleteUser(id);
			//模拟异常，进行回滚
			//int i=2/0;
			sqlSession.commit();		
		 }catch(Exception e){
			 e.printStackTrace();
			 sqlSession.rollback();
			 count=0;
		 }finally{
			 
			 MyBatisUtil.closeSqlSession(sqlSession);
			 
		 }
		
		logger.debug("testdeleUser count"+count);
	}
	
	@Test
	/**
	 * 查询用户角色具体信息
	 */
	public void  getUserListByRoleId(){
		 logger.debug("GETUser !=============");
		
		 Integer roleId=3;
		 try{
			 sqlSession=MyBatisUtil.createSqlSession();	
			 userlist=sqlSession.getMapper(UserMapper.class).getUserListByRoleId(roleId);
			 MyBatisUtil.closeSqlSession(sqlSession);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 logger.debug("userList======>userName"+userlist.size());
		 for(User user1:userlist){
			 logger.debug("testdeleUser userName="+user1.getUserName()
					 +",Role:"+user1.getRole().getId()
					 +"----"+user1.getRole().getRoleCode()
					 +"-----"+user1.getRole().getRoleName());
			}			
		
	}
	
	/**
	 * 根据用户ID查询相关的地址信息
	 */
	@Test
	public void  getAddressListByUserId(){
		 logger.debug("UserAddess!=============");		
		 Integer userId=3;
		 try{
			 sqlSession=MyBatisUtil.createSqlSession();	
			 userlist=sqlSession.getMapper(UserMapper.class).getAddressListByUserId(userId);
			 MyBatisUtil.closeSqlSession(sqlSession);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		
		 for(User user1:userlist){			
			 logger.debug("userlist(include addresslist) userCode="+user1.getUserCode()
					 +"userName"+user1.getUserName());
				for(Address address:user1.getAddressList())	{
					logger.debug("address----->id"+address.getId()
							+",contact"+address.getContact()
							+",addressDesc"+address.getAddressDesc()
							+",tel"+address.getTel()
							+",postCode"+address.getPostCode());				
				}
			}			
		
	}
	
	/**
	 * 根据用户ID查询相关的地址信息进行循环遍历查询
	 */
	@Test
	public void getUserByRoleId_foreach_array(){
		Integer [] roleIds ={2,3};
		try{
			 sqlSession=MyBatisUtil.createSqlSession();	
			 userlist=sqlSession.getMapper(UserMapper.class).getUserByRoleId_foreach_array(roleIds);
			 
		}catch(Exception e){
			 e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		logger.debug("userlist.size------->"+userlist.size());
		for(User user1:userlist){
			logger.debug("tsetgetuserlist usercode \t"+user1.getUserCode()+"\t and username"+user1.getUserName()+
					"and userRole"+user1.getUserRole()+"and ueseRoleName"+user1.getUserRoleName()+"and age"+user1.getAge()+
					"and address"+user1.getAddress());
		}		
		
	}
	
	/**
	 * 根据用户ID查询相关的地址信息进行循环遍历查询
	 */
	@Test
	public void getUserByRoleId_foreach_list(){
		List<Integer> roleList= new ArrayList<Integer>();
		roleList.add(2);
		roleList.add(3);
		try{
			 sqlSession=MyBatisUtil.createSqlSession();	
			 userlist=sqlSession.getMapper(UserMapper.class).getUserByRoleId_foreach_list(roleList);			 
		}catch(Exception e){
			 e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		logger.debug("userlist.size------->"+userlist.size());
		for(User user1:userlist){
			logger.debug("userId"+user1.getId()+"tsetgetuserlist usercode \t"+user1.getUserCode()
					+"\t and username"+user1.getUserName()
					+"and userRole"+user1.getUserRole());
		}		
		
	}
	
	
	/**
	 * 根据用户ID查询相关的地址信息进行循环遍历查询
	 */
	@Test
	public void getUserByRoleId_foreach_Map(){
		List<Integer> roleList= new ArrayList<Integer>();
		roleList.add(2);
		roleList.add(3);
		Map <String,Object> conditionMap= new HashMap<String,Object>();
		conditionMap.put("gender", 1);
		conditionMap.put("roleIds", roleList);
		try{
			 sqlSession=MyBatisUtil.createSqlSession();	
			 userlist=sqlSession.getMapper(UserMapper.class).getUserByRoleId_foreach_Map(conditionMap);			 
		}catch(Exception e){
			 e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		logger.debug("userlist.size------->"+userlist.size());
		for(User user1:userlist){
			logger.debug("userId"+user1.getId()+"tsetgetuserlist usercode \t"+user1.getUserCode()
					+"\t and username"+user1.getUserName()
					+"and userRole"+user1.getUserRole());
		}		
		
	}
	
	/**
	 * 根据用户ID查询相关的地址信息进行循环遍历查询
	 */
	@Test
	public void getUserByRoleId_foreach_Map1(){
		List<Integer> roleList= new ArrayList<Integer>();
		roleList.add(2);
		roleList.add(3);
		Map <String,Object> roleMap= new HashMap<String,Object>();
		roleMap.put("rKEY", roleList);
		try{
			 sqlSession=MyBatisUtil.createSqlSession();	
			 userlist=sqlSession.getMapper(UserMapper.class).getUserByRoleId_foreach_Map1(roleMap);			 
		}catch(Exception e){
			 e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		logger.debug("userlist.size------->"+userlist.size());
		for(User user1:userlist){
			logger.debug("userId"+user1.getId()+"tsetgetuserlist usercode \t"+user1.getUserCode()
					+"\t and username"+user1.getUserName()
					+"and userRole"+user1.getUserRole());
		}		
		
	}
	
	/**
	 * 测试查询列表功能
	 */
	@Test
	public void getUselist_choose(){
		String  userName="";
		Integer roleId=null;
		String userCode="";
		try {
			Date creationDate= new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-01");
			 sqlSession=MyBatisUtil.createSqlSession();	
			 userlist=sqlSession.getMapper(UserMapper.class).getUselist_choose(userName, roleId, userCode, creationDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("userlist.size测试------->"+userlist.size());
		for(User user1:userlist){
			logger.debug("userId"+user1.getId()+"tsetgetuserlist usercode \t"+user1.getUserCode()
					+"\t and username"+user1.getUserName()
					+"and userRole"+user1.getUserRole());
		}		
	}
	
	/**
	 * 测试查询列表分页功能
	 */
	@Test
	public void getUselistP(){
		
		try{
			 sqlSession=MyBatisUtil.createSqlSession();	
				String  userName="";
				Integer roleId=null;
				Integer pageSize =8;
				Integer currentPageNo=0;
			 userlist=sqlSession.getMapper(UserMapper.class).getUselistP(userName, roleId, currentPageNo, pageSize);			 
		}catch(Exception e){
			 e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		logger.debug("userlist.size------->"+userlist.size());
		for(User user1:userlist){
			logger.debug("用户ID"+user1.getId()+
					"用户编号 \t"+user1.getUserCode()
					+" 用户名称"+user1.getUserName()
					+"用户角色"+user1.getUserRole()
					+" 年龄"+user1.getAge()
					+"电话"+user1.getPhone()
					+"性别"+user1.getGender()
					+"创建时间"+user1.getCreationDate());
		}		
	}
}
