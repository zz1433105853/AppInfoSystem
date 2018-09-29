package cn.appsys.service.AppVersion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppVersion.AppVersionMapper;
import cn.appsys.pojo.AppVersion;

@Service
public class AppVersionServiceImpl implements AppVersionService {

	@Resource
	private AppVersionMapper appVersionMapper;

	@Override
	public List<AppVersion> getAppVersionList() {
		List<AppVersion> appList = null;
		try {
			appList = appVersionMapper.getAppVersionList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appList;
	}

	@Override
	public List<AppVersion> getAppVersionById(Integer appId) {
		List<AppVersion> appList = null;
		try {
			appList = appVersionMapper.getAppVersionById(appId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appList;
	}

	@Override
	public int addAppVersion(AppVersion appVersion) {
		try {
			return appVersionMapper.addAppVersion(appVersion);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getAppVersionId() {
		try {
			return appVersionMapper.getAppVersionId();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public AppVersion appVersionInfo(Integer id) {
		try {
			return appVersionMapper.appVersionInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int modifyAppVersion(AppVersion appVersion) {
		try {
			return appVersionMapper.modifyAppVersion(appVersion);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteImage(AppVersion appVersion) {
		try {
			return appVersionMapper.deleteImage(appVersion);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteInfo(Integer appId) {
		try {
			return appVersionMapper.deleteInfo(appId);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
}
