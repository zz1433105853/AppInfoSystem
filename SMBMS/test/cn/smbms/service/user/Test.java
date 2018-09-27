package cn.smbms.service.user;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.smbms.service.provider.ProviderService;

public class Test {
	static Logger logger = Logger.getLogger("UserMapperTest");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProviderService userservce = (ProviderService) ctx
				.getBean("providerService");
		// User userCondition = new User();
		// userCondition.setUserName("赵");
		// userCondition.setUserRole(3);
		// List<User> userList = new ArrayList<User>();
		// userList = userservce.findUsersWithConditions(userCondition);
		// for (User userResult : userList) {
		// logger.debug("testGetUserList userCode:" + userResult.getUserCode()
		// + "and userName:" + userResult.getUserName()
		// + "and userRole:" + userResult.getUserRole()
		// + "and userRoleName:" + userResult.getUserRoleName()
		// + "and address:" + userResult.getAddress());
		//
		// }

		boolean result = userservce.delNew(1);
		logger.debug("testAdd result:" + result);
	}

}
