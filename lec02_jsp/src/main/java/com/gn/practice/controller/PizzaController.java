package com.gn.practice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order")
public class PizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PizzaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("user_name");
		String phone = request.getParameter("user_phone");
		String email = request.getParameter("user_email");
		int size = Integer.parseInt(request.getParameter("size"));
		String[] toppings = request.getParameterValues("add");
		
		int price = 0;
		// size기준
		// 1. small 사이즈 : 15900원
		// 2. medium 사이즈 : 21000원
		// 3. large 사이즈 : 27900원
		switch(size) {
			case 1 : price = 15900; break;
			case 2 : price = 21000; break;
			case 3 : price = 27900; break;
		}
		// topping 기준
		// 새우 추가 2000원
		// 나머지(고구마,감자,파인애플) 추가 : 1000원
		if(toppings != null) {
			for(int i = 0 ; i < toppings.length ; i++) {
				int top = Integer.parseInt(toppings[i]);
				if(top == 1) price += 2000;
				else price += 1000;
			}
		}
		
		RequestDispatcher view = request.getRequestDispatcher("views/pizzaPayment.jsp");
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		request.setAttribute("size", size);
		request.setAttribute("toppings", toppings);
		request.setAttribute("price", price);
		view.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}