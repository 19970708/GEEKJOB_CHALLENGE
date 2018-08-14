<%-- 
    Document   : DBsousa9_insert
    Created on : 2018/08/02, 17:46:32
    Author     : hatano

以下のファイルを作成して，フォームで送信した値をもとにレコードの挿入を行います。

■ HTML ファイル
大単元「データベース基礎」の課題「テーブルの作成とinsert」で作成したテーブルの全カラム情報を送信するフォームを記述してください。

■ JSP or サーブレットファイル（サーブレットとJSPを連携させても構いません）
JDBC を利用して，フォームから受け取った値をもとに，レコードを挿入してください。また，全件検索を行い，全レコードの全カラムを画面表示してください。


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

            out.print(id + "<br>");
            out.print(name + "<br>");
            out.print(tell + "<br>");
            out.print(age + "<br>");
            out.print(Date.valueOf(day) + "<br>");  //ちゃんと書かないとエラー注意

            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Data1", "hatano", "102400");
                //挿入
                db_st = db_con.prepareStatement("INSERT INTO profiles VALUES (?, ?, ?, ?, ?);");
                db_st.setInt(1, id);
                db_st.setString(2, name);
                db_st.setString(3, tell);
                db_st.setInt(4, age);
                db_st.setDate(5, Date.valueOf(day));
                db_st.execute();
                out.print("挿入完了"+"<br>");

                //挿入後結果表示
                db_st = db_con.prepareStatement("select * from profiles ");
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
