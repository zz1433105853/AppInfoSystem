package cn.smbms.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	// 类加载时，自行进行初始化操作
	private static ConfigManager configManager = new ConfigManager();
	private static Properties properties;

	// 私有构造器，读取数据库配置文件
	private ConfigManager() {
		String configFile = "database.properties";
		properties = new Properties();
		InputStream is = ConfigManager.class.getClassLoader()
				.getResourceAsStream(configFile);
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 全局访问点
	// public static ConfigManager getInstance() {
	// if (configManager == null) {
	// configManager = new ConfigManager();
	// }
	// return configManager;
	// }
	// public static synchronized ConfigManager getInstance(){
	// if(configManager==null){
	// configManager = new ConfigManager();
	// }
	// return configManager;
	// }
	// 饿汉模式
	public static ConfigManager getInstance() {
		return configManager;
	}

	public String getValue(String key) {
		return properties.getProperty(key);
	}
}
