<%-- 
    Document   : 6-2
    Created on : 2018/05/12, 17:24:31
    Author     : hatano
--%>
//配列の変更

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String[] array={"10","100","soeda", "hayashi", "-20", "118", "END"};
            array[2]="33";
            for(int i=0;i<7;i++){
                out.println(array[i]);
            }
        
        %>
    </body>
</html>
