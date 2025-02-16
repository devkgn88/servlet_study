package com.gn.board.service;

import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.commit;
import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.rollback;

import java.sql.Connection;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Attach;
import com.gn.board.vo.Board;

public class BoardService {
	public int createBoard(Board b, Attach a) {
		Connection conn = getConnection();
		int result = 0;
		conn.setAutoCommit(false);
		int boardNo = new BoardDao().createBoard(b,conn);
		a.setBoardNo(boardNo);
		int attachNo = new BoardDao().createAttach(a,conn);
		
		if(boardNo != 0 && attachNo != 0) {
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
