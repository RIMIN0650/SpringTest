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
  
<title>사용자 추가</title>
</head>
<body>
	
	<h3>사용자 추가</h3>
	
	<!-- web inf 안에 있는 파일은 접근 못 하도록 막아뒀음 따라서 모든 응답과 요청 처리는 Controller에서 담당 -->
		
		<label>이름 : <input type="text" id="nameInput"> <br></label>
		생년월일 : <input type="text" id="birthdayInput"> <br>
		이메일 : <input type="text" id="emailInput"> <br><button type="button">중복 확인</button>
		<button type="button" id="addBtn">추가</button>

	<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			
			// 추가 버튼이 클릭되면 
			$("#addBtn").on("click", function(){
				alert();
				//입력 값을 얻어와서
				// input태그를 객체화 해서 value 속성 가져옴
				let name = $("#nameInput").val();
				let birthday = $("#birthdayInput").val;
				let email = $("#emailInput").val;
				
				// create API 호출한다
				$.ajax({
					type:"get"
					, url:"/ajax/user/create"
					, data:{"name":name, "birthday":birthday, "email":email}
					, success:function(data){
						// 성공 : {"result" : "success"}
						// 실패 : {"result" : "fail"}
						if(data.result == "success"){
							// 성공
							// 리스트 페이지로 이동
							location.href = "ajax/user/list";
						} else{
							// 실패
							alert("추가 실패!");
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