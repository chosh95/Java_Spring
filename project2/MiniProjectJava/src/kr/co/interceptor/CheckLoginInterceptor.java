package kr.co.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.beans.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{

	private UserBean loginUserBean;
	
	public CheckLoginInterceptor(UserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//로그인 안 된경우 
		if(loginUserBean.isUserLogin()==false) { 
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/user/not_login");
			return false; //preHandle에서 false 반환하면 다음 단계로 건너가지 않고 여기서 끝나게 된다. 
		}
		return true;
	}
}
