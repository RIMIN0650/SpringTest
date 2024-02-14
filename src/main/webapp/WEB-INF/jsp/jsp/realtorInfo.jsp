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
  
<title>출력 결과</title>
</head>
<body>

	
	<table class="table text-center">
		<thead>
			<tr>
				<th>공인중개사 정보</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>id</td>
				<td>${result.id }</td>
			<tr>
			<tr>
				<td>상호명</td>
				<td>${result.office }</td>
			<tr>
			<tr>
				<td>전화 번호</td>
				<td>${result.phoneNumber }</td>
			<tr>
			<tr>
				<td>주소</td>
				<td>${result.address }</td>
			<tr>
			<tr>
				<td>등급</td>
				<td>${result.grade }</td>
			<tr>
		</tbody>
	</table>
	
	
	
	
</body>
</html>