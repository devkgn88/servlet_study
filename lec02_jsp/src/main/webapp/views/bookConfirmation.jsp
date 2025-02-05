<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userName = (String)request.getAttribute("userName");
	String userPhone = (String)request.getAttribute("userPhone");
	String userEmail = (String)request.getAttribute("userEmail");
	String bookTitle = (String)request.getAttribute("bookTitle");
	int duration = (int)request.getAttribute("duration");
	int totalPrice = (int)request.getAttribute("totalPrice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 대출 내역</title>
</head>
<body>
	<h1>도서 대출 내역</h1>
	<h4>[고객 정보]</h4>
	<ul>
		<li>고객명: <%= userName %></li>
		<li>전화번호: <%= userPhone %></li>
		<li>이메일: <%= userEmail %></li>
	</ul>

	<h4>[대출 정보]</h4>
	<ul>
		<li>도서 제목: <%= bookTitle %></li>
		<li>대출 기간: <%= duration %>일</li>
	</ul>

	<h3>대출 금액: <%= totalPrice %>원</h3>
	<h4>도서를 즐겁게 읽으세요!</h4>
</body>
</html>
