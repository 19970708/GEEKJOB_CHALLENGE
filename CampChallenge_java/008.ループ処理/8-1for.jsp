<%-- 
    Document   : 8-1
    Created on : 2018/05/17, 7:50:48
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
            //for文1
            //8 の 20 乗を計算し，計算結果を表示してください。この計算は，for文によって実現してください。
            long total = 1;
            for (int i = 0; i < 20; i++) {
                total = total * 8;
            }
            out.print(total);

        %>


    </body>
</html>
