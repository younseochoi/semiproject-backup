<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String role = request.getParameter("role");
	
	String output = "";
	if(role.equals("admin")) { %>
		<h1><%=id %> 계정의 관리자님 로그인하셨습니다 </h1>
		<ul><li> 모든 사용자 정보 조회 </li>
		<li> 블랙리스트 관리 </li>
		<li> 상품관리 </li></ul>		
	<%}
	else if(role.equals("user")) {%>
		<h1><%=id %>계정의 사용자님 로그인하셨습니다</h1>
		<ol><li> 내정보 조회 </li>
		<li> 로그아웃 </li>
		<li> 게시판 보기 </li></ol>
	<% }%>
<%=output %>
</body>
</html>