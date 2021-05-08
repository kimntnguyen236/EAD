/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.PatientSBLocal;
import entities.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThienKim
 */
public class PatientServlet extends HttpServlet {

    @EJB
    private PatientSBLocal patientSB;

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
                List<Patient> list = patientSB.findAll();
                request.setAttribute("list", list);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (action.equals("CreateNew")) {
                Patient patient = new Patient();
                String name = request.getParameter("txtName");
                String address = request.getParameter("txtAddress");
                String redate = request.getParameter("txtDate");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(redate);
//                Date date = new Date();
                String status = request.getParameter("cbStatus");
                if (status.equalsIgnoreCase("true")) {
                    status = "true";
                } else {
                    status = "false";
                }
                boolean st = Boolean.parseBoolean(status);
                patient.setName(name);
                patient.setAddress(address);
                patient.setJoindate(date);
                patient.setStatus(st);
                if (patientSB.addPatient(patient)==true) {
                    response.sendRedirect("PatientServlet");
                } else {
                    request.getRequestDispatcher("eror.html").forward(request, response);
                }
            } 
//            else if (action.equals("Create")) {
                //                Patient patient = new Patient();
                //                String name = request.getParameter("txtName");
                //                String address = request.getParameter("txtAddress");
                //                String pattern = "MM/dd/yyyy";
                //                DateFormat df = new SimpleDateFormat(pattern);
                //                Date today = Calendar.getInstance().getTime();
                //                Date joindate = today;
                //                boolean status = Boolean.parseBoolean(request.getParameter("txtStatus"));
                //
                //                patient.setName(name);
                //                patient.setAddress(address);
                //                patient.setJoindate(joindate);
                //                patient.setStatus(status);
                //                patientSB.addPatient(patient);
                //                response.sendRedirect("PatientServlet");
                //            } 
                else if (action.equals("Delete")) {
                int pid = Integer.parseInt(request.getParameter("id"));
                patientSB.deletePatient(pid);
                response.sendRedirect("PatientServlet");
            } else if (action.equals("Details")) {
                int pid = Integer.parseInt(request.getParameter("id"));
                Patient patient = patientSB.findOne(pid);
                request.setAttribute("patient", patient);
                request.getRequestDispatcher("details.jsp").forward(request, response);
            }
//            else if (action.equals("Update")) {
//                // Update Page 
//                String pid = request.getParameter("id");
//                request.setAttribute("patient", patientSB.findOne(pid));
//                request.getRequestDispatcher("update.jsp").forward(request, response);
//            } else if (action.equals("UpdatePatient")) {
//                int pid = Integer.parseInt(request.getParameter("txtID"));
//                String pname = request.getParameter("txtName");
//                String paddress = request.getParameter("txtAddress");
////                Date pdate = request.getParameter("txtDate");
//                boolean pstatus = Boolean.parseBoolean(request.getParameter("txtStatus"));
//                Patient patient = new Patient();
//                patient.setId(pid);
//                patient.setName(pname);
//                patient.setAddress(paddress);
////                patient.setJoindate(joindate);
//                patient.setStatus(pstatus);
//                patientSB.updatePatient(patient);
//                response.sendRedirect("PatientServlet");
//            }
            }catch (ParseException ex) {
            Logger.getLogger(PatientServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
