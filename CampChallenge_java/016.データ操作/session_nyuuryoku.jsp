<%-- 
    Document   : session_nyuuryoku
    Created on : 2018/06/21, 17:41:08
    Author     : hatano

・名前，性別，趣味の情報をフォームによって送信することができる。 
・フォームによって値を送信すると，次回アクセス時に，その値がフォームの初期値となる（セッションかクッキーを利用する）。
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");

            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String hobby = request.getParameter("hobby");

            HttpSession hs = request.getSession();
            // セッションへ登録
            hs.setAttribute("Name", name);
            hs.setAttribute("Sex", sex);
            hs.setAttribute("Hobby", hobby);
            // セッションから情報を取得 -- 寿司
            out.print("名前:" + hs.getAttribute("Name") + "<br>");
            out.print("性別:" + hs.getAttribute("Sex") + "<br>");
            out.print("趣味:" + hs.getAttribute("Hobby") + "<br>");

        %>
    </body>
</html>
