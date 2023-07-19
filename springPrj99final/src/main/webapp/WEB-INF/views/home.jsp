<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1 style="text-align: center;">홈페이지</h1>

	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<main>
			<h1>홈페이지</h1>
			
			<h3>날씨정보</h3>
			
			<table border="1">
				<thead>
					<tr>
						<th>날짜</th>
						<th>시각</th>
						<th>카테고리</th>
						<th>지역</th>
						<th>값</th>
					</tr>
				</thead>
				<c:forEach items="${data}" var="data">
					<tbody>
						<tr>
							<td>${data.baseDate}</td>
							<td>${data.baseTime}</td>
							<td>${data.category}</td>
							<td>${data.nx} . ${data.ny}</td>
							<td>${data.obsrValue}</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</main>
	</div>

	<script>
		// 날씨 정보를 받아오기
		$.ajax({
			url : "${root}/api/weather",
			method : "GET",
			data : {},
			dataType : "json",
			success : function(x){
				alert("good");
				console.log(x);
				
				//받아온 정보로 table 채우기
				const tbody = document.querySelector("tbody");
				tbody.innerHTML = 		  "<tr>"
										+ "<td>" + x.response.body.items.item[0].baseDate + "</td>"
										+ "<td>" + "</td>"
										+ "<td>" + " </td>"
										+ "<td>" + "</td>"
										+ "<td>" + "</td>"
								   		+ "</tr>";
								   
			},
			error : function(x){
				alert("bad");
				console.log(x);
			},
		});
		
		
		//미세머지 관련
		function checkMircoDustInfo() {
			$.ajax({
				url : "/app/api/dust",
				type : "get",
				dataType : "json",
				success : function(data) {
					alert("미세먼지 조회 성공!!!");
					console.log(data);
				},
				error : function() {
					alert("미세먼지 조회 실패...");					
				},
				
				
			});
			
		}
	
	</script>
	
</body>
</html>