/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.CompanySBLocal;
import entities.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThienKim
 */
public class CompanyServlet extends HttpServlet {

    @EJB
    private CompanySBLocal companySB;

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
            String action = request.getParameter("action");
            response.sendRedirect("/login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String id = request.getParameter("txtID");
        String password = request.getParameter("txtPass");
        StaffTB staff = companySB.checkLogin(id, password);
        List<VCompany> list = companySB.findAll();
        if (staff != null) {
            if (staff.getRole() == true) {
                request.setAttribute("list", list);
                request.getRequestDispatcher("Admin/index.jsp").forward(request, response);
            } else {
                request.setAttribute("staff", staff);
                request.getRequestDispatcher("/details.jsp").forward(request, response);
            }
        } else{
            System.out.println("Staff not found...");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
