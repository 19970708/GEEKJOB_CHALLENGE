<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.*" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)session.getAttribute("UDB");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%= udb.getname()%><br>
        生年月日:<%= udb.getyear()+"年"+udb.getmonth()+"月"+udb.getday()+"日"%><br>
        種別:<%= udb.gettype()%><br>
        電話番号:<%= udb.gettell()%><br>
        自己紹介:<%=udb.getcomment() %><br>
        以上の内容で登録しました。<br>
        
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
