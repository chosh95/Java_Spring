package kr.co.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.beans.DataBean;
import kr.co.beans.DataBean2;
import kr.co.beans.DataBean3;
import kr.co.beans.DataBean4;

@Controller
public class TestController {

	@Autowired
	DataBean requestBean;
	
	@Resource(name = "requestBean2")
	DataBean2 requestBean2;
	
	@Autowired
	DataBean3 requestBean3;
	
	@Resource(name="requestBean4")
	DataBean4 requestBean4;
	
	@GetMapping("/test1")
	public String test1() {
		
		requestBean.setData1("string1");
		requestBean.setData2("string2");
		
		requestBean2.setData3("string3");
		requestBean2.setData4("string4");
		
		requestBean3.setData5("string5");
		requestBean3.setData6("string6");
		
		requestBean4.setData7("string7");
		requestBean4.setData8("string8");
		
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		System.out.println(requestBean.getData1());
		System.out.println(requestBean.getData2());
		
		System.out.println(requestBean2.getData3());
		System.out.println(requestBean2.getData4());
		
		System.out.println(requestBean3.getData5());
		System.out.println(requestBean3.getData6());
		
		System.out.println(requestBean4.getData7());
		System.out.println(requestBean4.getData8());
		
		model.addAttribute("requestBean",requestBean);
		model.addAttribute("requestBean2",requestBean2);
		model.addAttribute("requestBean3",requestBean3);
		model.addAttribute("requestBean4",requestBean4);
		
		return "result1";
	}

}
