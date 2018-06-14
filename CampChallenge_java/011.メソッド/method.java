/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

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
public class method extends HttpServlet {
    void myprofile(PrintWriter pw){
            pw.print("私の名前は波多野です<br>");
            pw.print("7/8生まれです<br>");
            pw.print("大学生です<br>");
            pw.print("<br>");
    }
    void guuki(int num,PrintWriter pw2){
        if(num%2==0){
            pw2.print(num+"は偶数です");
        }else{
            pw2.print(num+"は奇数です");
        }
        pw2.print("<br>");
        pw2.print("<br>");
    }
    void method2(int a,int b,boolean ans,PrintWriter pw3){
        if(ans==true){
            pw3.print("trueです。結果は"+a*a*b*b);
        }else{
            pw3.print("falseです。結果は"+a*b);
        }
        pw3.print("<br>");
        pw3.print("<br>");
    }
    void method2(int b,PrintWriter pw3){
        method2(5,b,false,pw3);
    }
    
    boolean method3(PrintWriter pw){
        pw.print("私の名前は波多野です<br>");
        pw.print("7/8生まれです<br>");
        pw.print("大学生です<br>");
        pw.print("<br>");
        return true;
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
            /* TODO output your page here. You may use following sample code. */
            for(int i=0;i<10;i++){
                myprofile(out);
            }
            
            guuki(2,out);
            
            method2(3,2,false,out);
            
            method2(3,out);
            
            if(method3(out)){
                out.print("正しく実行できました。");
            }else{
                out.print("正しく実行できませんでした。");
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
