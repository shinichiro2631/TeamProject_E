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
	<a href="LoginFormServlet">Login</a>
	<a href="RegisterFormServlet">Register</a>
	<h1>図書一覧</h1>
	<table border="1">
	
	<form method="GET" action="SearchServlet">
  <input type="text" name="bookname" placeholder="図書名を入力">
  <input type="submit"></input>
</form>

			<tr>
				<th>図書名</th>
			</tr>
			<%
    List<Book> list = (ArrayList<Book>) request.getAttribute("bookList");
    if (list != null) {
        for (Book s : list) {
%>
        <tr>
            <td><%= s.getTitle() %></td><a href="WEB-INF/view/detailbook.jsp">詳しく見る</a>
        </tr>
<%
        }
    }
%>
			
	</table>
	<a href="./">戻る</a>



</body>
</html>