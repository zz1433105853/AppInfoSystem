package cn.smbms.service.bill.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.smbms.dao.bill.BillMapper;
import cn.smbms.pojo.Bill;
import cn.smbms.service.bill.BillService;
import cn.smbms.tools.MyBatisUtil;

public class BillServiceImpl implements BillService {
	SqlSession sqlSession=MyBatisUtil.createSqlSession();
	List<Bill> billlist=new ArrayList<Bill> ();
	Bill bill =new Bill();
	int count =-1;
	@Override
	public List<Bill> getBillList(Bill bill) {
		
		return billlist=sqlSession.getMapper(BillMapper.class).getBillList(bill);
	}
	@Override
	/**
	 * 根据id获得订单详情
	 */
	public Bill getBillById(int id) {
		// TODO Auto-generated method stub
		return bill=sqlSession.getMapper(BillMapper.class).getBillById(id);
	}
	@Override
	/**
	 * 修改订单信息
	 */
	public int modify(Bill bill) {
		
		return count=sqlSession.getMapper(BillMapper.class).modify(bill);
	}
	@Override
	/**
	 * 删除订单信息
	 */
	public int deleteBillById(int id) {
		
		return count=sqlSession.getMapper(BillMapper.class).deleteBillById(id);
	}
	@Override
	/**
	 * 增加订单信息
	 */
	public int add(Bill bill) {
		
		return count=sqlSession.getMapper(BillMapper.class).add(bill);
	}

}
