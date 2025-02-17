package com.gn.board.dao;

import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.board.vo.Attach;
import com.gn.board.vo.Board;

public class BoardDao {
	
	public String selectAttachPath(int attachNo,Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String attachPath = null;
		try {
			String sql = "SELECT attach_path "
					+ "FROM `attach` "
					+ "WHERE attach_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, attachNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				attachPath = rs.getString("attach_path");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return attachPath; 
	}
	
	public Board selectBoardOne(int boardNo, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board b = null;
		try {
			String sql = "SELECT b.board_no ,b.board_title ,b.board_content "
					+ ",b.board_writer ,b.reg_date ,b.mod_date "
					+ ",m.member_name ,a.ori_name ,a.attach_no "
					+ "FROM `board` b "
					+ "JOIN `member` m ON b.board_writer = m.member_no "
					+ "JOIN `attach` a ON b.board_no = a.board_no "
					+ "WHERE b.board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b = new Board();
				b.setBoardNo(rs.getInt("board_no"));
				b.setBoardTitle(rs.getString("board_title"));
				b.setBoardContent(rs.getString("board_content"));
				b.setBoardWriter(rs.getInt("board_writer"));
				b.setMemberName(rs.getString("member_name"));
				b.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				b.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				b.setOriName(rs.getString("ori_name"));
				b.setAttachNo(rs.getInt("attach_no"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b; 
	}
	
	public int selectBoardCount(Connection conn, Board option) {
		int result = 0; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM board";
		try {
			if(option.getBoardTitle() != null) {
				sql += "WHERE board_title LIKE CONCAT('%',?,'%')";
			}
			pstmt = conn.prepareStatement(sql);
			if(option.getBoardTitle() != null) {
				pstmt.setString(1, option.getBoardTitle());
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	
	public List<Board> selectBoardList(Connection conn,Board option) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
		try {
			String sql = "SELECT * "
					+ "FROM `board` b "
					+"JOIN `member` m "
					+"ON b.board_writer = m.member_no";
			if(option.getBoardTitle() != null) {
				sql += " WHERE board_title "
					+ "LIKE CONCAT('%','"+option.getBoardTitle()+"','%')";
			}
			///  추가 ///
			sql += " LIMIT "+option.getLimitPageNo()+", "+option.getNumPerPage();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setBoardNo(rs.getInt("board_no"));
				b.setBoardTitle(rs.getString("board_title"));
				b.setBoardContent(rs.getString("board_content"));
				b.setBoardWriter(rs.getInt("board_writer"));
				b.setMemberName(rs.getString("member_name"));
				b.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				b.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	public int createAttach(Attach a, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0; 
		try {
			String sql = "INSERT INTO `attach`(board_no,ori_name,new_name,attach_path) "
					+ "VALUES(?,?,?,?)";
			// 사용하는 jdbc가 3버전 이상인 경우
			// insert의 결과로 생성된 autoincrement의 값 가져올 수 있음
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, a.getBoardNo());
			pstmt.setString(2, a.getOriName());
			pstmt.setString(3,a.getNewName());
			pstmt.setNString(4, a.getAttachPath());
			result = pstmt.executeUpdate();
			
			// 쿼리 실행 후 생성된 키 반환
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public int createBoard(Board b, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0; 
		try {
			String sql = "INSERT INTO `board`(board_title,board_content,board_writer) "
					+ "VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setInt(3,b.getBoardWriter());
			result = pstmt.executeUpdate();
			
			// 쿼리 실행 후 생성된 키 반환
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				result = rs.getInt(1);
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
