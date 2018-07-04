<%-- 
    Document   : FortunTellingResult
    Created on : 2018/05/31, 10:43:13
    Author     : hatano
--%>
<%@page import="org.camp.servlet.ResultData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%
            //リクエストスコープからインスタンスを取得
            //取得するインスタンスの型　名前　＝&nbsp　(取得するインスタンスの型)　request.getAttribute("属性名")
            ResultData data=(ResultData)request.getAttribute("Data");
        %>
            
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(data!=null){
                out.print("<h1>あなたの"+data.getD()+"運勢は、"+data.getLuck()+"です</h1>");
            }
        %>
    </body>
</html>
