<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書登録画面</title>
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
<div class="main">
	<div class="main-content">
	<h1>図書登録画面</h1>
	<form action="RegisterBookServlet" method="post">
		図書名:<input type="text" name="title"><br>
		著者名:<input type="text" name="author"><br>
		ISBN:<input type="text" name="isbn"><br>
		新書or旧書:<input type="radio" name="new_old" value="0">新書
				   <input type="radio" name="new_old" value="1">旧書<br>
		出版社:<input type="text" name="publisher"><br>
		冊数：<input type="text" name="count"><br>
		<input type="submit" value="登録">
	</form>
	<a href="BookListServlet">戻る</a>
</div>
</div>
</body>
</html>