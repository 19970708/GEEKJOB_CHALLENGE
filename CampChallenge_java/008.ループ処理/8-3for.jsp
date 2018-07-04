<%-- 
    Document   : 8-3
    Created on : 2018/05/21, 20:49:27
    Author     : hatano
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
            //変数を宣言し，その値を 0 から 100 までの合計値にしてください。そして，その変数の値を画面に表示してください。
            //このとき，変数の値は，for文を利用して， 0 から始まる数値を順番に足しこむことで得るものとします。
            
            int num=0;
            for(int i=1;i<=100;i++){
                num+=i;
            }
            out.print(num);
            
        %>
    </body>
</html>
