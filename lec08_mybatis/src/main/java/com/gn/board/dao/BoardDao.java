package com.gn.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.board.vo.Board;

public class BoardDao {
	public List<Board> selectBoardList(SqlSession session){
		return session.selectList("boardMapper.selectBoardList");
	}
}
