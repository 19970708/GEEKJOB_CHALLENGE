<%-- 
    Document   : DBsousa12_kennsaku
    Created on : 2018/08/08, 17:56:29
    Author     : hatano

■ HTML ファイル 
大単元「データベース基礎」の課題「テーブルの作成とinsert」で作成したテーブルの名前・年齢・誕生日情報を送信するフォームを記述してください。 

■ JSP or サーブレットファイル（サーブレットとJSPを連携させても構いません） 
JDBC を利用して，複合検索処理を記述します。AND検索とするか，OR検索とするかは，自由に決めて構いません。

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");

            String name = request.getParameter("name");
            int age = Integer.valueOf(request.getParameter("age"));
            String day = request.getParameter("day");

            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Data1", "hatano", "102400");
                db_st = db_con.prepareStatement("select * from profiles where name=? and age=? and birthday=? ");//and
                db_st.setString(1, name);
                db_st.setInt(2, age);
                db_st.setDate(3, Date.valueOf(day));

                db_data = db_st.executeQuery();
                
                //データを表示
                //データがない場合は？
                while (db_data.next()) {
                    out.print("ID：" + db_data.getInt("profilesID") + "<br>");
                    out.print("名前：" + db_data.getString("name") + "<br>");
                    out.print("電話番号：" + db_data.getString("tel") + "<br>");
                    out.print("年齢：" + db_data.getString("age") + "<br>");
                    out.print("誕生日：" + db_data.getDate("birthday") + "<br>" + "<br>");
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
