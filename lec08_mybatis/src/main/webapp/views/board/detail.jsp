<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세/수정</title>
</head>
<body>
	<form action="<c:url value='/boardUpdate'/>" method="post">
		<input type="hidden" name="board_no" value="<c:out value='${vo.boardNo}'/>">
		<label for="board_title">제목</label>
		<input type="text" id="board_title" name="board_title" value="<c:out value='${vo.boardTitle}'/>"><br>
		<label for="board_content">내용</label>
		<textarea id="board_content" name="board_content"><c:out value="${vo.boardContent}"/></textarea><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>