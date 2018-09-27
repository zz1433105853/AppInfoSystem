package cn.smbms.service.user;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.smbms.dao.provider.ProviderMapper;
import cn.smbms.pojo.Provider;
import cn.smbms.tools.MyBatisUtil;

public class ProviderServiceTset {
	Logger logger= Logger.getLogger("ProviderServiceTset");
	SqlSession sqlSession=null;
	List <Provider> list= new ArrayList<Provider>();
	@Test
	public void test() {
		sqlSession =MyBatisUtil.createSqlSession();
		int count=0;
		try{
		count =sqlSession.getMapper(ProviderMapper.class).count();
		logger.debug("总记录数为"+count);
		}catch (Exception e){
			 e.printStackTrace();		
		}finally{			
			MyBatisUtil.closeSqlSession(sqlSession);
		}
	}
	@Test
	/**
	 * 所有供应商的具体信息
	 */
	public void getall() {
		sqlSession =MyBatisUtil.createSqlSession();
		try{
		list =sqlSession.getMapper(ProviderMapper.class).getAllPro();
		logger.debug("总记录数为"+list.size());
		}catch (Exception e){
			 e.printStackTrace();		
		}finally{			
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for(Provider  pro:list){
			logger.debug("供应商编号："+pro.getId()+"供应商名称："+pro.getProName()+"供应商电话"+pro.getProPhone()
					+"供应商地址"+pro.getProAddress()+"供应商信息"+pro.getProDesc());
			
		}
	}
	@Test
	public void addpro() {
		sqlSession =MyBatisUtil.createSqlSession();
		int count=0;
		Provider provider= new Provider();
		provider.setProCode("GX-898990");
		provider.setProName("北大青鸟太原校区");
		provider.setProDesc("长期合作伙伴");
		provider.setProContact("李三");
		provider.setProPhone("1520348768716");
		provider.setProFax("0359-2201100");
		provider.setProAddress("运城市红旗东街");
		provider.setCreatedBy(1);
		provider.setCreationDate(new Date());
		try{
		count =sqlSession.getMapper(ProviderMapper.class).addpro(provider);
		sqlSession.commit();
		logger.debug("总记录数为"+count);
		}catch (Exception e){
			 e.printStackTrace();		
		}finally{			
			MyBatisUtil.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	/**
	 * 删除供应商信息
	 */
	public void delpro() {
		sqlSession =MyBatisUtil.createSqlSession();
		Integer id=20;
		int count =0;
		try{
		count =sqlSession.getMapper(ProviderMapper.class).delpro(id);
		sqlSession.commit();
		logger.debug("总记录数为"+count);
		}catch (Exception e){
			 e.printStackTrace();		
		}finally{			
			MyBatisUtil.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	/**F
	 * 修改供应商信息
	 */
	public void uppro() {
		sqlSession =MyBatisUtil.createSqlSession();
		Integer id=18;
		String proname="北京大学历史系";
		int count =0;
		try{
//		count =sqlSession.getMapper(ProviderMapper.class).uppro(proname, id);
		sqlSession.commit();
		logger.debug("总记录数为"+count);
		}catch (Exception e){
			 e.printStackTrace();		
		}finally{			
			MyBatisUtil.closeSqlSession(sqlSession);
		}
	}
}
