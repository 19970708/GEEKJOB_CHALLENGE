<%-- 
    Document   : 8-2
    Created on : 2018/05/21, 7:53:54
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
            String str="";
            for(int i=0;i<30;i++){
                str+="A";
            }
            out.print(str);

        %>
    </body>
</html>
