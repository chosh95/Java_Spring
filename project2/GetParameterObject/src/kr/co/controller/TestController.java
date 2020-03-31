package kr.co.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.beans.DataBean;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(@RequestParam Map<String,String> map, @RequestParam List<String> data3) {
		String data1 = map.get("data1");
		String data2 = map.get("data2");
	
		System.out.println(data1 + " " + data2);
		
		System.out.println(data3);
		
		return "result";
	}
	
	@GetMapping("/test2")
	public String test2(@ModelAttribute DataBean bean) {
		
		System.out.println(bean.getData1() + " " + bean.getData2());
		for(int num : bean.getData3())
			System.out.println(num);

		return "result";
	}
}
