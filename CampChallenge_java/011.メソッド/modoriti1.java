/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hatano
 * 以下の仕様を参考にユーザー定義メソッドを作成してください。

▼ファイル名
　Method4.java　※サーブレットで作成してください
　
▼メソッド名
　calculation

　引数：
　　なし
　
　戻り値：
　　数値型

　処理内容：
　　メソッド内で四則演算による計算をします。(計算は自由に作成して下さい)
　　計算結果を戻り値として呼び出し元へ返却します。
　　
メソッドを作成したら，処理が正しく実装されているか確認するため、
このメソッドを呼び出す処理を記述してください。

呼び出した後、受け取った値に応じて以下の条件分岐処理&表示を行って下さい。

200以上 ... 「200以上です。」と表示
100以上200未満 ... 「100以上200未満です。」と表示
100未満 ... 「100未満です。」と表示

 */
@WebServlet(name = "modoriti1", urlPatterns = {"/modoriti1"})
public class modoriti1 extends HttpServlet {
    int calculation(int num){
       return num*num; 
    }

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
            int num=calculation(4);
            if(num<100){
                out.print("100未満です。");
            }else if(num<200){
                out.print("100以上200未満です。");
            }else{
                out.print("200以上です。");
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
