<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제이쿼리 방식</title>
<%-- <script src="<%=request.getContextPath()%>/resources/jquery-3.7.1.js"></script> --%>
<script src="../../resources/jquery-3.7.1.js"></script>
</head>
<body>
	<input type="text" id="userId" name="user_id">
	<button id="get_btn">Get방식</button>
	<button id="post_btn">Post방식</button>
	<div id="result_div">
	
	</div>
	<script>
		$(document).ready(function(){
			$("#post_btn").click(function(){
				const userId = $("#userId").val();
				$.ajax({
					url:"/jqueryAjaxGet",
					type:"post",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					data:{userId:userId},
					success:function(data){
						$("#result_div").append(data);
					},
					error: function(){
	                    alert("서버 요청 중 오류 발생!");
	                }
				})
			})
			
			$("#get_btn").click(function(){
				const userId= $("#userId").val();
				$.ajax({
					url:"/jqueryAjaxGet?userId="+userId,
					type:"get",
					success:function(data){
						$("#result_div").append(data);
					},
					error: function(){
	                    alert("서버 요청 중 오류 발생!");
	                }
					
				})
			})
		})
	</script>
</body>
</html>