package cn.appsys.service.backendUser;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.backendUser.BackendUserMapper;
import cn.appsys.pojo.BackendUser;

@Service("backendUserService")
public class BackendUserServiceImpl implements BackendUserService {

	@Resource
	private BackendUserMapper backendUserMapper;
	
	@Override
	public BackendUser login(String userCode) {
		BackendUser backendUser = null;
		try {
			backendUser = backendUserMapper.login(userCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return backendUser;
	}
	
}
