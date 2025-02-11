package com.gn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jqueryAjaxGet")
public class JQueryAjaxGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JQueryAjaxGetServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		// 1. 응답할 문서 형태 선언
		response.setContentType("text/html; charset=utf-8");
		// 2. 연결통로 생성 후 문구 추가
		response.getWriter()
		.append("<p>입력된 아이디 "+userId+"의 길이는 "+userId.length()+"입니다.</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
