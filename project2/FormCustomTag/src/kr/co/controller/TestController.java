package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.beans.UserDataBean;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(UserDataBean bean) {
		bean.setUser_name("홍홍");
		bean.setUser_id("abcd");
		bean.setUser_pw("1234");
		bean.setUser_postcode("12345");
		bean.setUser_address1("1번 주소");
		bean.setUser_address2("2번 주소");
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(UserDataBean bean) {
		bean.setUser_name("홍홍");
		bean.setUser_id("abcd");
		bean.setUser_pw("1234");
		bean.setUser_postcode("12345");
		bean.setUser_address1("1번 주소");
		bean.setUser_address2("2번 주소");
		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(@ModelAttribute("testBean") UserDataBean bean) {
		bean.setUser_name("홍홍");
		bean.setUser_id("abcd");
		bean.setUser_pw("1234");
		bean.setUser_postcode("12345");
		bean.setUser_address1("1번 주소");
		bean.setUser_address2("2번 주소");
		
		return "test3";
	}
	
	@GetMapping("/test4")
	public String test4(Model model) {
		UserDataBean bean = new UserDataBean();
		bean.setUser_name("홍홍");
		bean.setUser_id("abcd");
		bean.setUser_pw("1234");
		bean.setUser_postcode("12345");
		bean.setUser_address1("1번 주소");
		bean.setUser_address2("2번 주소");
		
		model.addAttribute("test_user2",bean);
		
		return "test4";
	}
}
