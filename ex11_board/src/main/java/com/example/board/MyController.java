package com.example.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.dao.BoardDao;
import com.example.board.dto.BoardDto;

@Controller
public class MyController {
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping("/")
	//@ResponseBody
	public String root() {
		//return "root()함수 호출됨.";
		return "redirect:listForm"; //listForm으로 redirect 됨.
	}
	
	@RequestMapping("/listForm")
	public String listForm(Model model) {
		List<BoardDto> list = boardDao.list();
		model.addAttribute("list", list);
		
		System.out.println(list);
		
		return "listForm"; //"listForm.jsp" 디스패치해줌.
		
	}
}
