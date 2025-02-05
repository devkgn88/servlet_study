<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name");
	String phone = (String)request.getAttribute("phone");
	String email = (String)request.getAttribute("email");
	int size = (int)request.getAttribute("size");
	String[] toppings = (String[])request.getAttribute("toppings");
	int price = (int)request.getAttribute("price");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 주문서</title>
</head>
<body>
	<h1>주문내역</h1>
	<h4>[고객정보]</h4>
	<ul>
		<li>성함 : <%=name%></li>
		<li>전화번호 : <%=phone%></li>
		<li>이메일 : <%=email%></li>
	</ul>
	<h4>[주문정보]</h4>
	<ul>
		<li>
			사이즈 : 
			<%if(size == 1){%>
				small
			<%} else if(size == 2){ %>
				medium
			<%} else{%>
				large
			<%} %>
		</li>
		<li>
			토핑 : 
			<ul>
				<%for(int i = 0 ; i < toppings.length ; i++){
					int type = Integer.parseInt(toppings[i]);
					String text = "";
					switch(type){
						case 1 : text ="새우";break;
						case 2 : text = "고구마";break;
						case 3 : text = "감자";break;
						case 4 : text = "파인애플";break;
					}%>
					<li><%=text%> </li>
				<%}%>
			</ul>
		</li>
	</ul>
	<h4>위와 같이 주문하셨습니다.</h4>
	<h3>총 가격 : <%=price%>원</h3>
	<h4>즐거운 식사 시간되세요~</h4>
</body>
</html>