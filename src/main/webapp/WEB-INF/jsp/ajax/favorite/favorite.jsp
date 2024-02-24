<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
<title>즐겨찾기 목록</title>
</head>
<body>
	
	
	<table class="table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="favorite" items="${favoriteList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${favorite.name }</td>
				<td>${favorite.url }</td>
				<td><button type="button" class="btn btn-danger delete-btn">삭제</button>
				<%-- 클래스로 이름 부여해서 이벤트를 아이디 기반이 아니라 클래스 기반으로 --%>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	

	
		<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			
			//id 를 얻어와야 삭제 대상을 특정화 할 수 있음
			//$(this)
			
			
			$(".delete-btn").on("click",function(){
				
				
				$.ajax({
					type:"get"
					, url:"/ajax/favorite/delete"
					, data:{"id":}
					
					
					
				});
				
				
			});
			
			
			
		});
	

	</script>
	
	
	
	
</body>
</html>