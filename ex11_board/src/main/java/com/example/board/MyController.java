package com.example.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/")
	//@ResponseBody
	public String root() {
		//return "root()함수 호출됨.";
		return "redirect:listForm"; //listForm으로 redirect 됨.
	}
	
	@RequestMapping("/listForm")
	public String listForm() {
		return "listForm"; //"listForm.jsp" 디스패치해줌.
		
	}
}
