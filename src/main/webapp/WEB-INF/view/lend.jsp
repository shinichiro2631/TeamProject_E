<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
本の貸出<br>
<form action="HistoryServlet" method="post">
利用するユーザーのID
<input type="text" name="Account"><br>
図書ID
<input type="text" name="Book"><br>
<input type="submit" value="貸出">
</form>
</body>
</html>