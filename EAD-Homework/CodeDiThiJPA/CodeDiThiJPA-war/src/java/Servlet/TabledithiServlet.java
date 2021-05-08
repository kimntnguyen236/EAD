/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.TabledithiSBLocal;
import Models.Tabledithi;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TâmHoàngMinh
 */
public class TabledithiServlet extends HttpServlet {

    @EJB
    private TabledithiSBLocal tabledithiSB;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            if (action == null) {
//                run();
                List<Tabledithi> list = tabledithiSB.findAll();
                request.setAttribute("list", list);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } 
            //Create
            else if (action.equals("Create")) {
                Tabledithi t = new Tabledithi();
                String id = request.getParameter("txtID");
                String password = request.getParameter("txtPass");
                String name = request.getParameter("txtName");
                int salary = Integer.parseInt(request.getParameter("txtSalary"));

                // gọi hàm dựng 4 tham số : Course (tạo hàm dựng 4 tham số) -> gọi ra
                t.setTablecollum1(id);
                t.setTablecollum2(password);
                t.setTablecollum3(name);
                t.setTablecollum5(salary);
                tabledithiSB.addTabledithi(t);
                
                response.sendRedirect("TabledithiServlet");
            } 
            
            //Delete
            else if (action.equals("delete")) {
               // int id = Integer.parseInt(request.getParameter("id"));
               String cid = request.getParameter("id");
               Tabledithi t = tabledithiSB.findOne(cid);
                tabledithiSB.deleteTabledithi(t);
                response.sendRedirect("TabledithiServlet");
            }
            //Detail
            else if (action.equals("details")) {
                String cid = request.getParameter("id");
                Tabledithi t = tabledithiSB.findOne(cid);
                request.setAttribute("c", t);
                request.getRequestDispatcher("details.jsp").forward(request, response);
            } 
            
            //Update
            if (action.equals("getupdate")) {
                //update page
                String cid = request.getParameter("id");
                //String cid = request.getParameter("txtID");
                request.setAttribute("c", tabledithiSB.findOne(cid)); //do bien ra jsp
                request.getRequestDispatcher("update.jsp").forward(request, response); // phai gui ca request lan response
            } 
            else if (action.equals("UpdateAccount")) {
                String cid = request.getParameter("txtID");
                String cpass = request.getParameter("txtPass");
                String cname = request.getParameter("txtName");
                int csalary = Integer.valueOf(request.getParameter("txtSalary"));
                Tabledithi t = tabledithiSB.findOne(cid);
                t.setTablecollum2(cpass);
                t.setTablecollum3(cname);
                t.setTablecollum5(csalary);
                tabledithiSB.updateTabledithi(t);
//                request.setAttribute("list", tabledithiSB.findAll());
//                request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("TabledithiServlet");
     
            } 
            
            //Chưa chạy đk Login
            else if (action.equals("Sign in")) {
                String uid = request.getParameter("txtID");
                String upass = request.getParameter("txtPass");
                if (tabledithiSB.Login(uid, upass) != null) {
                    response.sendRedirect("TabledithiServlet");
                } else {
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            } 
            
            //Search theo tên
            else if (action.equals("Search")) {
                String keyword = request.getParameter("uname"); // đặt trong phần search
                List<Tabledithi> list = tabledithiSB.findByName(keyword);
                request.setAttribute("list", list);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } 
            
            //Search theo min max
            else if (action.equals("SearchMinMax")) {
                int min = Integer.parseInt(request.getParameter("min"));
                int max = Integer.parseInt(request.getParameter("max"));
                if (min > max) {
                    out.println("Error min or max when you search");
                    request.getRequestDispatcher("error.jsp").include(request, response);
                } else {
                
                    List<Tabledithi> list = tabledithiSB.SearchMinMax(min, max);
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
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

}
