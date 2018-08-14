<%-- 
    Document   : login_success
    Created on : 2018/08/08, 23:36:27
    Author     : hatano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%

            //String userName = (String) request.getAttribute("userName");
            HttpSession hs = request.getSession();
            //String userID = (String) hs.getAttribute("userID_hs");
            //String password = (String) hs.getAttribute("password_hs");
            String userName = (String) hs.getAttribute("userName_hs");
        %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ログイン成功</h1>
        <%
            out.print("ようこそ" + userName + "さん<br>");
        %>

        <a href="http://localhost:8080/jdbc2/stockmanagement/information.jsp">登録情報</a>
        <% out.print("<br>");%>
        <a href="http://localhost:8080/jdbc2/stockmanagement/add_stock.html">商品を追加</a>
    </body>
</html>
