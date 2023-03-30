<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>メールフォーム</h1>
    <form method="post" action="MailSenderServlet">
        <table>
            <tr>
            	<td><input type="checkbox" name="to[]" value="user1@example.com">e.kato.sys22@morijyobi.ac.jp</td><br>
                <td><input type="checkbox" name="to[]" value="user2@example.com">user2@example.com</td><br>
                <td><input type="checkbox" name="to[]" value="user3@example.com">user3@example.com</td>
            </tr>
        </table>
       
            <input type="submit" value="送信">
    </form>
</body>
</html>
