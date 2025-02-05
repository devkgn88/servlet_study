package com.gn.practice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/borrow")
public class BookReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookReservationController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("user_name");
		String userPhone = request.getParameter("user_phone");
		String userEmail = request.getParameter("user_email");
		int bookId = Integer.parseInt(request.getParameter("book"));
		int duration = Integer.parseInt(request.getParameter("duration"));

		// 도서 선택 (가격 설정)
		String bookTitle = "";
		int bookPrice = 0;
		switch(bookId) {
			case 1: bookTitle = "자바 프로그래밍 입문"; bookPrice = 1500; break;
			case 2: bookTitle = "웹 개발의 기초"; bookPrice = 1800; break;
			case 3: bookTitle = "데이터베이스 시스템"; bookPrice = 2000; break;
		}

		// 대출 기간에 따른 추가 요금 (1일 당 500원)
		int totalPrice = bookPrice + (duration - 1) * 500;

		// 대출 정보 전달
		request.setAttribute("userName", userName);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("bookTitle", bookTitle);
		request.setAttribute("duration", duration);
		request.setAttribute("totalPrice", totalPrice);

		RequestDispatcher view = request.getRequestDispatcher("views/bookConfirmation.jsp");
		view.forward(request, response);
	}
}