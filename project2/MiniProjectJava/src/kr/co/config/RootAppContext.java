package kr.co.config;

import org.springframework.context.annotation.Bean;

//프로젝트 작업 시 사용할 bean을 정의하는 클래스

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.beans.UserBean;

@Configuration
public class RootAppContext {

	@Bean("loginUserBean")
	@SessionScope
	public UserBean loginUserBean() {
		return new UserBean();
	}
}
