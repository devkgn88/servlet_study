package com.gn.board.service;

import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.commit;
import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Attach;
import com.gn.board.vo.Board;

public class BoardService {
	
	public List<Board> selectBoardList(Board option){
		Connection conn = getConnection();
		List<Board> list = new ArrayList<Board>();
		list = new BoardDao().selectBoardList(conn,option);
		return list;
	}
	
	public int createBoard(Board b, Attach a) {
		Connection conn = getConnection();
		int result = 0;
		try {
			conn.setAutoCommit(false);
			int boardNo = new BoardDao().createBoard(b,conn);
			a.setBoardNo(boardNo);
			int attachNo = new BoardDao().createAttach(a,conn);
			
			if(boardNo != 0 && attachNo != 0) {
				result = 1;
				commit(conn);
			} else {
				rollback(conn);
			}
			
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		}
		close(conn);
		return result;
	}
}
