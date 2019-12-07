package com.sc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("3、所有完成后执行");

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("2、业务方法之后执行");

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("1、业务方法之前执行");
		
		HttpSession session = arg0.getSession();
		
		Object object = session.getAttribute("nowuser");
		
		if(object!=null){
			System.out.println("用户已登录！进入控制器方法！");
			return true;
		}
		
		System.out.println("用户未登录！重定向到登录页面！");
		String path = arg0.getContextPath();
		String basePath = arg0.getScheme()+"://"+arg0.getServerName()+":"+arg0.getServerPort()+path+"/";
		arg1.sendRedirect(basePath+"login.jsp?islogin=no");//绝对路径
		return false;
	}

}
