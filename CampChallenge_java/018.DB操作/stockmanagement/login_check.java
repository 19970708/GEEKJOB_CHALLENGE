/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hatano
 */
@WebServlet(name = "login_check", urlPatterns = {"/login_check"})
public class login_check extends HttpServlet {

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

            request.setCharacterEncoding("UTF-8");

            String userID = request.getParameter("userID");
            String password = request.getParameter("password");

            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Data1", "hatano", "102400");//ポート番号3306ではなく8889
                db_st = db_con.prepareStatement("select * from users where userID = ? and password=?");
                db_st.setString(1, userID);
                db_st.setString(2, password);

                db_data = db_st.executeQuery();
                if (db_data.first()) {
                    HttpSession hs = request.getSession();
                    // セッションへ登録
                    hs.setAttribute("userID_hs", db_data.getString("userID"));
                    hs.setAttribute("password_hs", db_data.getString("password"));
                    hs.setAttribute("userName_hs", db_data.getString("userName"));
                    //request.setAttribute("userName", db_data.getString("userName"));
                    RequestDispatcher rd = request.getRequestDispatcher("stockmanagement/login_success.jsp");//ログインに成功したときのページ
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("stockmanagement/login_fail.html");//ログインに失敗したときのページ
                    rd.forward(request, response);
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
