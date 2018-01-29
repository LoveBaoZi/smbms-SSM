package cn.smbms.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.smbms.Entity.Users;

/**
 * 拦截器
 * 
 * @author Administrator
 * 
 */
public class SysInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * 进行判断的方法
	 *  true   执行通过 
	 *  false  跳转指定的页面
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Users user = ((Users) session.getAttribute("userSession"));
		if (null == user) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return false;
		}
		return true;
	}
}
