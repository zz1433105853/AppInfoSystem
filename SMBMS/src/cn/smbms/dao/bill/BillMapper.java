package cn.smbms.dao.bill;

import java.util.List;

import cn.smbms.pojo.Bill;

public interface BillMapper {
	//创建订单mapper接口类
	/**
	 * 根据订单对象获取订单详情
	 * @param bill
	 * @return
	 */
	public List<Bill> getBillList( Bill bill);
	/**
	 * 根据ID获得订单
	 */
	public Bill getBillById(int id);
	
	/**
	 * 修改订单
	 */
	public int modify(Bill bill);
	
	/**
	 * 删除订单
	 */
	public int deleteBillById(int id);
	/**
	 * 增加订单
	 */
	public int add(Bill bill);
}
