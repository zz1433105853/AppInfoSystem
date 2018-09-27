package cn.smbms.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	private Logger logger = Logger.getLogger("UserController");
	private ArrayList<User> userList = new ArrayList<User>();

	public UserController() {
		try {
			userList.add(new User(1, "test001", "测试用户001", "1111111", 1,
					new SimpleDateFormat("yyyy-MM-dd").parse("1986-12-10"),
					"13566669998", "北京市朝阳区北苑", 1, 1, new Date(), 1, new Date()));
			userList.add(new User(2, "zhaoyan", "赵燕", "2222222", 1,
					new SimpleDateFormat("yyyy-MM-dd").parse("1984-11-10"),
					"18678786545", "北京市海淀区成府路", 1, 1, new Date(), 1, new Date()));
			userList.add(new User(3, "test003", "测试用户003", "3333333", 1,
					new SimpleDateFormat("yyyy-MM-dd").parse("1980-11-10"),
					"18678786545", "北京市海淀区成府路", 1, 1, new Date(), 1, new Date()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		logger.info("无查询条件下，获取userList(公共查询)====userLsit");
		model.addAttribute("queryUserList", userList);
		return "user/userList";

	}

	private ArrayList<User> queryUserList = new ArrayList<User>();

	// 增加查询条件:userName
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String list(
			@RequestParam(value = "userName", required = false) String userName,
			Model model) {
		logger.info("查询条件：userName:" + userName + ",获取userList====");
		if (userName != null && !userName.equals("")) {
			for (User user : userList) {
				if (user.getUserName().indexOf(userName) != -1) {
					queryUserList.add(user);
				}
			}
			model.addAttribute("queryUserList", queryUserList);
		} else {
			model.addAttribute("queryUserLsit", userList);
		}

		return "user/userList";
	}
}
