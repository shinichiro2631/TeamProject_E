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
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<header>
		<main>

			<div class="ham">

				<!--ボタン-->
				<input id="check" type="checkbox" class="checkbox-bottun"> <label
					for="check"> <span></span>
				<!--上--> <span></span>
				<!--真ん中--> <span></span>
				<!--下-->
				</label>
				<!--ボタン終-->
				<!--ナビメニュー-->
				<nav class="ham_menu">
					<ul>
						<li><a href="index.jsp" class="menu">ＴＯＰ</a></li>
						<li><a href="BookFormServlet" class="menu">図書新規登録</a></li>
						<li><a href="" class="menu">図書内容変更</a></li>
						<li><a href="lend.jsp" class="menu">図書貸出</a></li>
						<li><a href="" class="menu">図書返却</a></li>
						<li><a href="" class="menu">貸出・返却履歴</a></li>
						<li><a href="" class="menu">延滞者一覧</a></li>
						<li><a href="ReviewListServlet" class="menu">本の口コミ</a></li>
						<li><a href="BookDeleteFormServlet" class="menu">図書消去</a></li>
					</ul>
				</nav>
				<!--ナビメニュー終-->

			</div>

		</main>
		<a href="index.jsp"><div class="logo">図書管理システム</div></a>
		<div class="buttons">
			<a class="button" href="LogoutServlet">ログアウト</a>
		</div>
	</header>
	<%
		request.setCharacterEncoding("UTF-8");
		Account ac = (Account)session.getAttribute("user");
		Book bk = (Book)request.getAttribute("book");
		List<Review> rvlist = (ArrayList<Review>)request.getAttribute("reviewlist");
	%>
	<div class="main">
	<div class="main-content">
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
		<%for(Review rv : rvlist){%>
			<tr><td><%=rv.getUser_name()%></td></tr>
			<tr><td><%=rv.getBook_review() %></td></tr>
		<%}%>
		</table>
	</div>
	</div>
</body>
</html>