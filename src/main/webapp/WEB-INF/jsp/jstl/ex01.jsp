<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core library</title>
</head>
<body>
	
	<h2>JSTL core library</h2>
	
	<h3>1. 변수 만들기</h3>
	
	
	<!--  int number1 = 100;  -->
	<c:set var="number1" value="100" />
	<c:set var="number2">200</c:set>
	
	<h4>숫자1 : ${number1 }</h4>
	<h4>숫자2 : ${number2 }</h4>
	
	
	
	<h3>2. 변수 출력하기</h3>
	<h4>숫자1 : <c:out value="${number1 }"/></h4>
	<!--  <script>alert("안녕")</script> 를 화면에 출력하기 위해 -->
	
	<c:out value="<script>alert('안녕')</script>" />
	<!-- escapeXml="false" 인 경우 태그 무시, 기본값은 true -->
	<!-- <c:out value="<script>alert('안녕')</script>" escapeXml="false"/> -->
	
	<h3>3. 조건문</h3>
	
	<!--  if(true){}  -->
	<c:if test="true">
		<!-- 사이에 태그 포함시킨다면 if 조건에 따라서 화면에 표현 될 지 안 될지  -->
		<h4>조건문 결과</h4>
		
	</c:if>
	
	
	<%-- if(number1 > 50){} --%>
	<c:if test="${number1 > 50 }">
		<h4>number1 은 50보다 큽니다.</h4>
	</c:if>
	
	
	<c:if test="${number2 eq 200 }">
		<h4>number2 는 200 입니다</h4>
	</c:if>
	
	<c:if test="${number2 ne 100 }">
		<h4>number2 는 100이 아니다</h4>
	</c:if>
	
	<!-- null, 없는 변수, 리스트가 비어있거나, 맵이 비어있다 -->
	<c:if test="${empty number3 }">
		<h4>number3 는 null이거나 없는 변수이거나 리스트가 비어있거나 맵이 비어있다. </h4>
	</c:if>
	
	<c:if test="${not empty number2 }">
		<h4>number2 는 존재하는 변수이다. </h4>
	</c:if>
	
</body>
</html>