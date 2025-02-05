<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 연습하기</title>
</head>
<body>
	<h2>피자 주문하기</h2>
	<form action="/order" method="post">
		<fieldset>
			<legend>고객 정보</legend>
			<label for="user_name">고객명 : </label>
			<input type="text" id="user_name" name="user_name">
			<label for="user_phone">전화번호 : </label>
			<input type="text" id="user_phone" name="user_phone">
			<label for="user_email">E-mail : </label>
			<input type="email" id="user_email" name="user_email">
		</fieldset>
		<fieldset>	
			<legend>피자 사이즈</legend>
			<input type="radio" id="small" name="size" value="1" checked>
			<label for="small">small</label>
			<input type="radio" id="medium" name="size" value="2">
			<label for="medium">medium</label>
			<input type="radio" id="large" name="size" value="3">
			<label for="large">large</label>
		</fieldset>
		<fieldset>
			<legend>토핑 선택</legend>
			<input type="checkbox" name="add" id="shrimp" value="1">
	        <label for="shrimp">새우</label><br>
	        <input type="checkbox" name="add" id="sweet" value="2">
	        <label for="sweet">고구마</label><br>
	        <input type="checkbox" name="add" id="potato" value="3">
	        <label for="potato">감자</label><br>
	        <input type="checkbox" name="add" id="pine" value="4">
	        <label for="pine">파인애플</label>
		</fieldset>
		<button>주문하기</button>
	</form>
</body>
</html>