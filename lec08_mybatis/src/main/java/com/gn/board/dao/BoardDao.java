package com.gn.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.gn.board.vo.Board;

public class BoardDao {
	
	public int insertBoard(SqlSession session, Board b) {
		return session.insert("boardMapper.insertBoard",b);
	}
	
	public int deleteBoard(SqlSession session, int boardNo) {
		return session.delete("boardMapper.deleteBoard",boardNo);
	}
	
	public int updateBoard(SqlSession session, Board board) {
		return session.update("boardMapper.updateBoard",board);
	}
	
	public Board selectBoardObj(SqlSession session, Board option) {
		return session.selectOne("boardMapper.selectBoardObj",option);
	}
	
	public Board selectBoardTwo(SqlSession session,Map<String,String> map) {
		return session.selectOne("boardMapper.selectBoardTwo",map);
	}
	
	public Board selectBoardOne(SqlSession session,int boardNo) {
		return session.selectOne("boardMapper.selectBoardOne",boardNo);
	}
	
	public List<Board> selectBoardList(SqlSession session,Board option ){
		return session.selectList("boardMapper.selectBoardList",option);
	}
}
