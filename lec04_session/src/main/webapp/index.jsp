<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션</title>
</head>
<body>
	<h1>쿠키 연습하기</h1>
	<ul>
		<li>
			<a href="/createCookie">생성하기</a>
		</li> 
		<li>
			<a href="/editCookie">수정하기</a>
		</li>
		<li>
			<a href="/removeCookie">삭제하기</a>
		</li>
	</ul>
	<%
		Cookie[] cookies = request.getCookies();
		String userId = "쿠키 없음";
		if(cookies != null){
			for(Cookie c : cookies){
				if("user_id".equals(c.getName())){
					userId = c.getValue();
				}
			}
		}
		
	%>
	<h3>아이디 : <%=userId%></h3>
	<a href="/login">로그인</a>
	<h1>세션 연습하기</h1>
	<ul>
		<li>
			<a href="/createSession">
				생성하기
			</a>
		</li>
		<li>
			<%
				String memberId = "세션 없음";
				if(session != null){
					memberId = (String)session.getAttribute("member_id");
				}
			%>
			<%=memberId %>
		</li>
	</ul>
<!-- 	<form action="/createSession" method="get">
		<label>아이디</label>
		<input type="text" name="mem_id">
		<input type="submit" value="생성">
	</form> -->
</body>
</html>