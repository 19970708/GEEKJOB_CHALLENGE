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
 */
@WebServlet(name = "method", urlPatterns = {"/method"})
public class hikisuu1and2 extends HttpServlet {

    //引数１
    //引数：
    //第一引数　数値型
    //第二引数　PrintWriter 型 
    //第一引数で得た値が偶数か奇数かを条件判断し，そのどちらであるかを画面に表示します。
    void judge(int num, PrintWriter pw2) {
        if (num % 2 == 0) {
            pw2.print(num + "は偶数です");
        } else {
            pw2.print(num + "は奇数です");
        }
        pw2.print("<br>");
        pw2.print("<br>");
    }

    //引数２
    //引数：
    //第一引数　数値型 
    //第二引数　数値型 
    //　第三引数　boolean 型 
    //　第四引数　PrintWriter型 
    //処理内容 ：
    //　最終的に実行させたいメソッドです。
    //　このメソッドは，【引数を4つ受け取って】掛け算を行います。
    //第一引数と第二引数を掛け算し，第三引数の値が true であるときにかぎって，掛け算の結果をさらに２乗します。
    //また，計算結果の値を画面に表示処理します
    
    void multiplication(int a, int b, boolean ans, PrintWriter pw3) {
        if (ans == true) {
            pw3.print("trueです。結果は" + a * a * b * b);
        } else {
            pw3.print("falseです。結果は" + a * b);
        }
        pw3.print("<br>");
        pw3.print("<br>");
    }

    //デフォルト値
    void multiplication(boolean ans, PrintWriter pw3) {
        multiplication(2, 3, ans, pw3);
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

            //引数１
            judge(2, out);

            //引数２
            multiplication(3, 2, false, out);

            //デフォルト値
            multiplication(true, out);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> hikisuu1and2.
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
     * Handles the HTTP <code>POST</code> hikisuu1and2.
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
