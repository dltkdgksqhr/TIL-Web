package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SimpleUrlController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		return new ModelAndView("index.jsp"); //작업을 마친 후 뷰이름을 ModelAndView에 index.jsp로 설정하여 반환합니다.
	}

}
