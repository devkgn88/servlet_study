package com.gn.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.gn.member.service.MemberService;
import com.gn.member.vo.Member;

@WebServlet(name="memberLoginEndServlet", urlPatterns = "/memberLoginEnd")
public class MemberLoginEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginEndServlet() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("member_id");
		String pw = request.getParameter("member_pw");
		
		// 전달받은 아이디와 비밀번호가 일치하는 회원 정보
		Member m = new MemberService().loginMember(id,pw);
		JSONObject obj = new JSONObject();
		obj.put("res_code", "500");
		obj.put("res_msg","로그인 중 오류가 발생하였습니다.");
		
		if(m != null) {
			HttpSession session = request.getSession();
			if(session.isNew() || session.getAttribute("member") == null) {
				session.setAttribute("member", m);
				session.setMaxInactiveInterval(60*30);
			}
			obj.put("res_code", "200");
			obj.put("res_msg","정상적으로 로그인되었습니다.");		
		}
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
