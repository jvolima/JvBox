/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.jvbox.controllers;

import br.edu.ifpr.jvbox.entities.Image;
import br.edu.ifpr.jvbox.entities.User;
import br.edu.ifpr.jvbox.models.ImageModel;
import br.edu.ifpr.jvbox.models.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author jvolima
 */
@WebServlet(name = "AddImageController", urlPatterns = {"/AddImageController"})
@MultipartConfig(maxFileSize = 8 * 1024 * 1024 * 10/*10MB*/)
public class AddImageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        
        Part part = request.getPart("image");
        String contentType = part.getContentType();
        
        byte[] image = new byte[part.getInputStream().available()];
        
        part.getInputStream().read(image);
        
        Cookie[] cookies = request.getCookies();
        
        String email = "";
        
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if ("keepLogged".equals(cookie.getName())) {
                    email = cookie.getValue();
                }
            }
        }
        
        UserModel userModel = new UserModel();
        
        try {
            User u = userModel.findUserByEmail(email);
            
            Image img = new Image(name, description, contentType, image, u.getId());
            
            ImageModel imgModel = new ImageModel();
            imgModel.registerImage(img);
            
            response.sendRedirect("HomeController");
        } catch (SQLException ex) {
            Logger.getLogger(AddImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
