package cn.smbms.service.provider.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.smbms.dao.provider.ProviderMapper;
import cn.smbms.pojo.Provider;
import cn.smbms.service.provider.ProviderService;
import cn.smbms.tools.MyBatisUtil;

@Service("providerService")
@Transactional
public class ProviderServiceImpl implements ProviderService {
	SqlSession sqlSession = MyBatisUtil.createSqlSession();
	List<Provider> providelist = new ArrayList<Provider>();
	Provider provide = new Provider();
	int count = -1;
	@Autowired
	private ProviderMapper providerMapper;

	@Override
	/**
	 * 获得所有供应商的总记录数
	 */
	public int count() {

		return count = sqlSession.getMapper(ProviderMapper.class).count();
	}

	@Override
	/**
	 * 获得所有的供应商信息
	 */
	public List<Provider> getAllPro() {

		return providelist = sqlSession.getMapper(ProviderMapper.class)
				.getAllPro();
	}

	@Override
	/**
	 * 增加一个供应商信息
	 */
	public int addpro(Provider provider) {
		// TODO Auto-generated method stub
		return count = sqlSession.getMapper(ProviderMapper.class).addpro(
				provider);
	}

	@Override
	/**
	 * 删除一个供应商信息
	 */
	public int delpro(Integer id) {

		return count = sqlSession.getMapper(ProviderMapper.class).delpro(id);
	}

	@Override
	/**
	 * 修改供应商信息
	 */
	public int uppro(Provider provider) {

		return count = sqlSession.getMapper(ProviderMapper.class).uppro(
				provider);
	}

	/**
	 * 根据供应商id查询供应商
	 */
	public Provider getProviderById(int id) {

		return provide = sqlSession.getMapper(ProviderMapper.class)
				.getProviderById(id);
	}

	@Override
	/**
	 * 根据供应商的名称和编码查询供应商
	 */
	public List<Provider> getProviderList(String proName, String proCode) {

		return providelist = sqlSession.getMapper(ProviderMapper.class)
				.getProviderList(proName, proCode);
	}

	@Override
	public boolean delNew(Integer id) {
		boolean result = false;
		try {
			if (providerMapper.delpro(id) == 1)
				result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
