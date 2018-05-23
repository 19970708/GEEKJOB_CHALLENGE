<%-- 
    Document   : 6-1
    Created on : 2018/05/12, 14:08:17
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
        <%@page import="java.util.ArrayList" %>
        <%
            String[] array={"10","100","soeda", "hayashi", "-20", "118", "END"};
            for(int i=0;i<7;i++){
                out.println(array[i]);
            }
        
        %>
            
    </body>
</html>
