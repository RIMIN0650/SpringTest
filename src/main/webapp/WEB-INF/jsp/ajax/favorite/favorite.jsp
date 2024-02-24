<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  
<title>즐겨찾기 목록</title>
</head>
<body>
	
	
	<table class="table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>주소</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="favorite" items="${favoriteList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${favorite.name }</td>
				<td>${favorite.url }</td>
				<td><button type="button" data-favorite-id="${favorite.id }" class="btn btn-danger delete-btn">삭제</button>
				<%-- 클래스로 이름 부여해서 이벤트를 아이디 기반이 아니라 클래스 기반으로 --%>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	

	
		<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		 
	<script>
		$(document).ready(function(){
			
			//id 를 얻어와야 삭제 대상을 특정화 할 수 있음
			//$(this)
			
			
			//버튼 태그에 삭제 대상 id 속성이 부여된 상태
			// data-favorite-id
			// 이벤트가 발생한 그 버튼 태그의 data-favorite-id 속성 값을 가져온다.
			// 삭제 대상의 id를 얻어올 수 있다. 			
			
			$(".delete-btn").on("click",function(){
				

				let favoriteId = $(this).data("favorite-id");
				
				$.ajax({
					type:"get"
					, url:"/ajax/favorite/delete"
					, data:{"id":favoriteId}
					, success:function(data){
						// 성공 : {"result":"success"}
						// 실패 : {"result" : "fail"}
						if(data.result == "success"){
							// 새로고침
							location.reload();
							
						} else {
							alert("삭제 실패");
						}	
					}					
					, error:function(){
						alert("삭제 에러");
					}
				});
			});	
		});
	

	</script>
	
	
	
	
</body>
</html>