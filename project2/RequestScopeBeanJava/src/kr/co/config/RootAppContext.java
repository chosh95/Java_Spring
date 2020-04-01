package kr.co.config;

import org.springframework.context.annotation.Bean;

//프로젝트 작업 시 사용할 bean을 정의하는 클래스

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.beans.DataBean;
import kr.co.beans.DataBean2;

@Configuration
public class RootAppContext {

	@Bean
	@RequestScope
	public DataBean dataBean() {
		return new DataBean();
	}
	
	@Bean("requestBean2")
	@RequestScope
	public DataBean2 dataBean2() {
		return new DataBean2();
	}
}
