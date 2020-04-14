package kr.co.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.beans.BoardInfoBean;
import kr.co.beans.UserBean;
import kr.co.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{

	private TopMenuService topMenuService;
	private UserBean loginUserBean;
	
	public TopMenuInterceptor(TopMenuService topMenuService, UserBean loginUserBean) {
			this.topMenuService = topMenuService;
			this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		request.setAttribute("loginUserBean", loginUserBean);

		return true;
	}
}
