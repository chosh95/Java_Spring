package kr.co.config;

import org.springframework.context.annotation.Bean;

//프로젝트 작업 시 사용할 bean을 정의하는 클래스

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import kr.co.beans.DataBean1;
import kr.co.beans.DataBean2;

@Configuration
public class RootAppContext {

	@Bean
	@ApplicationScope
	public DataBean1 applicationBean1() {
		return new DataBean1();
	}
	
	@Bean("applicationBean2")
	@ApplicationScope
	public DataBean2 applicationBean2(){
		return new DataBean2();
	}
}
