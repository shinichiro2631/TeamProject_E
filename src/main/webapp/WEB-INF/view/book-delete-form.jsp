<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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