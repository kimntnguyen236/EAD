/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import bean.ProjectSBLocal;
import bean.VisitorCountSB;
import entities.Project;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
public class ProjectManage extends HttpServlet {

    @EJB
    private VisitorCountSB visitorCountSB;

    ProjectSBLocal projectSB = lookupProjectSBLocal();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String procode = request.getParameter("txtCode");
            String proname = request.getParameter("txtName");
            if (action == null) {
                List<Project> list = projectSB.findAll();
                request.setAttribute("list", list);
                int cnt = visitorCountSB.getCounter();
                request.setAttribute("visitor", cnt);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else if (action.equals("Login")) {
                if (projectSB.checkLogin(procode, proname)== true) {
                    response.sendRedirect("ProjectManage");
                } else {
                    response.sendRedirect("error.html");
                }
            } else if (action.equals("getupdate")) {
                String pcode = request.getParameter("pcode");
                Project p = projectSB.findOne(pcode);
                request.setAttribute("p", p);
                request.getRequestDispatcher("/update.jsp").forward(request, response);
            } else if (action.equals("Update")) {
                // update project
                String code = request.getParameter("txtCode");
                int cost = Integer.parseInt(request.getParameter("txtCost"));
                projectSB.updateProject(code, cost);
                response.sendRedirect("ProjectManage");
            } else if (action.equals("delete")) {
                String code = request.getParameter("pcode"); // id lấy từ index.jsp chỗ delete=id....
                projectSB.deleteProject(code);
//                request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("ProjectManage");
            } else if (action.equals("Search")) {
                int min = Integer.parseInt(request.getParameter("min"));
                int max = Integer.parseInt(request.getParameter("max"));
                if (min < max) {
                    request.setAttribute("list", projectSB.searchByCost(min, max));
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
//                    request.setAttribute("list", projectSB.findAll());
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
//                    request.getRequestDispatcher("/error.html").forward(request, response);
                }
            } else if (action.equals("Filter")) {
                String pname = request.getParameter("txtName");
                if (pname != null) {
                    request.setAttribute("list", projectSB.search(pname));
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
//                    request.setAttribute("list", projectSB.findAll());
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
//                    request.getRequestDispatcher("/error.html").forward(request, response);
                }
            } else if (action.equals("Create")) {
                Project p = new Project();
                p.setProjectcode(request.getParameter("txtCode"));
                p.setProjectname(request.getParameter("txtName"));
                p.setDuration(request.getParameter("txtDuration"));
                p.setCost(Integer.parseInt(request.getParameter("txtCost")));
                boolean res = projectSB.save(p);
                Project existing = projectSB.findOne(p.getProjectcode());
                if (existing != null) {
                    request.getRequestDispatcher("/error.html").forward(request, response);
                } else if(res==true){
                    response.sendRedirect("ProjectManage");
                } else{
                    response.sendRedirect("ProjectManage");
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

    private ProjectSBLocal lookupProjectSBLocal() {
        try {
            Context c = new InitialContext();
            return (ProjectSBLocal) c.lookup("java:global/Lab03/Lab03-ejb/ProjectSB!bean.ProjectSBLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
