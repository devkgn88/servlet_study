<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈화면</title>
</head>
<body>
	<ol>
		<li>
			<a href="<c:url value='/boardList'/>">목록 조회</a>
		</li>
		<c:url value="/boardDetail" var="url">
			<c:param name="board_no" value="7"/>
		</c:url>
		<li>
			<a href="${url}">
				상세 조회(boardNo)
			</a>
			<br>
			<form action="<c:url value='/boardDetail' />">
				<fieldset>
					<legend>제목과내용</legend>
					<input type="text" name="board_title"><br>
					<input type="text" name="board_content">
					<input type="submit" value="검색">
				</fieldset>
			</form>
		</li>
		<li>수정</li>
		<li>
			<a href="<c:url value='/boardDelete?board_no=7'/>">삭제</a>
		</li>
		<li>
			<form action="<c:url value='/boardCreate'/>" method="post">
				<fieldset>
					<legend>게시글</legend>
					<input type="text" name="board_title"><br>
					<input type="text" name="board_content"><br>
					<input type="hidden" name="board_writer" value="3">
					<input type="submit" value="등록">
				</fieldset>
			</form>
		
		</li>
	</ol>
	
</body>
</html>