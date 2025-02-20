package com.gn.board.service;

import static com.gn.common.sql.SessionTemplate.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Board;


public class BoardService {
	
	public int insertBoard(Board b) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().insertBoard(session,b);
		session.close();
		return result;
	}
	
	public int deleteBoard(int boardNo) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().deleteBoard(session,boardNo);
		session.close();
		return result;
	}
	
	public int updateBoard(Board b) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().updateBoard(session,b);
		session.close();
		return result;
	}
	
	public List<Board> selectBoardList(Board option){
		SqlSession session = getSqlSession();
		List<Board> resultList = new BoardDao().selectBoardList(session,option);
		session.close();
		return resultList;
	}
	
	public Board selectBoardOne(int boardNo) {
		SqlSession session = getSqlSession();
		Board board = new BoardDao().selectBoardOne(session,boardNo);
		session.close();
		return board;
	}
	
	public Board selectBoardTwo(Map<String,String> paramMap) {
		SqlSession session = getSqlSession();
		Board board = new BoardDao().selectBoardTwo(session,paramMap);
		session.close();
		return board;
	}
	
	public Board selectBoardObj(Board option) {
		SqlSession session = getSqlSession();
		Board board = new BoardDao().selectBoardObj(session,option);
		session.close();
		return board;
	}
}