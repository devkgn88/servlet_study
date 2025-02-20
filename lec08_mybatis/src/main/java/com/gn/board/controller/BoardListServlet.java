package com.gn.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Board;

@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int searchType = Integer.parseInt(request.getParameter("search_type"));
		String searchText = request.getParameter("search_text");
		
		Board option = new Board();
		option.setSearchType(searchType);
		option.setSearchText(searchText);
		
		List<Board> resultList = new BoardService().selectBoardList(option);
		System.out.println(resultList);
		request.setAttribute("resultList", resultList);
		RequestDispatcher view = request.getRequestDispatcher("/views/board/list.jsp");
		view.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
