<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL/JSTL</title>
</head>
<body>
	<h2>내장객체(기초)</h2>
	<%
	    // 1. pageScope 설정
	    pageContext.setAttribute("test", "페이지 범위");
	    // 2. requestScope 설정
	    request.setAttribute("test", "리퀘스트 범위");
	    // 3. sessionScope 설정
	    session.setAttribute("test", "세션 범위");
	    // 4. applicationScope 설정
	    application.setAttribute("test", "애플리케이션 범위");
	%>
	<h3>JSP 방식</h3>
	<p><%= pageContext.getAttribute("test")%></p>
	<p><%= request.getAttribute("test")%></p>
	<p><%= session.getAttribute("test")%></p>
	<p><%= application.getAttribute("test")%></p>
	<h3>EL 방식</h3>
	<p>${test}</p>
	<p>${pageScope.test}</p>
	<p>${requestScope.test}</p>
	<p>${sessionScope.test}</p>
	<p>${applicationScope.test}</p>
	
	<h2>내장객체(조회)</h2>
	<%@ page import="com.gn.vo.Person" %>
	<% request.setAttribute("person", new Person("김철수",25)); %>
	<h3>JSP 방식</h3>
	<% Person p = (Person)request.getAttribute("person");%>
	<p>이름: <%= p.getName() %></p>
	<p>나이: <%= p.getAge() %>세</p>
	<h3>EL 방식</h3>
	<p>이름: ${person.name}</p>
	<p>나이: ${person.age}세</p>	
	
	<h3>EL의 연산자</h3>
</body>
</html>