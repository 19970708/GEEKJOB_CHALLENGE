<%-- 
    Document   : DBsousa10_delete
    Created on : 2018/08/08, 17:10:36
    Author     : hatano

以下のファイルを作成して，フォームで送信した値をもとにレコードの削除を行います。

■ HTML ファイル
大単元「データベース基礎」の課題「テーブルの作成とinsert」で作成したテーブルの profileID のカラム情報を送信するフォームを記述してください。

■ JSP or サーブレットファイル（サーブレットとJSPを連携させても構いません）
JDBC を利用して，削除処理を記述します。このとき，削除対象のレコードはフォームから受け取った profileID の値で指定してください。また，全件検索を行い，全レコードの全カラムを画面表示してください。


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

            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Data1", "hatano", "102400");//ポート番号3306ではなく8889
                db_st = db_con.prepareStatement("delete from profiles where profilesID=?");
                db_st.setInt(1, id);
                db_st.execute(); //削除実行
                out.print("削除成功"+"<br>");
               
                //削除後の表示
                db_st = db_con.prepareStatement("select * from profiles ");
                db_data = db_st.executeQuery();
                out.print("削除後"+"<br>");
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
