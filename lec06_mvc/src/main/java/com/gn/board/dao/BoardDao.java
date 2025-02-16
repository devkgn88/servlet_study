package com.gn.board.dao;

import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gn.board.vo.Board;

public class BoardDao {
	public int createBoard(Board b, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0; 
		try {
			String sql = "INSERT INTO `board`(board_title,board_content,board_writer) "
					+ "VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setInt(3,b.getBoardWriter());
			result = pstmt.executeUpdate();
			
			// 쿼리 실행 후 생성된 키 반환
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				result = rs.getInt("board_no");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
}
