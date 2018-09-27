package cn.smbms.dao.provider;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Provider;

public interface ProviderMapper {
	//创建供应商的mapper接口
	/**
	 * 统计供应商的条数
	 * @return
	 */
	public int count();
	/**
	 * 获取所有的供应商信息
	 */
	public List<Provider> getAllPro();
	/**
	 * 增加供应商信息
	 */
	public int addpro(Provider provider);
	/**
	 * 删除供应商信息
	 */
	public int delpro(Integer id);
	/**
	 * 修改供应商信息
	 */
	public int uppro(Provider provider);
	/**
	 * 通过id查找供应商  
	 */
	public Provider getProviderById(int id);
	/**
	 * 通过供应商编码和名称查询供应商
	 */
	public List<Provider> getProviderList(@Param("proName")String proName,@Param("proCode") String proCode);
}
