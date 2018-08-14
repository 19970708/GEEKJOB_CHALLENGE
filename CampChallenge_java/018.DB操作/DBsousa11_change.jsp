<%-- 
    Document   : DBsousa11_change
    Created on : 2018/08/08, 17:33:59
    Author     : hatano

■HTMLファイル
大単元「データベース基礎」の課題「テーブルの作成とinsert」で作成したテーブルの全カラム情報を送信するフォームを記述してください。

■ JSP or サーブレットファイル（サーブレットとJSPを連携させても構いません）
JDBC を利用して，更新処理を記述します。このとき，更新対象のレコードはフォームから受け取った profilesID の値で指定してください。更新するカラムはの値は，フォームから受け取った profilesID 以外の値によって指定してください。また，全件検索を行い，全レコードの全カラムを画面表示してください

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
            
            int id = Integer.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String tell = request.getParameter("tell");
            int age = Integer.valueOf(request.getParameter("age"));
            String day = request.getParameter("day");
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Data1", "hatano", "102400");
                db_st = db_con.prepareStatement("update profiles set name=?, tel=?, age=?, birthday=? where profilesID=?");//コンマ忘れ
                db_st.setString(1, name);
                db_st.setString(2, tell);
                db_st.setInt(3, age);
                db_st.setDate(4, Date.valueOf(day));
                db_st.setInt(5, id);
                db_st.execute(); //実行

                db_st = db_con.prepareStatement("select * from profiles");
                db_data = db_st.executeQuery();
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
