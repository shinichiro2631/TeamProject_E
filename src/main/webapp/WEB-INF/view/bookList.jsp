<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書一覧</title>
</head>
<body>
    <h1>図書一覧</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>タイトル</th>
                <th>著者</th>
                <th>ISBN</th>
                <th>出版社</th>
                <th>内容</th>
                <th>冊数</th>
            </tr>
            <%

	  List<Book> list =(ArrayList<Book>)request.getAttribute("bookList");
		for(Book s : list) {%>
		<tr>
			<td><%=s.getId() %></td>
			<td><%=s.getTitle() %></td>
			<td><%=s.getAuthor()%></td>
			<td><%=s.getIsbn()%></td>
			<td><%=s.getNew_old() %></td>
			<td><%=s.getPublisher() %></td>
		</tr>
	<%} %>
	</table>
	
	<a href="./">戻る</a>
</body>
</html>
        </thead>
        
                   