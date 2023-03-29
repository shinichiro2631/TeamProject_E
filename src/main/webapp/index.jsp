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
<link rel="stylesheet" type="text/css" href="style.css">
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
						<li><a href="" class="menu">メニュー1</a></li>
						<li><a href="" class="menu">メニュー2</a></li>
						<li><a href="" class="menu">メニュー3</a></li>
					</ul>
				</nav>
				<!--ナビメニュー終-->

			</div>

		</main>
		<a href="index.jsp"><div class="logo">図書管理システム</div></a>
		<div class="buttons">
			<a class="button" href="LoginFormServlet">ログイン</a> <a class="button2"
				href="RegisterFormServlet">新規登録</a>
		</div>
	</header>


	<a href="MailSenderServlet">メール送信</a>
	<h1>図書一覧</h1>
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
<a href="BookListServlet">試し</a>




</body>
</html>