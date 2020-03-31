package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value="/test1",method=RequestMethod.GET)
	public String test1() {
		return "test1";
	}
	
	@RequestMapping(value="/test20",method=RequestMethod.GET)
	public String test2() {
		return "test2";
	}

}
