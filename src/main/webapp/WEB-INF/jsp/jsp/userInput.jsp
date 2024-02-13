<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 추가</title>
</head>
<body>
	
	<h3>사용자 추가</h3>
	
	<!-- web inf 안에 있는 파일은 접근 못 하도록 막아뒀음 따라서 모든 응답과 요청 처리는 Controller에서 담당 -->
	
	<form method="get" action="/jsp/user/create">
		<label>이름 : </label><input type="text" name="name"> <br>
		<label>생년월일 : </label><input type="text" name="birthday"> <br>
		<label>이메일 : </label><input type="text" name="email"> <br>
		<button type="submit">추가</button>
	</form>
	
	
</body>
</html>