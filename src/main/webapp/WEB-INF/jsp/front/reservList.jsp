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

<title>통나무 팬션 홈페이지</title>
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
				<h3 class="mt-3">예약 목록 보기</h3>
			</div>
			<div>
				<table class="table text-center">
					<thead>
						<tr>
							<th>이름</th>
							<th>예약날짜</th>
							<th>숙박일수</th>
							<th>숙박인원</th>
							<th>전화번호</th>
							<th>예약상태</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${bookingList }">
							<tr>
								<td>${book.name }</td>
								<td><fmt:formatDate value="${book.date }" pattern="yyyy년 M월 d일"/> </td>
								<td>${book.day }일</td>
								<td>${book.headcount }명</td>
								<td>${book.phoneNumber }</td>
								<c:choose>
									<c:when test="${book.state eq '대기중'}">
										<td class="text-info">${book.state }</td>							
									</c:when>
									<c:when test="${book.state eq '확정'}">
										<td class="text-success">${book.state }</td>							
									</c:when>
									<c:otherwise>
										<td class="text-danger">${book.state }</td>
									</c:otherwise>
								</c:choose>
								<td><button type="button" id="deleteBtn" class="btn btn-danger delete-btn">삭제</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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
		
		$("#deleteBtn").on("click", function(){
			alert("정상작동");
			
			let bookingId = $(this).data("booking-id");
			
			$.ajax({
					type:"get"
					, url:"/logPension/delete"
					, data:{"id", bookingId}
					, success:function(data){
						if(data.result == "success"){
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