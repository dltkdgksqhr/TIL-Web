package com.example.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.dto.BoardDto;

@Mapper //mybatis와 인터페이스 함수를 연결함.
public interface BoardDao {

	public List<BoardDto> list();
	
}
