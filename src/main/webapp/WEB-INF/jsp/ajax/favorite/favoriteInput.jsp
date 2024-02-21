<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
<title>즐겨찾기 추가</title>
</head>
<body>
	
	<h2>즐겨 찾기 추가하기</h2>
	
	<div>
		<label>제목</label><br>
		<input type="text" size=100 id="titleInput"><br>
		<label>주소</label><br>
		<input type="text" size=100 id="urlInput"><br><br>
		<button type="button" id="addButton" class="btn btn-success">추가</button>
	</div>
	
	
	
	
	
	<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous"></script>
	
	
	
	<script>
		$(document).ready(function(){
			
			$("#addButton").on("click",function(){
				let title = $("#titleInput").val();
				let url = $("#urlInput").val();
				
			if(title == ""){
				alert("제목을 입력하세요 ");
				return ;
			}
			
			if(url == ""){
				alert("url을 입력하세요 ");
			}
				
			
			
			// 주소가 http:// 로 시작하지 않거나 
			// https:// 로 시작하지 않으면
			
			if(!url.startsWith("http://") && !url.startsWith("https://")){
				alert("주소형식을 확인해 주세요");
				return;
			}
			
			
			$.ajax({
				type:"post"
				, url:"/ajax/favorite/create"
				, data:{"name":title, "url":url}
				, success:function(data){
					if(data.result == "success"){
						// 입력된 결과를 확인할 수 있는 리스트 페이지로 이동
						alert("성공!");
						location.href = "/ajax/favorite/list";
					}else{
						alert("추가 실패");
					}
				}
				
				, error:function(){
					alert("추가 에러");
				}
			});
			
			
			
			
			
			
			
			});
			
		});
	
	
	
	
	</script>
	
	
	
</body>
</html>