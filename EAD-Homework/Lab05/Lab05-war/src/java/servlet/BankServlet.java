/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.TransactionSBLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import entities.*;

/**
 *
 * @author ThienKim
 */
public class BankServlet extends HttpServlet {

    TransactionSBLocal transactionSB = lookupTransactionSBLocal();

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
            AccountTB accFrom = new AccountTB();
            AccountTB accTo = new AccountTB();
            String action = request.getParameter("action");
            // -------------------Login---------------------------------------
            accFrom.setAccountno(request.getParameter("txtNo"));
            accFrom.setPincode(request.getParameter("txtPincode"));
            // ------------------Tranfer--------------------------------------
            int amount = Integer.parseInt(request.getParameter("txtAmount"));
            String comment = request.getParameter("txtComment");
            String aTo = request.getParameter("txtTo");
            String aFrom = request.getParameter("txtFrom");
            
            if (action.equals("Login")) {
                if (transactionSB.checkLogin(accFrom) != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("aname", accFrom.getAccountno());
                    session.setAttribute("balance", accFrom.getBalance());
                    request.getRequestDispatcher("/transmanage.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/error.html").forward(request, response);
                }
            } else if (action.equals("Perform")) {
                if (transactionSB.tranfer(accFrom, accTo, amount, comment) == true) {
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                else{
                request.getRequestDispatcher("fail.jsp").forward(request, response);
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

    private TransactionSBLocal lookupTransactionSBLocal() {
        try {
            Context c = new InitialContext();
            return (TransactionSBLocal) c.lookup("java:global/Lab05/Lab05-ejb/TransactionSB!bean.TransactionSBLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
