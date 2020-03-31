package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.beans.DataBean;

@Controller
public class TestController {
	
	@PostMapping("/test1")
	public String test1(@ModelAttribute DataBean bean) {
		System.out.println(bean.getData1() + " " + bean.getData2());	
		return "test1";
	}
	
	@PostMapping("/test2")
	public String test2(@ModelAttribute("testData") DataBean bean) {		
		return "test2";
	}
}
