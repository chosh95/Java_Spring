package kr.co.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.beans.DataBean1;

@Controller
@SessionAttributes({"sessionBean1", "sessionBean2"})
public class TestController {

	@ModelAttribute("sessionBean1")
	public DataBean1 sessionBean1() {
		return new DataBean1();
	}
	
	@ModelAttribute("sessionBean2")
	public DataBean1 sessionBean2() {
		return new DataBean1();
	}
	
	@GetMapping("/test1")
	//public String test1(HttpServletRequest request) { 이렇게 가능
	public String test1(HttpSession session) {
		//HttpSession session = request.getSession();
		session.setAttribute("data1", "string1");
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(HttpSession session) {
		session.setAttribute("data1", "string2");
		return "redirect:/result1";
	}
	
	@GetMapping("/test3")
	public String test3(HttpSession session) {
		session.setAttribute("data1", "string3");
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	//public String result1(HttpServletRequest request) { 이렇게도 가능
	public String result1(HttpSession session) {
		//HttpSession session = request.getSession();
		String data1 = (String)session.getAttribute("data1");
		System.out.println(data1);
		
		return "result1";
	}
	
	@GetMapping("/test4")
	//public String test4(@SessionAttribute("bean1") DataBean1 bean1) { 이렇게는 불가능하다. 
	//SessionAttribute는 객체를 새로 생성하는게 아니라 생성된 객체를 bean1이름으로 불러오는 것이다.
	public String test4(HttpSession session) { 
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("string4");
		bean1.setData2("string5");
		
		session.setAttribute("bean1", bean1);
		return "test4";
	}
	
	@GetMapping("/result4")
	//public String result4(HttpSession session) { 이렇게도 가능
	public String result4(@SessionAttribute("bean1") DataBean1 bean1) {	//생성된 객체를 받아오는거라 가능하다.
		//DataBean1 bean1 = (DataBean1)session.getAttribute("bean1");
		System.out.println(bean1.getData1() + " " + bean1.getData2());
		return "result4";
	}
	
	@GetMapping("/test5")
	public String test5(@ModelAttribute("sessionBean1") DataBean1 sessionBean1,
						@ModelAttribute("sessionBean2") DataBean1 sessionBean2) {
		
		sessionBean1.setData1("string6");
		sessionBean1.setData2("string7");
		
		sessionBean2.setData1("string8");
		sessionBean2.setData2("string9");
		
		return "test5";
	}
	
	@GetMapping("/result5")
	public String result5(@ModelAttribute("sessionBean1") DataBean1 sessionBean1,
						  @ModelAttribute("sessionBean2") DataBean1 sessionBean2) {
		
		System.out.println(sessionBean1.getData1() + " " + sessionBean1.getData2());
		
		System.out.println(sessionBean2.getData1() + " " + sessionBean2.getData2());

		return "result5";
	}
}
