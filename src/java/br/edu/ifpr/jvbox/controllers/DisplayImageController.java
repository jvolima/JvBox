/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.jvbox.controllers;

import br.edu.ifpr.jvbox.entities.Image;
import br.edu.ifpr.jvbox.models.ImageModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jvolima
 */
@WebServlet(name = "DisplayImageController", urlPatterns = {"/DisplayImageController"})
public class DisplayImageController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        ImageModel model = new ImageModel();
        
        try {
            Image img = model.findImageById(id);
            
            response.setContentType(img.getImageType());
            response.getOutputStream().write(img.getImageContent());
        } catch (SQLException ex) {
            Logger.getLogger(DisplayImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
