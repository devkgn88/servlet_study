<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 통신</title>
<script src="/resources/jquery-3.7.1.js"></script>
</head>
<body>
	<a href="/guestBook">방명록</a>
	<h1>JavaScript</h1>
	<a href="/jsAjaxPage">연습 화면 이동</a>
	<h1>jQuery</h1>
	<a href="/jQueryAjaxPage">연습 화면 이동</a>
	<h1>JSON</h1>
	<input type="button" value="조회" id="json_btn">
	<div id="result_div">
	
	</div>
	<script>
		$(function(){
			$("#json_btn").click(function(){
				$.ajax({
					url:"<%=request.getContextPath()%>/accountList",
					type:"get",
					dataType:"JSON",
					success : function(data){
						console.log(data);
						console.log(data.arr);
						for(let i = 0 ; i < data.arr.length ; i++){
							console.log(data.arr[i].no);
							console.log(data.arr[i].name);
						}
					}
				})
				
			})
		})
	</script>
</body>
</html>