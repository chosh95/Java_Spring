package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
	
	@GetMapping("/test1")
	public String test1() {
		
		return "test1";
	}
}
