<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Review" %>
<%@ page import="dto.Book" %>
<%@ page import="dto.Account" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本の口コミ</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		Account ac = (Account)session.getAttribute("user");
		Book bk = (Book)request.getAttribute("book");
		List<Review> rvlist = (ArrayList<Review>)request.getAttribute("reviewlist");
		List<Account> aclist = (ArrayList<Account>)request.getAttribute("accountlist");
	%>
	<div>
	<div>
		<table>
			<tr>
			<td>図書名</td><td><%=bk.getTitle() %></td>
			</tr>
			<tr>
			<td>著者</td><td><%=bk.getAuthor() %></td>
			</tr>
			<tr>
			<td>出版社</td><td><%=bk.getPublisher() %></td>
			</tr>
		</table>
	<%if(ac != null ){%>
		<form action="RegisterReviewExecuteServlet?isbn=<%=bk.getIsbn() %>" method="post">
		<textarea name="text" placeholder="コメント" maxlength="512"></textarea>
		<input type="submit" value="書き込む">
		</form>
	<%}%>
		<table>
		<%for(Account a : aclist){ 
			for(Review rv : rvlist){%>
			<tr><td><%=a.getUser_name()%></td></tr>
			<tr><td><%=rv.getBook_review() %></td></tr>
		<% 	}
		  }%>
		</table>
	</div>
	</div>
</body>
</html>