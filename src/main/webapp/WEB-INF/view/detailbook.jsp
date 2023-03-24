<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<tr>
				<th>図書名</th>
				<th>著者</th>
				<th>出版社</th>
				
			</tr>
			<%
    List<Book> list = (ArrayList<Book>) request.getAttribute("bookList");
    if (list != null) {
        for (Book s : list) {
%>
        <tr>
            <td><%= s.getTitle() %></td>
            <td><%= s.getAuthor() %></td>
            <td><%= s.getPublisher() %></td>
        <%} %>
        </tr>
        <%} %>
</body>
</html>