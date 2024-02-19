<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보 페이지</title>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/jstl/css/style.css" type="text/css">
</head>
<body>
	
	<div id="wrap">
		<section id="section" class="d-flex">
			<div id="menu" class="w-25 bg-info bg-info">
				<div id="logo" class=" d-flex justify-content-center align-items-center">
					<img  width="40" height="40" src="https://cdn.pixabay.com/photo/2017/02/15/00/48/logo-2067396_640.png"> <div class="text-white">&emsp;기상청</div>
				</div>
				<nav class="main-menu navbar">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link main-link text-white" href="#"><b>날씨</b></a></li>
						<li class="nav-item"><a class="nav-link main-link text-white" href="#"><b>날씨입력</b></a></li>
						<li class="nav-item"><a class="nav-link main-link text-white" href="#"><b>테마날씨</b></a></li>
						<li class="nav-item"><a class="nav-link main-link text-white" href="#"><b>관측기후</b></a></li>
					</ul>
				</nav>
			</div>
			<div id="list" class="w-75">
				<h3 class="mt-3 ml-3">과거 날씨</h3>
				<div>
				<table id="table" class="table text-center ml-3" style="width:95%">
					<thead>
						<tr>
							<th>날짜</th>
							<th>날씨</th>
							<th>기온</th>
							<th>강수량</th>
							<th>미세먼지</th>
							<th>풍속</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${weather }">
							<tr>

								<td><fmt:formatDate value="${list.date }" pattern="yyyy년 M월 d일"/></td>
								<c:choose>
									<c:when test="${list.weather eq '맑음' }">
										<td><img src="http://marondal.com/material/images/dulumary/web/jstl/sunny.jpg"></td>
									</c:when>
									<c:when test="${list.weather eq '구름조금' }">
										<td><img src="http://marondal.com/material/images/dulumary/web/jstl/partlyCloudy.jpg"></td>
									</c:when>
									<c:when test="${list.weather eq '흐림' }">
										<td><img src="http://marondal.com/material/images/dulumary/web/jstl/cloudy.jpg"></td>
									</c:when>
									<c:when test="${list.weather eq '비' }">
										<td><img src="http://marondal.com/material/images/dulumary/web/jstl/rainy.jpg"></td>
									</c:when>
									<c:otherwise>
										${list.weather }
									</c:otherwise>
								</c:choose>

								<td>${list.temperatures }℃</td>
								<td>${list.precipitation }mm</td>
								<td>${list.microDust }</td>
								<td>${list.windSpeed }km/h</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
			</div>
		</section>
		
		<footer id="footer" class="d-flex">
			<div id="copyLogo" class="d-flex justify-contetn-center align-items-center w-25 ml-3 mt-3">
				<img width="80" height="80" src="https://cdn.pixabay.com/photo/2017/02/15/00/48/logo-2067396_640.png">
				<h3 class="ml-5">기상청</h3>
			</div>
			<div id="copyright" class="w-75 d-flex align-items-center">
				<div class="text-secondary ml-3 ">
				서울 (07062) 서울특별시 동작구 여의대방로16길 61<br><br>
				전화 (02)2181-0900, (042)481-7500 (평일 9:00~18:00, 평일 18:00 이후 및 야간휴일은 131기상콜센터 연결)<br>
				Copyright@2022 KMA. All Rights RESERVED. 전자우편(웹사이트 관련 문의): webmasterkma@korea.kr</div>
			</div>
		</footer>
		
	
	</div>
	
	
	
	
	
	
	

		
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
	
	
</body>
</html>