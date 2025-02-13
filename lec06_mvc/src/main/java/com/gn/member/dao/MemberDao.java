package com.gn.member.dao;

import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gn.member.vo.Member;

public class MemberDao {
	public int createMember(Member m, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0; 
		try {
			String sql = "INSERT INTO `member`(member_id,member_pw,member_name) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public Member loginMember(String id, String pw, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		try {
			String sql = "SELECT *"
					+ "FROM `member` "
					+ "WHERE member_id = ? AND member_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m = new Member(rs.getInt(1),rs.getString(2)
						,rs.getString(3),rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
}
