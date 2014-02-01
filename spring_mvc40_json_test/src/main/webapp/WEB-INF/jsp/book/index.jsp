<%@page contentType="text/html; charset=utf-8" %><%--
--%><!DOCTYPE html>
<html>
 <head>
  <meta charset="utf-8">
  <title>書籍情報</title>
 </head>
 <body>
  <table>
   <thead>
    <tr>
     <th><input type="text" size="3" placeholder="id" id="insBookId"></th>
     <th><input type="text" size="20" placeholder="書名" id="insBookName"></th>
     <th><input type="text" size="5" placeholder="価格" id="insPrice"></th>
     <th><input type="button" value="追加" id="insert"></th>
    </tr>
   </thead>
   <tbody>
   </tbody>
  </table>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js"></script>
  <script src="js/book.js"></script>
 </body>
</html>
