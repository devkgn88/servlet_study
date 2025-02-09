package com.gn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginEnd")
public class LoginEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String accountId = request.getParameter("account_id");
	        String accountPw = request.getParameter("account_pw");
	        String rememberId = request.getParameter("remember_id");

	        // 실제 로그인 로직은 실습때 구현
	        if ("user01".equals(accountId) && "pass01".equals(accountPw)) {
	            if (rememberId != null) {
	                // 아이디 기억하기 체크 시 쿠키 생성 (유효기간 7일)
	                Cookie c = new Cookie("account_id", accountId);
	                c.setMaxAge(60 * 60 * 24 * 7);
	                response.addCookie(c);
	            } else {
	                // 체크 해제 시 쿠키 삭제 (유효기간 0으로 설정)
	                Cookie c = new Cookie("account_id", "");
	                c.setMaxAge(0);
	                response.addCookie(c);
	            }

	            response.sendRedirect("/"); // 로그인 성공 후 이동
	        } else {
	            response.sendRedirect("/login"); // 로그인 실패 시 다시 로그인 페이지로
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
