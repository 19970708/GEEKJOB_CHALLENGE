<%-- 
    Document   : datasousa2
    Created on : 2018/06/20, 10:34:53
    Author     : hatano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%-- 
課題「入力フィールド」で作成した HTML のフォームから値を送信し，サーブレットか JSP で受け取ってください。また，受け取った値を画面に表示してください。
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          request.setCharacterEncoding("UTF-8");
          out.print("名前:"+request.getParameter("name")+"<br>");
          out.print("性別:"+request.getParameter("sex")+"<br>");
          out.print("趣味:"+request.getParameter("hobby")+"<br>");
        %>
    </body>
</html>
