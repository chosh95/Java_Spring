package kr.co.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.beans.DataBean1;

@Controller
public class TestController {

	@GetMapping("/input_data")
	public String input_data() {
		
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {
		System.out.println(dataBean1.getData1() + " " + dataBean1.getData2());

		System.out.println(result);
		
		//유효성 검사에서 에러가 있을 시
		if(result.hasErrors()) {
			//유효성 위반 결과를 모두 가져온다.
			for(ObjectError obj : result.getAllErrors()) {
				System.out.println(obj.getDefaultMessage());
				System.out.println(obj.getCode());
				System.out.println(obj.getObjectName());
				
				String[] codes = obj.getCodes();
				for(String c1 : codes)
					System.out.println(c1);
				
				if(codes[0].equals("Size.dataBean1.data1")) {
					System.out.println("data1은 2~10글자를 담을 수 있다.");
				}
				else if(codes[0].equals("Max.dataBean1.data2")) {
					System.out.println("data2는 최대 100까지의 값만 가질 수 있다.");
				}
				System.out.println("----------------------------");
			}
			
			//위반했을시 다시 입력하도록.
			return "input_data";
		}
		
		return "input_success";
	}
}
