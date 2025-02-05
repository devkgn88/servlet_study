<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directive 태그(page) 연습하기</title>
</head>
<body>
<h1>page 지시어</h1>
	<%
		List<String> list = new ArrayList<String>();
		list.add("사과"); // 0번인덱스
		list.add("바나나"); // 1번인덱스 
	%>
	<h2>크기 : <%= list.size() %></h2>
	<ul>
		<li><%= list.get(0) %></li>
		<li><%= list.get(1) %></li>
	</ul>
</body>
</html>