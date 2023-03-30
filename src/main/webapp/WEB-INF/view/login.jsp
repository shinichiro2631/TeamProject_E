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
<div class="main">
	<div class="main-content">
	<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){	
	%>
		<p style="color:red">ログイン失敗</p>
	<form action="LoginServlet" method="post">
		【メールアドレスとＰＷを入力してください。】<br>
		メールアドレス：<input type="text" name="mail" value="<%=request.getParameter("mail") %>"><br>
		ＰＷ：<input type="password" name="pw"><br>
		<input type="submit" value="ログイン">
	</form>
	<%
		} else {
	%>
	<form action="LoginServlet" method="post">
		【メールアドレスとＰＷを入力してください。】<br>
		メールアドレス：<input type="text" name="mail"><br>
		ＰＷ：<input type="password" name="pw"><br>
		<input type="submit" value="ログイン">
	</form>
	<%
		}
	%>
</div>
</div>
</body>
</html>