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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author jvolima
 */
@WebServlet(name = "UpdateImageController", urlPatterns = {"/UpdateImageController"})
@MultipartConfig(maxFileSize = 8 * 1024 * 1024 * 10/*10MB*/)
public class UpdateImageController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        
        Part part = request.getPart("image");
        String contentType = part.getContentType();
        
        byte[] image = new byte[part.getInputStream().available()];
        
        part.getInputStream().read(image);
        
        ImageModel model = new ImageModel();
                
        if (image.length > 0) {
            //passou imagem
            Image img = new Image();
            img.setId(id);
            img.setName(name);
            img.setDescription(description);
            img.setImageContent(image);
            img.setImageType(contentType);
            
            try {
                model.update(img);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateImageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //nao passou
            Image img = new Image();
            img.setId(id);
            img.setName(name);
            img.setDescription(description);
            
            try {
                model.updateWithoutChangeImage(img);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateImageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        response.sendRedirect("ImageController?id=" + id);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
