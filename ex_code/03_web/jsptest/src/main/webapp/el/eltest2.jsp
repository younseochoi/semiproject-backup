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
<% int i = 10;
pageContext.setAttribute("ii", i);
%>
<h3>선언문=<%=i %></h3>
<h3>el=${ ii }</h3>

<hr>

${j=100 }
<h3>el=${ j }</h3>
<h3>선언문=<%=pageContext.getAttribute("j")%></h3>

</body>
</html>









