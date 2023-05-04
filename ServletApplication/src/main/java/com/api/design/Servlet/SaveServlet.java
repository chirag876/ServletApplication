package com.api.design.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.api.design.Entity.Country;
import com.api.design.Service.CountryService;
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
           response.setContentType("text/jsp");  
           PrintWriter out=response.getWriter();  
             
           String id=request.getParameter("id");  
           String name=request.getParameter("name");  
           String population=request.getParameter("population");  

             
           Country p=new Country();  
          
           p.setId(Integer.parseInt(id));  
           p.setName(name);
           p.setPopulation(Integer.parseInt(population));

             
           int status=CountryService.saveCountry(p);
           if(status>0){  
               out.print("<p>Record saved successfully!</p>");  
               request.getRequestDispatcher("country.jsp").include(request, response);  
           }else{  
               out.println("Sorry! unable to save record");  
           }  
             
           out.close();  
       }  
     
   }  