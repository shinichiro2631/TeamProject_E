<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Arrears" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		List<Arrears> arlist = (ArrayList<Arrears>)request.getAttribute("arrearslist");
	%>
	<div class="main">
	<div class="main-content">
		<h1>延滞者一覧</h1>
		<table>
			<tr><th>選択</th><th>名前</th><th>図書ID</th><th>図書名</th><th>貸出日</th><th>返却期日</th></tr>
			<%for(Arrears a : arlist){%>
						<tr>
						<td></td><td><%=a.getName() %></td><td><%=a.getBook_id() %></td>
						<td><%=a.getTitle() %></td><td><%=a.getLoan_date() %></td>
						<td><%=a.getDue_date() %></td>
						</tr>
			<%
			}	%>
		</table>
	</div>
	</div>
</body>
</html>