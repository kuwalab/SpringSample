<%@page contentType="text/html; charset=utf-8"%><%--
--%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>ログイン</title>
</head>
<body>
 <form action="<c:url value='auth' />" method="post">
  <table border="0">
   <tbody>
    <tr>
     <th>ユーザーID</th>
     <td><input type="text" name="userid" size="10"></td>
    </tr>
    <tr>
     <th>パスワード</th>
     <td><input type="text" name="pswd" size="10"></td>
    </tr>
   </tbody>
  </table>
  <input name="submit" type="submit" value="submit" />
 </form>
</body>
</html>
