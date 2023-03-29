<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<form method="GET" action="SearchServlet">
			<input type="text" name="bookname" placeholder="図書名を入力"> <input
				type="submit"></input>
		</form>
		<tr>
			<th>ID</th>
			<th>図書名</th>
			<th>著者名</th>
			<th>ISBN</th>
			<th>新本・旧本</th>
			<th>出版社</th>
		</tr>
		<%
		List<Book> list = (ArrayList<Book>) request.getAttribute("bookList");
		if (list != null) {
			for (Book s : list) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getTitle()%></td>
			<td><%=s.getAuthor()%></td>
			<td><%=s.getIsbn()%></td>
			<td><%=s.getNew_old()%></td>
			<td><%=s.getPublisher()%></td>
		</tr>
		<%
		}
		}
		%>

	</table>


</body>
</html>