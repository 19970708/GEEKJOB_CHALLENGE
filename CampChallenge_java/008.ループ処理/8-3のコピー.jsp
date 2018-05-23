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
            int num=0;
            for(int i=1;i<=100;i++){
                num+=i;
            }
            out.print(num);
            
        %>
    </body>
</html>
