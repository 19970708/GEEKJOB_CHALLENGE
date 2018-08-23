<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.*" %>
<%@page import="java.util.*" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("UDB");
    ArrayList<String> list = udb.getlist();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <% if (udb.check(list)) {%>
        <h1>登録確認</h1>
        名前:<%= udb.getname()%><br>
        生年月日:<%= udb.getyear() + "年" + udb.getmonth() + "月" + udb.getday() + "日"%><br>
        種別:<%= udb.gettype()%><br>
        電話番号:<%= udb.gettell()%><br>
        自己紹介:<%= udb.getcomment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
        <% } else { %>
        <h1><%out.print(udb.print(list));%></h1>
        <% }%>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>


