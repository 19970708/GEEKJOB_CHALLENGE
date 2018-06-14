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

//ユーザー定義メソッドを作成してください。引数・戻り値・処理内容については，以下の通りです。
//・引数　文字列型
//・戻り値　配列（ArrayList で実現してもOK）
//・処理内容
//３人分のプロフィール情報を，それぞれ配列で作成してください（プロフィール情報の項目は，課題「引数、戻り値1」と同様です）。ただし，そのうちの１人については，住所 の値を null にしてください。
//そして，引数で受け取った文字列と ID の値が一致する人物について，そのプロフィール情報の配列を戻り値としてください。

//メソッドを作成したら，このメソッドを適宜呼び出し，３人分のプロフィール情報をすべて画面に表示してください。ただし，値が null なデータについては continue; を利用して画面表示をスキップしてください。
/**
 *
 * @author hatano
 */
@WebServlet(name = "hikisuu1", urlPatterns = {"/hikisuu1"})
public class hikisuu2 extends HttpServlet {
    String[] array(String id){
        String[][] list={{"0","田中","5/1","千葉"},{"1","吉田",null,"東京"},{"2","波多野","7/8","愛知"}};
        for(String[] lis:list){
            if(lis[0].equals(id)){
                return lis;
            }
           
        }
         return null;
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
            
            String[] prof={"ID","名前","誕生日","出身"};
 
            for(int i=0;i<3;i++){
                String[] list=array(Integer.toString(i));
                for(int j=0;j<list.length;j++){
                    if(list[j]==null){
                        continue;
                    }
                    out.print(prof[j]+":"+list[j]+" ");
                }
                out.print("<br> ");
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
