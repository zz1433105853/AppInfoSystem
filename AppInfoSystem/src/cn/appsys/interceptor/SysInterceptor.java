package cn.appsys.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SysInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = Logger.getLogger(SysInterceptor.class);

	// public boolean preHandle(HttpServletRequest request,HttpServletResponse
	// response,
	// Object Handlet) throws Exception {
	// logger.debug("SysInterceptor preHandle!");
	// HttpSession session = request.getSession();
	// DevUser devUser =
	// (DevUser)session.getAttribute(Constants.DEV_USER_SESSION);
	// if(null == devUser){
	// response.sendRedirect(request.getContextPath()+"/403.jsp");
	// return false;
	// }
	// return true;
	// }
}
