<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			int ac = (int)session.getAttribute("input_id");
	%>
		<p style="color:red">削除に失敗しました。</p>
		<h3>図書削除</h3>
		<form action="BookDeleteServlet" method="post">
			ID：<input type="number" name="no" value="<%=ac%>"><br>
			<input type="submit" value="送信">
		</form>
	<%
		} else {
	%>
		<h3>図書削除</h3>
		<form action="BookDeleteServlet" method="post">
			ID：<input type="text" name="no" ><br>
		<input type="submit" value="送信">
		</form>
	<%
		}
	%>
	<a href="./">戻る</a>
</body>
</html>