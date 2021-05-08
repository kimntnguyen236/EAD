/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.CameraSBLocal;
import entities.Camera;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThienKim
 */
public class CameraServlet extends HttpServlet {

    CameraSBLocal cameraSB = lookupCameraSBLocal();

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
            if (action == null) {
                request.setAttribute("list", cameraSB.findAll());
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else if (action.equals("delete")) {
                String code = request.getParameter("pcode"); // id lấy từ index.jsp chỗ delete=id....
                cameraSB.deleteCamera(code);
//                request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("CameraServlet");
            } else if (action.equals("Search")) {
                float min = Float.parseFloat(request.getParameter("min"));
                float max = Float.parseFloat(request.getParameter("max"));
                if (min < max) {
                    request.setAttribute("list", cameraSB.searchByPrice(min, max));
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
//                    request.setAttribute("list", projectSB.findAll());
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
//                    request.getRequestDispatcher("/error.html").forward(request, response);
                }
            } else if (action.equals("Create")) {
                Camera p = new Camera();
                Double price = Double.parseDouble(request.getParameter("txtPrice"));
                String id = request.getParameter("txtID");
                String name = request.getParameter("txtName");
                p.setCameraid(id);
                p.setCameraname(name);
                p.setCameraprice(price);
                if (price <= 0) {
                    System.out.println("Price must greater than 0");
                    request.getRequestDispatcher("/create.jsp").include(request, response);
                } else if (name.isEmpty()) {
                     System.out.println("Must write something");
                    request.getRequestDispatcher("/create.jsp").include(request, response);
                }  else if (id.isEmpty()) {
                     System.out.println("Must write something");
                    request.getRequestDispatcher("/create.jsp").include(request, response);
                }  else {
                    boolean res = cameraSB.createCamera(p);
                    Camera existing = cameraSB.findOne(p.getCameraid());
                    if (existing != null) {
                        request.getRequestDispatcher("/error.html").forward(request, response);
                    } else if (res == true) {
                        response.sendRedirect("CameraServlet");
                    } else {
                       request.getRequestDispatcher("/error.html").forward(request, response);
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

    private CameraSBLocal lookupCameraSBLocal() {
        try {
            Context c = new InitialContext();
            return (CameraSBLocal) c.lookup("java:global/Student1218312/Student1218312-ejb/CameraSB!bean.CameraSBLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
