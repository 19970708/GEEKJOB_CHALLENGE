<%-- 
    Document   : session_nyuuryoku_new
    Created on : 2018/06/30, 15:52:21
    Author     : hatano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    request.setCharacterEncoding("UTF-8");
    
    HttpSession hs = request.getSession();
    
    //html内での変数用意
    String name0="";
    String sex0="";
    String hobby0="";
    
    //デフォルト用意
    //なければ空文字
    //sessionでName,Sex,Hobbyで別のファイルで登録している
    if(hs.getAttribute("Name")!=null){ 
        name0=(String)hs.getAttribute("Name");
    }
    if(hs.getAttribute("Sex")!=null) {
        sex0=(String)hs.getAttribute("Sex");
    }
    if(hs.getAttribute("Hobby")!=null) {
        hobby0=(String)hs.getAttribute("Hobby");
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./session_nyuuryoku.jsp" method="get">
            <p>
                名前:<input type="text" name="name" value="<%=name0%>"> <%--//value(値)をname0で設定--%>
            </p>
            <p>
                性別：
                男<input type="radio" name="sex" value="男"
                        <%if(sex0.equals("男")){
                            out.print("checked"); //valueが男ならチェック
                        }%> >
                女<input type="radio" name="sex"  value="女"
                        <%if(sex0.equals("女")){
                            out.print("checked");//valueが女ならチェック
                        }%> >
            </p>
            <p>
                趣味：<textarea name="hobby"><%=hobby0%></textarea>  <%--textareaにvalueはない --%>
            </p>

            <p><input type="submit" value="送信する"></p>
        </form>
    </body>
</html>
