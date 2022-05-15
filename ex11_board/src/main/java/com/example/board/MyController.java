package com.example.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/writeForm")
	public String writeFrom() {
		return "writeForm"; //writeForm.jsp를 디스패치해줌
		
	}
	
	@RequestMapping("/writeAction")
	public String writeAction(@RequestParam("board_name") String board_name, 
							  @RequestParam("board_title") String board_title,
							  @RequestParam("board_content") String board_content) {
		int result= boardDao.write(board_name, board_title, board_content);
		
		if(result == 1) {
			System.out.println("글쓰기 성공!");
		} else {
			System.out.println("글쓰기 실패!");
		}
		return "redirect:listForm"; //listForm으로 redirect 됨.
	}
	
}
