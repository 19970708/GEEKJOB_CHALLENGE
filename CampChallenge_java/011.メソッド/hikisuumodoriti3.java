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
//課題「引数，戻り値２」を改修します。
//整数型の変数 limit を値 2 で用意してください。そして，limit を利用して，表示するプロフィール情報を２名分のみにしてください。
/**
 *
 * @author hatano
 */
@WebServlet(name = "hikisuu3", urlPatterns = {"/hikisuu3"})
public class hikisuumodoriti3 extends HttpServlet {
    String[] array(String id){
        String[][] list={{"1","技育太郎","東京","男","プログラマー"},{"2","技育花子","北海道","女","システムエンジニア"},{"3","技育三郎","大阪","男","Webエンジニア"}};
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
            /* TODO output your page here. You may use following sample code. */
            String[] prof={"ID","名前","出身","性別","職業"};
            int limit=4;
            for(int i=1;i<4;i++){
                String[] list=array(Integer.toString(i));
                if(i>=limit){
                        break;
                    }
                for(int j=1;j<list.length;j++){
                    
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
