<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.*" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <%
        //sessionを初期化
        request.setCharacterEncoding("UTF-8");
        HttpSession hs = request.getSession();
        UserDataBeans udb = new UserDataBeans();
        udb.setname("");
        udb.setyear("");
        udb.setmonth("");
        udb.setday("");
        udb.settype("");
        udb.settell("");
        udb.setcomment("");
        hs.setAttribute("UDB", udb);
        System.out.println("Session cleared!!");
    %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JUMSトップ</title>
</head>
<body>
    <h1>ユーザー情報管理トップ</h1><br>
    <h3>ここでは、ユーザー情報管理システムとしてユーザー情報の登録や検索、
        付随して修正や削除を行うことができます</h3><br>
    <a href="insert">新規登録</a><br>
    <a href="search" >検索(修正・削除)</a><br>
</body>
</html>
