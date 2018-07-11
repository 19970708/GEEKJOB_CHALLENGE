/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

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
@WebServlet(name = "Main2", urlPatterns = {"/Main2"})
public class Main2 extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Black Jack</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>BLACK JACK</h1>");
            out.println("</body>");
            out.println("</html>");
            
            //インスタンス生成
            User user = new User();
            Dealer dealer = new Dealer();
            
            //dealer user 共に２枚のカードをセット
            dealer.setCard(dealer.deal());
            user.setCard(dealer.deal());
            
            //17以上になるまで引き続ける
            while(dealer.checkSum()){
                dealer.setCard(dealer.hit());
            }
            while(user.checkSum()){
                user.setCard(dealer.hit());
            }
            
            //user dealer の合計値
            int userSum=user.open();
            int dealerSum=dealer.open();
            
            out.print("プレーヤー合計:" +userSum+ "   ("+user.myCards+")<br>");
            out.print("ディーラー合計:" +dealerSum+ "    ("+dealer.myCards+")<br>");
            out.print("<br>");
            
            if(userSum>21 && dealerSum>21){
                out.println("両者失格のため引き分け<br>");
            }else if(userSum==21 && dealerSum==21){
                out.println("プレーヤーの勝利<br>");
            }else if(dealerSum>21){
                    out.println("プレーヤーの勝利<br>");
            }else if(userSum>21){
                    out.println("ディーラーの勝利<br>");
            }else if(userSum<dealerSum){
                    out.println("ディーラーの勝利<br>");
            }else if(userSum>dealerSum){
                    out.println("プレーヤーの勝利<br>");
            }else{
                    out.println("引き分け<br>");
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
