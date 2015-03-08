/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GoSafe.Controller;

import com.GoSafe.Model.Area;
import com.GoSafe.Model.City;
import com.GoSafe.Model.Locality;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author anur
 */
public class LoadMapController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Integer city_id = Integer.valueOf(request.getParameter("City"));
        Integer area_id = Integer.valueOf(request.getParameter("Area"));
        Integer locality_id = Integer.valueOf(request.getParameter("Locality"));
        //System.out.println("Anuja " + city_id +" " + area_id + " " + locality_id);
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Locality  locality;
        if(locality_id !=null && locality_id>0){
            locality = (Locality)session.get(Locality.class, locality_id);
            System.out.println("Anuja values are id = " + locality.getId()+" latitude=" + locality.getLatitude() 
                    +" locality= " + locality.getLongitude() 
                    +" comments= " +locality.getComments() + " severity= " +locality.getSeverity()
                    +"area id = " +locality.getArea_id() +" city id= "+locality.getCity_id());
            request.setAttribute("latitude", locality.getLatitude());
            request.setAttribute("longitude",locality.getLongitude());
            request.setAttribute("severity", locality.getSeverity());
            request.setAttribute("comments", locality.getComments());
        }
        else{
            
        }
        
        RequestDispatcher reqDispatcher = request.getRequestDispatcher("Map.jsp");
        
        
        session.close();
        reqDispatcher.forward(request,response);
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
