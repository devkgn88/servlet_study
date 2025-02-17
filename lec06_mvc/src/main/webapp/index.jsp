<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈화면</title>
<link href='<%=request.getContextPath()%>/resources/css/index.css' rel="stylesheet" type="text/css">
</head>
<body>
	<%-- include 지시어는 webapp가 최상위 경로 --%>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>HOME</h3>
			</div>
		</div>
	</section>
</body>
</html>