<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
    Cookie[] cookies = request.getCookies();
    String accountId = "";
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("account_id".equals(c.getName())) {
                accountId = c.getValue();
            }
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
    <form action="/loginEnd" method="post">
    	<label for="account_id">아이디 : </label>
    	<input type="text" name="account_id" id="account_id"
        value="<%= accountId %>"><br>
        <label for="account_pw">비밀번호 : </label>
        <input type="password" name="account_pw" id="account_pw"><br>
        <input type="checkbox" name="remember_id" id="remember_id"
        <% if (!accountId.isEmpty()) { %>checked<% } %>>
        <label for="remember_id">아이디 기억하기</label><br>
        <button type="submit">로그인</button>
    </form>
</body>
</html>