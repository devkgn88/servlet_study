package com.gn.member.service;

import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.gn.member.dao.MemberDao;
import com.gn.member.vo.Member;

public class MemberService {
	public int createMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().createMember(m,conn);
		close(conn);
		return result;
	}
	public Member loginMember(String id, String pw) {
		Connection conn = getConnection(); 
		Member m = new MemberDao().loginMember(id,pw,conn);
		close(conn);
		return m;
	}
	public int updateMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().updateMember(m,conn);
		close(conn);
		return result; 
	}
}
