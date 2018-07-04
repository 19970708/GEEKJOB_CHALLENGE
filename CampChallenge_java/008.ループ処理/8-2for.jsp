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
            //文字列型の変数を宣言してください。その後，反復処理を使い，
            //「 A が 30 文字続いたもの」としてください（"AAAAA...AA" といった状態）。
            //そして，変数の値を画面に表示してください。
            //このとき，変数の値は，一度に 30 文字の "A" を代入するのではなく，for文を利用して 1 文字ずつ文字列連結して得ます。
            //また，画面表示は，処理の最後にただ一度だけ行うものとします。
            String str="";
            for(int i=0;i<30;i++){
                str+="A";
            }
            out.print(str);

        %>
    </body>
</html>
