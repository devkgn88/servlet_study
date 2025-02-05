<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립팅 요소</title>
</head>
<body>
	<%-- Scriptlet : 일반적인 자바 코드 --%>
	<% 
		int sum = 0;
		for(int i = 0 ; i <= 10 ; i++){
			sum += i;
		}
		out.println("총합 : "+sum);
	%>
	<br>
	<%-- Expression : (화면에)출력 --%>
	<%= "총합 : " + sum %>
	<br>
	<%-- Declaration : 선언 --%>
	<%! int visitCount = 0; %>
	<%! public int sumNum(int a, int b){
			return	a + b; 
	} %>
	<%= "더하기 : "+sumNum(1,2) %>
	<br>
	<%! int count = 0; %>   <%-- Declaration : 한 번만 선언되고 값 유지 --%>
	<% count++; %>         <%-- Scriptlet : 요청이 올 때마다 실행됨 --%>
	<%= "횟수 : "+count %>           <%-- Expression : 값 출력 --%>
</body>
</html>