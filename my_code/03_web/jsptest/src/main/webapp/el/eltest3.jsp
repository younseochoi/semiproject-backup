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
<%if(request.getParameter("id")!=null){%>
	<%=request.getParameter("id") %> 회원님, 
	<%= request.getParameter("pw") %> 암호를 입력하셨습니다.<br>
	오늘의 점심 메뉴는<br>
	<% 
	String[] lunch = request.getParameterValues("lunch");
	for(int i =0;i<lunch.length;i++){
		out.println(lunch[i]+"<br>");
	}
	%>
<% }%>
<hr>

${empty param.id? "손님":param.id }회원님, 
${param.pw } 암호를 입력하셨습니다.<br>
오늘의 점심 메뉴는<br>
${paramValues.lunch[2]}

</body>
</html>