<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core library 1</title>
</head>
<body>
	
	<h3>1. JSTL core 변수</h3>
	
	<c:set var="num1" value="36"/>
	<c:set var="num2" value="3"/>
	
	<h4>첫번째 숫자 : ${num1 }</h4>
	<h4>두번째 숫자 : ${num2 }</h4>
	
	
	
	<h3>2. JSTL core 연산</h3>
	
	<h4>더하기 : ${num1+num2 }</h4>
	<h4>빼기	 : ${num1-num2 }</h4>
	<h4>곱하기 : ${num1*num2 }</h4>
	<h4>나누기 : ${num1/num2 }</h4>
	
	
	<h3>3. JSTL core out</h3>
	<c:out value="<title>core out</title>"/>
	
	
	
	<h3>4. JSTL core if</h3>
	
	<c:set var="average" value="${(num1 + num2) / 2 }"/>
	
	<c:if test="${average >= 10 }">
		<h1>${average }</h1>
	</c:if>
	<c:if test="${average < 10 }">
		<h3>${average }</h3>
	</c:if>
	
	
	<h3>5. JSTL core if</h3>
	
	<c:if test="${(num1 * num2) > 100 }">
		<c:out value="<script>alert('너무 큰 수입니다!')</script>" escapeXml="false"/>
	</c:if>
	
	
	
	
	
	
	
	
	
	
</body>
</html>