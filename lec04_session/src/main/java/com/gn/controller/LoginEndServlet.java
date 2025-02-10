package com.gn.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gn.vo.Account;


@WebServlet("/loginEnd")
public class LoginEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String accountId = request.getParameter("account_id");
	        String accountPw = request.getParameter("account_pw");
	        String rememberId = request.getParameter("remember_id");
	        
	        // 1. 아이디, 비밀번호 정보와 일치하는 데이터가 있는지 확인
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Account account = null;
	        try {
	        	Class.forName("org.mariadb.jdbc.Driver");
	        	String url ="jdbc:mariadb://127.0.0.1:3306/login_project";
	        	String user="scott";
	        	String pw = "tiger";
	        	conn = DriverManager.getConnection(url,user,pw);
	    		String sql = "SELECT * FROM account where account_id = ? and account_pw = ?";
	        	pstmt = conn.prepareStatement(sql);
	        	pstmt.setString(1, accountId);
	        	pstmt.setString(2, accountPw);
	        	rs=pstmt.executeQuery();
	        	if(rs.next()) {
	        		account = new Account(rs.getInt("account_no")
	        				,rs.getString("account_id")
	        				,rs.getString("account_pw"));
	        	}
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }finally {
	        	try {
	        		rs.close();
	        		pstmt.close();
	        		conn.close();
	        	}catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        }
	        
	        // 2-1. 일치하는 데이터가 있는 경우
	        // 		사용자의 정보를 담고 있는 객체 Session에 저장
	        //		사용자가 아이디 정보 저장하고 싶어하면 Cookie에 저장
	        //		저장하고 싶지 않으면 Cookie에 저장X
	        // 		로그인 성공시 홈으로 이동
	        if(account != null) {
	        	HttpSession session = request.getSession();
	    		if(session.isNew() || session.getAttribute("account") == null) {
	    			session.setAttribute("account", account);
	    			session.setMaxInactiveInterval(10);
	    		}
	    		
	    		if(rememberId != null) {
	    			Cookie cookie = new Cookie("remember_id",account.getAccountId());
	    			cookie.setMaxAge(60 * 60 * 24 * 7);
	    			response.addCookie(cookie);
	    		}else {
	    			Cookie cookie = new Cookie("account_id", "");
	                cookie.setMaxAge(0);
	                response.addCookie(cookie);
	    		}
	    		response.sendRedirect("/");
	        }
	        // 2-2. 일치하는 데이터가 없는 경우
	        // 		로그인 실패시 다시 로그인 페이지로
	        else {
	        	response.sendRedirect("/login");
	        }
	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
