<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX 예제</title>
</head>
<body>
	
	<h2>AJAX 테스트</h2>
	
	<button type="button" id="requestBtn">요청</button>
	
	<h3 id="nameH"></h3>
	<h4 id="ageH"></h4>
	
	
	
	
	<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous"></script>
  	<script>
  		$(document).ready(function(){
  			
  			$("#requestBtn").on("click", function(){
  								
  				// /ajax/person
  				
  				$.ajax({
  					type:"get"
  					//요청할 페이지의 메소드
  					, url:"/ajax/person"
  					, data:{"name":"공밍송", "birthday":20000323}
  						//requestparameter 추가하는 옵션
  					, success:function(data){
  						// data에는 responsebody에 있는 데이터가 저장됨
  						// response는 문자열 데이터
  						// jquery가 response로 전달된 json 문자열을
  						// 자바스크립트 객체로 변환해줌
  						console.log("나이 : " + data.age);
  						
  						$("#nameH").text(data.name);
  						$("#ageH").text(data.age);
  						
  						
  					}
  						, error:function(){
  							alert("에러");
  							//에러가 발생했을 때 이 함수 통해 문제 상황 파악 가능
  						}
  						// data 는 response에 의해 전달된 responsebody 데이터를
  						// 저장하기 위한 parameter매개 변수 data 이름은 상관 없음
  						// 위의 data와는 아무런 상관이 없음
  						// response를 처리하기 위한 곳, 기능수행, 성공적으로 처리가 됐을 때
  						// 어떤 기능을 수행할 것인지 익명함수로
					
  				});
  				
  			});
  			
 
  		});
  	
  	
  	
  	
  	
  	</script>
</body>
</html>