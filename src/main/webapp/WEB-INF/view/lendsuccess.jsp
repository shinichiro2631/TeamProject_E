<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dto.Book"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
図書を貸出しました。<br>
<%
		Book book = (Book)session.getAttribute("input_dataB");
	%>
	<%=book.getTitle() %>の貸出が完了しました。<br>
</body>
</html>