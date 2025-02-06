package com.gn.study.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="receiveDataServlet",urlPatterns = "/receive/data")
public class ReceiveDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReceiveDataServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===== 데이터 확인 =====");
		String testData = request.getParameter("test_data");
		System.out.println("데이터 : "+testData);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
