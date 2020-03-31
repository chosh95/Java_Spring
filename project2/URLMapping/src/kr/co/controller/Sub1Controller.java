package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Sub1Controller {
	
	@RequestMapping(value="sub1/test3",method=RequestMethod.GET)
	public String sub1Test3() {
		return "sub1/test3";
	}
	
	@RequestMapping(value="sub1/test4",method=RequestMethod.GET)
	public String sub1Test4() {
		return "sub1/test4";
	}

}
