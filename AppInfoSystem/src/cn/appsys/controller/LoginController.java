package cn.appsys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.backendUser.BackendUserService;
import cn.appsys.service.devUser.DevUserService;
import cn.appsys.tools.Constants;

@RequestMapping("/login")
@Controller
public class LoginController {

	@Resource
	private BackendUserService backendUserService;

	@Resource
	private DevUserService devUserService;

	/**
	 * 前台登录
	 * 
	 */
	// 跳转
	@RequestMapping("/dev/login")
	public String devLogin() {
		return "devlogin";
	}

	// 登录
	@RequestMapping("/dev/dologin")
	public String devDoLogin(@RequestParam String devCode,
			@RequestParam String devPassword, HttpSession session) {
		DevUser devUser = devUserService.login(devCode);
		if (devUser == null) {
			session.setAttribute("error", "用户名输入错误");
		} else if (devUser.getDevPassword().equals(devPassword)) {
			session.setAttribute(Constants.DEV_USER_SESSION, devUser);

		} else {
			session.setAttribute("error", "密码输入错误");
		}
		return "/developer/main";
	}

	// 注销
	@RequestMapping("/dev/logout")
	public String devLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/dev/login";
	}

	/**
	 * 
	 * 后台登录
	 */
	@RequestMapping("/manager/login")
	public String managerLogin() {
		return "backendlogin";
	}

	/**
	 * 登录
	 * 
	 * @param userCode
	 * @param userPassword
	 * @param session
	 * @return
	 */
	@RequestMapping("/manager/dologin")
	public String ManagerDoLogin(String userCode, String userPassword,
			HttpSession session) {
		BackendUser backendUser = backendUserService.login(userCode);
		if (backendUser == null) {
			session.setAttribute("error", "用户名输入错误");
		} else if (backendUser.getUserPassword().equals(userPassword)) {
			session.setAttribute(Constants.USER_SESSION, backendUser);

		} else {
			session.setAttribute("error", "密码输入错误");
		}
		return "/backend/main";
	}

	@RequestMapping("/manager/logout")
	public String managerLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/manager/login";
	}
}