package kr.co.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {

		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");

		System.out.println(data1 + " " + data2);

		for (String str1 : data3)
			System.out.println("data3 : " + str1);

		return "result";
	}

	@PostMapping("/test2")
	public String test2(HttpServletRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");

		System.out.println(data1 + " " + data2);

		if (data3 != null)
			for (String str1 : data3)
				System.out.println("data3 : " + str1);

		return "result";
	}

	@GetMapping("/test4/{data1}/{data2}/{data3}")
	public String test4(@PathVariable String data1, @PathVariable String data2, @PathVariable String data3) {
		System.out.println(data1 + " " + data2 + " " + data3);

		return "result";
	}

	@GetMapping("/test5")
	public String test5(@RequestParam int data1, @RequestParam int data2, @RequestParam int[] data3) {
		System.out.println(data1 + " " + data2);
		for (int i : data3)
			System.out.println(i);
		return "result";
	}

	@GetMapping("/test6")
	public String test6(@RequestParam(value = "data1") int val1, 
						@RequestParam(value = "data2") int val2,
						@RequestParam(value = "data3") int[] val3) {

		System.out.println(val1 + " " + val2);
		for (int i : val3)
			System.out.println(i);

		return "result";
	}
}
