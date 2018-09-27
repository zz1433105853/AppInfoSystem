package cn.smbms.service.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.smbms.dao.bill.BillMapper;
import cn.smbms.pojo.Bill;
import cn.smbms.tools.MyBatisUtil;


public class BillMapperTest {
	Logger logger = Logger.getLogger("BillMapperTest") ;
	SqlSession sqlSession=null;
	List<Bill> billlist= new ArrayList<Bill>();
	@Test
	/**
	 * 模糊查询相关商品订单信息
	 */
	public void getBillByPid() {
		
		try{
			sqlSession=MyBatisUtil.createSqlSession();
			Bill bill=new Bill();		
			String productName="米";
			int ProviderId= 3;
			bill.setProductName("米");
			bill.setProviderId(3);
			billlist=sqlSession.getMapper(BillMapper.class).getBillList(bill);
		}catch( Exception e){
			e.printStackTrace();
		}finally{			
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		logger.debug("按照条件查询出来结果为"+billlist.size());
		for (Bill bill1 : billlist) {
			logger.debug("商品名称为"+bill1.getProductName()+"订单编码为"+bill1.getBillCode()
					+"供应商名称为"+bill1.getProviderName()+"账单金额为"+bill1.getTotalPrice()
					+"是否付款"+bill1.getIsPayment()+"创建时间为"+bill1.getCreationDate());
		}
	}

}
