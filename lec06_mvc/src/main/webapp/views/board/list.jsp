<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href='<%=request.getContextPath()%>/resources/css/board/list.css' rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>게시글 목록</h3>
			</div><br>
			<div class="search">
				<form action="/boardList" name="search_board_form" method="get">
					<input type="text" name="board_title" placeholder="검색하고자 하는 게시글 제목을 입력하세요.">
					<input type="submit" value="검색">
				</form>	
			</div>
			
			<div class="board_list">
				<table>
					<colgroup>
						<col width="10%">
						<col width="50%">
						<col width="20%">
						<col width="20%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일시</th>
						</tr>
					</thead>
					<tbody>
						<%@page import="com.gn.board.vo.Board, java.util.*, java.time.format.*" %>
						<%
							List<Board> list = (List<Board>)request.getAttribute("resultList");
							for(int i = 0 ; i < list.size(); i++){ %>
								<tr>
									<td><%=list.get(i).getBoardNo()%></td>
									<td><%=list.get(i).getBoardTitle()%></td>
									<td><%=list.get(i).getMemberName()%></td>
									<%
									DateTimeFormatter dtf
									= DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
									%>
									<td><%=list.get(i).getRegDate().format(dtf)%></td>
								</tr>
						<%}%>
					</tbody>
				</table>
			</div>
		</div>
	</section>	
</body>
</html>