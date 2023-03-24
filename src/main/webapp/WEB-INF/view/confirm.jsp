<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
		Account account = (Account)session.getAttribute("input_data");
	%>
	名前：<%=account.getName() %><br>
	ユーザー名：<%=account.getUser_name() %><br>
	電話番号：<%=account.getTel() %><br>
	メールアドレス：<%=account.getMail() %><br>
	パスワード：********<br>
	パスワード再入力：********<br>
	<a href="RegisterExecuteServlet">OK</a><br>
	<a href="RegisterFormServlet">戻る</a>
</body>
</html>