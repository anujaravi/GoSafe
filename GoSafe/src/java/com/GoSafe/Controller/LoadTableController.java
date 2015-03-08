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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author anur
 */
@WebServlet(name = "LoadTableController", urlPatterns = {"/loadTable"})
public class LoadTableController extends HttpServlet {

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
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            //Create and insert values to City Table 
            Query query = session.createQuery("select count(*) from City");
            Long city_count = (Long)query.uniqueResult();
            if(city_count == null || city_count == 0){
                City city = new City();
                city.setId(1);
                city.setName("Chennai");
                session.save(city);
                City city1 = new City();
                city1.setId(2);
                city1.setName("New Delhi");
                session.save(city1);
            }
            
            //Create and insert values to Area Table
            query = session.createQuery("select count(*) from Area");
            Long area_count = (Long)query.uniqueResult();
            if(area_count == null || area_count == 0){
                Area area = new Area();
                area.setId(1);
                area.setCity_id(1);
                area.setName("Guindy");
                area.setLatitude(13.006708);
                area.setLongitude(80.2197411);
                session.save(area);
                
                Area area1 = new Area();
                area1.setId(2);
                area1.setCity_id(1);
                area1.setName("Thiruvanmiyur");
                area1.setLatitude(12.9837304);
                area1.setLongitude(80.2606625);
                session.save(area1);
                
                Area area2 = new Area();
                area2.setId(3);
                area2.setCity_id(2);
                area2.setName("Sarojini Nagar");
                area2.setLatitude(28.5755005);
                area2.setLongitude(77.197573);
                session.save(area2);
                
                Area area3 = new Area();
                area3.setId(4);
                area3.setCity_id(2);
                area3.setName("Chanakyapuri");
                area3.setLatitude(28.595374);
                area3.setLongitude(77.1844946);
                session.save(area3);
            }
            
            //Create and insert values to Locality Table
            query = session.createQuery("select count(*) from Locality");
            Long locality_count = (Long)query.uniqueResult();
            if(locality_count == null || locality_count == 0){
             
                Locality loc1 = new Locality();
                loc1.setId(1);
                loc1.setName("Bus Stand");
                loc1.setArea_id(1);
                loc1.setCity_id(1);
                loc1.setLatitude(13.008044);
                loc1.setLongitude(80.2092531);
                loc1.setComments("Crowed, but chain snatching and Pick Pocket complaints are very frequent");
                loc1.setPopular("False");
                loc1.setSeverity(3);
                session.save(loc1);
             
                Locality loc2 = new Locality();
                loc2.setId(2);
                loc2.setName("Railway Station");
                loc2.setArea_id(1);
                loc2.setCity_id(1);
                loc2.setLatitude(13.008357);
                loc2.setLongitude(80.212318);
                loc2.setComments("This place is safe to go");
                loc2.setPopular("False");
                loc2.setSeverity(1);
                session.save(loc2);
                
                Locality loc3 = new Locality();
                loc3.setId(3);
                loc3.setName("Bus Stand");
                loc3.setArea_id(2);
                loc3.setCity_id(1);
                loc3.setLatitude(12.9869735);
                loc3.setLongitude(80.2595622);
                loc3.setComments("Pick Pocket complaints are frequent during mid-nnon and late night timings.");
                loc3.setPopular("False");
                loc3.setSeverity(2);
                session.save(loc3);
                
                Locality loc4 = new Locality();
                loc4.setId(4);
                loc4.setName("Railway Station");
                loc4.setArea_id(2);
                loc4.setCity_id(1);
                loc4.setLatitude(12.989678);
                loc4.setLongitude(80.251386);
                loc4.setComments("This place is safe to go");
                loc4.setPopular("False");
                loc4.setSeverity(1);
                session.save(loc4);
                
                Locality loc5 = new Locality();
                loc5.setId(5);
                loc5.setName("Market");
                loc5.setArea_id(3);
                loc5.setCity_id(2);
                loc5.setLatitude(28.576907);
                loc5.setLongitude(77.196263);
                loc5.setComments("Harassement complaints have been registered behind Keshav Park");
                loc5.setPopular("False");
                loc5.setSeverity(4);
                session.save(loc5);
                
                Locality loc6 = new Locality();
                loc6.setId(6);
                loc6.setName("Railway Station");
                loc6.setArea_id(3);
                loc6.setCity_id(2);
                loc6.setLatitude(28.581112);
                loc6.setLongitude(77.196232);
                loc6.setComments("This place is safe to go");
                loc6.setPopular("False");
                loc6.setSeverity(1);
                session.save(loc6);
                
                Locality loc7 = new Locality();
                loc7.setId(7);
                loc7.setName("Railway Station");
                loc7.setArea_id(4);
                loc7.setCity_id(2);
                loc7.setLatitude(28.591632);
                loc7.setLongitude(77.171747);
                loc7.setComments("This place is safe to go");
                loc7.setPopular("False");
                loc7.setSeverity(1);
                session.save(loc7);
                
                Locality loc8 = new Locality();
                loc8.setId(8);
                loc8.setName("Yashwant Place Mall");
                loc8.setArea_id(4);
                loc8.setCity_id(2);
                loc8.setLatitude(28.584277);
                loc8.setLongitude(77.191862);
                loc8.setComments("Robbery and Harassement complaints have been registered near China Sizzlers town");
                loc8.setPopular("False");
                loc8.setSeverity(4);
                session.save(loc8);
            }
            session.getTransaction().commit();
            session.close();
        
            RequestDispatcher reqDispatcher = request.getRequestDispatcher("Home.html");
            reqDispatcher.forward(request,response);
            
           /* RequestDispatcher reqDispatcher = request.getRequestDispatcher("Home.jsp");
            Query query1 = session.createQuery("from city");
            List<City> cities = query1.list();
            request.setAttribute("cities", cities);*/
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
