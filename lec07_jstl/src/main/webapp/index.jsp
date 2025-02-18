<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL/JSTL</title>
</head>
<body>
	<h2>JSTL</h2>
	<h1>1. 변수 관련 태그</h1>
	<c:set var="small" value="10"/>
	<c:set var="big" value="20"/>
	<c:set var="result" value="${small + big}"/>
	
	<c:set var="result" value="<b>안녕하세요!</b>"/>
	<!-- 기본 출력: <b>안녕하세요!</b>가 태그가 아니라 글자로 보임 -->
	<c:out value="${result}"/><br>

	<!-- escapeXml="false" 설정: <b>안녕하세요!</b>가 실제로 굵게 표시됨 -->
	<c:out value="${result}" escapeXml="false"/>
	<h1>2. 조건문 (if)</h1>
	<c:if test="${small le big}">
		<p>10이 20보다 작거나 같습니다.</p>
	</c:if>
	<h1>3. 조건문(choose)</h1>
	<c:choose>
		<c:when test="${big gt 20}">
			<b>big이 20보다 클때</b>
		</c:when>
		<c:when test="${big ge 10 }">
			<b>big은 10보다 크거나 같습니다.</b>
		</c:when>
		<c:otherwise>
			<b>그 외 상황</b>
		</c:otherwise>
	</c:choose>
	<hr>
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
	<%@page import="java.util.*" %>
	<%
	 // 숫자 전달
    request.setAttribute("num1", 10);
    request.setAttribute("num2", 3);

    // 문자열 전달
    request.setAttribute("str1", "사과");
    request.setAttribute("str2", "바나나");

    // 객체 전달
    request.setAttribute("p1", new Person("이영희", 13));
    request.setAttribute("p2", null);

    // 리스트 전달
    request.setAttribute("list1", new ArrayList<>());  // 빈 리스트
    List<String> list2 = new ArrayList<>();
    list2.add("오늘 날씨가 춥네요");
    request.setAttribute("list2", list2);
	%>
	<h3>1. 산술 연산</h3>
	<p>
		10 + 3 = ${num1+num2}<br>
		10 - 3 = ${num1-num2}<br>
		10 * 3 = ${num1*num2}<br>
		10 / 3 = ${num1 / num2} 또는 ${num1 div num2}<br>
		10 % 3 = ${num1 % num2} 또는 ${num1 mod num2} 
	</p>
	<h3>2. 문자열 연결</h3>
	<p>${str1}${str2}</p>
	<h3>3.대소 비교 연산</h3>
	<p>
		10이 3보다 큰가요 : ${num1>num2} 또는 ${num1 gt num2}<br>
		10이 3보다 작은가요 : ${num1<num2} 또는 ${num1 lt num2}<br>
		10이 3보다 크거나 같은가요 : ${num1>=num2} 또는 ${num1 ge num2}<br>
		10이 3보다 작거나 같은가요 : ${num1<=num2} 또는 ${num1 le num2}<br>	
	</p>
	<h3>4. 동등 비교 연산</h3>
	<p>
		숫자 일치 : ${num1 == 10} 또는 ${num1 eq 10}<br>
		숫자 불일치 : ${num2 !=3} 또는 ${num2 ne 3}<br>
		문자 일치 : ${str1 == str2} 또는 ${str1 eq str2}<br>
		문자값 비교 : ${str1 eq "복숭아"} 또는 ${str2 eq '배'}  
	</p>
	<h3>5. 객체 null 확인</h3>
	<p>
		p2가 null인가요 : ${p2 == null} 또는 ${empty p2}<br>
		p1이 null이 아닌가요 : ${p1 != null} 또는 ${not empty p1}
	</p>
	<h3>6. 리스트 비어있는지 확인</h3>
	<p>
		list1이 비어있나요 : ${empty list1}<br>
		list2에 데이터가 있나요 : ${not empty list2}
	</p>
	<h3>7. 논리 연산자</h3>
	<p>
		${ true && true } 또는 ${ true and true }<br>
		${ false || true } 또는 ${ false or true }
	</p>
</body>
</html>