<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Book"%>
    
<%@ page import="dto.Account" %>
<%ArrayList<Book> bookList = (ArrayList<Book>)request.getAttribute("bookList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<header>
		<main>

			<div class="ham">

				<!--ボタン-->
				<input id="check" type="checkbox" class="checkbox-bottun"> <label
					for="check"> <span></span> <!--上--> <span></span> <!--真ん中-->
					<span></span> <!--下-->
				</label>
				<!--ボタン終-->
				<!--ナビメニュー-->
				<nav class="ham_menu">
					<ul>
						<li><a href="BookListServlet" class="menu">ＴＯＰ</a></li>
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
</div>
		<a href="BookListServlet"><div class="logo">図書管理システム</div></a>
	<%
		Account ac = (Account)session.getAttribute("user");
	%>
	<p>ようこそ<%=ac.getName() %>さん</p>
	</header>
	<a href="MailSenderServlet">メール送信</a>
	<h3>図書一覧</h3>
	<!--図書検索機能-->
	<form method="get" action="SearchServlet">
    <input type="text" name="keyword" value="">
    <input type="submit" value="検索">
	</form>
		
	<table border="1">


		<tr>
			<th>図書名</th>
		</tr>
		<%
		List<Book> list = (ArrayList<Book>) request.getAttribute("bookList");
		if (list != null) {
			for (Book s : list) {
		%>
		<tr>
			<td><%=s.getTitle()%><a class="kuwasiku" href="">詳しく見る</a></td>
		</tr>
		<%
		}
		}
		%>

	</table>
	
</body>
</html>