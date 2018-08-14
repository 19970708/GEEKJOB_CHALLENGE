/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

JDBC を利用して，挿入処理を記述します。
大単元「データベース基礎」の課題「テーブルの作成とinsert」で作成したテーブルについて，自由なレコードを挿入してください。

 */
package DBsousa;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author hatano
 */
@WebServlet(name = "DBsousa2_insert", urlPatterns = {"/DBsousa2_insert"})
public class DBsousa2_insert extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Connection db_con = null;
            PreparedStatement db_st = null;
          //  ResultSet db_data = null;
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Data1", "hatano", "102400");//ポート番号3306ではなく8889
                db_st = db_con.prepareStatement("INSERT INTO profiles VALUES (?, ?, ?, ?, ?);");
                db_st.setInt(1, 6);
                db_st.setString(2, "吉田太郎");
                db_st.setString(3,"012-345-6788");
                db_st.setInt(4, 43);
                db_st.setDate(5, Date.valueOf("1994-02-01"));
                
                //db_st.close();いらん
                db_st.execute(); //実行
                db_con.close();
                out.print("挿入完了");

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
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
