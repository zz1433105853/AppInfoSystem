package cn.appsys.service.AppInfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppInfo.AppInfoMapper;
import cn.appsys.pojo.AppInfo;
import cn.appsys.tools.PageSupport;

@Service
public class AppInfoServiceImpl implements AppInfoService{

	@Resource
	private AppInfoMapper appInfoMapper;

	@Override
	public List<AppInfo> getAppInfoByParam(String softwareName, Integer status, Integer flatformId,
			Integer currentPageNo, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3,
			Integer pageSize) {
		List<AppInfo> appList = null;
		try {
			appList = appInfoMapper.getAppInfoByParam(softwareName, status, flatformId, currentPageNo, categoryLevel1, categoryLevel2, categoryLevel3, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appList;
	}

	@Override
	public int getAppInfoCount(String softwareName,Integer status,
			Integer flatformId,Integer categoryLevel1,
			Integer categoryLevel2,Integer categoryLevel3) {
		try {
			return appInfoMapper.getAppInfoCount(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public AppInfo getAppInfoByApk(String APKName) {
		try {
			return appInfoMapper.getAppInfoByApk(APKName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int addAppInfo(AppInfo appInfo) {
		try {
			return appInfoMapper.addAppInfo(appInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public AppInfo getAppInfoById(Integer id) {
		try {
			return appInfoMapper.getAppInfoById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int modify(AppInfo appInfo) {
		try {
			return appInfoMapper.modify(appInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int modifyLogo(Integer id) {
		try {
			return appInfoMapper.modifyLogo(id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int modifyVersionId(Integer versionId, Integer id) {
		try {
			return appInfoMapper.modifyVersionId(versionId, id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public AppInfo getAppInfoByIdInfo(Integer id) {
		try {
			return appInfoMapper.getAppInfoByIdInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int deleteApp(Integer id) {
		try {
			return appInfoMapper.deleteApp(id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	
	
}
