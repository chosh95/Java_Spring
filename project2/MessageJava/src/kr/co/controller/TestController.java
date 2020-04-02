package kr.co.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@Autowired
	ReloadableResourceBundleMessageSource res;
	
	@GetMapping("/test1")
	public String test1(Model model, Locale locale) {
		
		String a1 = res.getMessage("aaa.a1", null, null);
		String b1 = res.getMessage("bbb.b1", null, null);
		
		//getMessage의 두번째 매개변수 설정
		// {}부분에 세팅할 값 배열
		Object[] args = {30,"홍길동"};
		String a2 = res.getMessage("aaa.a2", args, null);
		
		//getMessage 세번째 매개변수
		String a3 = res.getMessage("aaa.a3", null, locale);
		
		System.out.println(a1+b1);
		System.out.println(a2);
		System.out.println(a3);
		
		model.addAttribute("args",args);
		
		return "test1";
	}
}
