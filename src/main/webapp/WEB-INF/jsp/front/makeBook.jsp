<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/front/css/style.css" type="text/css">

<title>통나무 팬션 예약 목록</title>
</head>
<body>
	
	<div id="wrap">
		<header class="text-center pt-4">
			<h1>통나무 팬션</h1>
		</header>
		<nav class="main-menu">
			<ul class="nav nav-fill w-100">
				<li class="nav-item"><a class="nav-link mt-1 text-white" href="#">팬션소개</a></li>
				<li class="nav-item"><a class="nav-link mt-1 text-white" href="#">객실보기</a></li>
				<li class="nav-item"><a class="nav-link mt-1 text-white" href="#">예약하기</a></li>
				<li class="nav-item"><a class="nav-link mt-1 text-white" href="#">예약목록</a></li>
			</ul>
		</nav>
		<section>
			<div class="info d-flex justify-content-center">
				<h3 class="mt-3">예약하기</h3>
			</div>
			<div class="text-center">
				<label>이름</label>
				<input type="text" id="name"><br>
				<label>예약날짜</label>
				<input type="text" id="date"><br>
				<label>숙박일수</label>
				<input type="text" id="day"><br>
				<label>숙박인원</label>
				<input type="text" id="headcount"><br>
				<label>전화번호</label>
				<input type="text" id="phoneNumber"><br><br>
				<button type="button" class="btn btn-warning" id="bookingBtn">예약하기</button>
			</div>
		</section>	
		<footer class="text-secondary mt-1 ml-1">
			제주특별시 제주시 애월읍<br>
			사업자 등록 번호 111-22-3334455/농어촌민박사업자지정/대표:김통목<br>
			Copyright 2025 tongnamu All right reserved
		</footer>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
	
	
	<script>
		$(document).ready(function(){
			
			$("#bookingBtn").on("click",function(){
				
				let name = $("#name").val();
				let date = $("#date").val();
				let day = $("#day").val();
				let headcount = $("#headcount").val();
				let phoneNumber = $("#phoneNumber").val();
				
				if(name == ""){
					alert("이름을 입력하세요.");
					return;
				}
				else if(date == ""){
					alert("예약날짜를 입력하세요");
					return;
				}
				else if(day == ""){
					alert("숙박일수를 입력하세요");
					return;
				}
				else if(headcount == ""){
					alert("숙박인원을 입력하세요");
					return;
				}
				else if(phoneNumber == ""){
					alert("전화번호를 입력하세요");
					return;
				}
				
				
				alert("예약하기 버튼 정상 작동 ");
			});
			
			
			
			
		});
	
	
	</script>
	
</body>
</html>