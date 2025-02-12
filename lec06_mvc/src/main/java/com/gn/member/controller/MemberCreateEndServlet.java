package com.gn.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.gn.member.vo.Member;

@WebServlet(name="memberCreateEndServlet", 
urlPatterns = "/memberCreateEnd")
public class MemberCreateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberCreateEndServlet() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("member_id");
		String pw = request.getParameter("member_pw");
		String name = request.getParameter("member_name");
		
		Member m = new Member();
		m.setMemberId(id);
		m.setMemberPw(pw);
		m.setMemberName(name);
		
		JSONObject obj = new JSONObject();
		obj.put("key", 1);
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(obj);
		
//		int result = new MemberService().createMember(m);
//		RequestDispatcher view = request.getRequestDispatcher("/views/member/create_fail.jsp");
//		if(result > 0) {
//			view = request.getRequestDispatcher("/views/member/create_success.jsp");
//		} 
//		view.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
