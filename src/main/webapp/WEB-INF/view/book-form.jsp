<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書登録画面</title>
</head>
<body>
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
</body>
</html>