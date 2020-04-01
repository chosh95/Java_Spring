package kr.co.controller;

import java.util.ArrayList;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.beans.DataBean;
import kr.co.beans.KeyValueBean;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(DataBean bean, Model model) {
		bean.setA1("data2");
		bean.setA2("data2");
		bean.setA3("data2");
		bean.setA4("data2");
		
		String[] check_list = {"data1", "data3"};
		bean.setA5(check_list);
		bean.setA6(check_list);
		bean.setA7(check_list);
		bean.setA8(check_list);
		
		bean.setA9("data2");
		bean.setA10("data2");
		bean.setA11("data2");
		bean.setA12("data2");
		
		String[] data_list1 = {"data1", "data2", "data3"};
		model.addAttribute("data_list1", data_list1);
		
		ArrayList<String> data_list2 = new ArrayList<String>();
		data_list2.add("data1");
		data_list2.add("data2");
		data_list2.add("data3");
		model.addAttribute("data_list2", data_list2);
		
		KeyValueBean key_bean1 = new KeyValueBean();
		KeyValueBean key_bean2 = new KeyValueBean();
		KeyValueBean key_bean3 = new KeyValueBean();
		
		key_bean1.setKey("key1");
		key_bean1.setValue("value1");
		key_bean2.setKey("key2");
		key_bean2.setValue("value2");
		key_bean3.setKey("key3");
		key_bean3.setValue("value3");
		
		ArrayList<KeyValueBean> data_list3 = new ArrayList<KeyValueBean>();
		data_list3.add(key_bean1);
		data_list3.add(key_bean2);
		data_list3.add(key_bean3);
		
		model.addAttribute("data_list3", data_list3);
		return "test1";
	}
}
