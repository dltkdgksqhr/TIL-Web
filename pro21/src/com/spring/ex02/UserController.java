package com.spring.ex02;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController { // 설정 파일의 userMethodNameResolver 프로퍼티를 사용하려면 반드시 MultiActionController를 상속받아야한다.
 public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
	String userID=""; 
	String passwd=""; 
	ModelAndView mav = new ModelAndView();
	request.setCharacterEncoding("utf-8");
	userID = request.getParameter("userID");
	passwd = request.getParameter("passwd");
	
	mav.addObject("userID",userID); //ModelAndView에 로그인 정보를 바인딩합니다
	mav.addObject("passwd", passwd);
	mav.setViewName("result"); //ModelAndView 객체에 포워딩할 JSP 이름을 설정합니다.
	return mav;
 }
}
