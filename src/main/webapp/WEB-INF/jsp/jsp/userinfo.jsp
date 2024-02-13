<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title } </title>
</head>
<body>
	
	<h2>사용자 정보</h2>
	
	<table border="1">
		<tr>
			<td>id</td>
			<td>${result.id }</td>
		</tr>	
		<tr>
			<td>이름</td>
			<td>${result.name }</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${result.email }</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${result.yyyymmdd }</td>
		</tr>
	</table>
	
	
	
</body>
</html>