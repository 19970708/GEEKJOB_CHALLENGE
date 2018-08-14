<%-- 
    Document   : information
    Created on : 2018/08/14, 19:29:32
    Author     : hatano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            HttpSession hs = request.getSession();
            String userID = (String) hs.getAttribute("userID_hs");
            String password = (String) hs.getAttribute("password_hs");
            String userName = (String)hs.getAttribute("userName_hs");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>お客様情報</h1>
        <% 
            out.print(userName + "さんのカート<br>");
        
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Data1", "hatano", "102400");//ポート番号3306ではなく8889
                db_st = db_con.prepareStatement("select * from stok where userID = ? ");
                db_st.setString(1, userID);
                db_data = db_st.executeQuery();
                
                while (db_data.next()) {
                    out.print("<br>");
                    out.print("商品名：" + db_data.getString("name") + "<br>");
                    out.print("値段：" + db_data.getInt("price") + "円<br>");
                    out.print("個数：" + db_data.getInt("number") + "<br>");
                }

                db_data.close();
                db_st.close();
                db_con.close();

            } catch (SQLException e_sql) {
                out.println("接続時にエラーが発生しました： " + e_sql.toString());
            } catch (Exception e) {
                out.println("接続時にエラーが発生しました： " + e.toString());
            } finally {
                if (db_con != null) {
                    try {
                        db_con.close();
                    } catch (Exception e_con) {
                        System.out.println(e_con.getMessage());
                    }
                }
            }
        %>
    </body>
</html>
