/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.CountrySBLocal;
import entities.CityTB;
import entities.CountryCity;
import entities.CountryTB;
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
public class CountryServlet extends HttpServlet {

    @EJB
    private CountrySBLocal countrySB;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void loadCName(HttpServletRequest request, HttpServletResponse response) {
        List<CountryTB> listCountry = countrySB.listCountry();
        request.setAttribute("listCountry", listCountry);
        List<CityTB> listCity = countrySB.listCityName();
        request.setAttribute("listCity", listCity);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            List<CountryCity> list = null;
            if (action == null) {
                list = countrySB.findAll();
                request.setAttribute("list", list);
                loadCName(request, response);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (action.equals("Create")) {
                String cname = request.getParameter("txtName");
                int cpop = Integer.parseInt(request.getParameter("txtPop"));
                int czip = Integer.parseInt(request.getParameter("txtZipCode"));
                String ccountry = request.getParameter("cbx");
                CityTB city = new CityTB();
                city.setCityname(cname);
                city.setPopulation(cpop);
                city.setZipcode(czip);
                city.setCountryname(ccountry);
                countrySB.createCity(city);
                response.sendRedirect("CountryServlet");
            } else if (action.equals("Filter")) {
                String cname = request.getParameter("CountryNamecbx");
                String ctname = request.getParameter("CityNamecbx");
                if (cname.equals("all")) {
                    loadCName(request, response);
                    list = countrySB.findAll();
                } 
                else if (cname.equals("ctall")) {
                    loadCName(request, response);
                    list = countrySB.findAll();
                } else {
                    loadCName(request, response);
                    list = countrySB.findByName(cname, ctname);
                }
                request.setAttribute("list", list);
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
