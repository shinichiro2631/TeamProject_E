<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			Account ac = (Account)session.getAttribute("input_data");
	%>
		<p style="color:red">登録に失敗しました。</p>
		<h3>新規会員登録</h3>
		<form action="RegisterConfirmServlet" method="post">
			名前：<input type="text" name="name" value="<%=ac.getName()%>"><br>
			ユーザー名：<input type="text" name="user_name" value="<%=ac.getUser_name()%>"><br>
			電話番号：<input type="tel" name="tel" value="<%=ac.getTel() %>"><br>
			メールアドレス：<input type="email" name="mail" value="<%=ac.getMail()%>"><br>
			パスワード：<input type="password" name="pw"><br>
			パスワード再入力：<input type="password" id="confirm_password" name="confirm_password" required>
			<input type="submit" value="登録">
		</form>
	<%
		} else {
	%>
		<h3>新規会員登録</h3>
		<form action="RegisterConfirmServlet" method="post">
			名前：<input type="text" name="name"><br>
			ユーザー名：<input type="text" name="user_name"><br>
			電話番号：<input type="tel" name="tel"><br>
			メールアドレス：<input type="email" name="mail"><br>
			パスワード：<input type="password" name="pw"><br>
			パスワード再入力：<input type="password" id="confirm_password" name="confirm_password" required>
			<input type="submit" value="登録">
		</form>
		<%
			}
		%>
</body>
</html>