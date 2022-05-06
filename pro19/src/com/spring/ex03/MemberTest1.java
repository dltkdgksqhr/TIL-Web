package com.spring.ex03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MemberTest1 {

	public static void main(String[] args) {
	 BeanFactory factory = new XmlBeanFactory(new FileSystemResource("member.xml")); // 실행시 member.xml에 설정한대로 빈을 생성한 후 주입합니다.
	 MemberService service = (MemberService) factory.getBean("memberService"); // id가 memberService인 빈을 가져옵니다.
	 service.listMembers();
	}

}
