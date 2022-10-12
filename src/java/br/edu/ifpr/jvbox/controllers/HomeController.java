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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jvolima
 */
@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})

public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ImageModel model = new ImageModel();
        
        String email = "";
        
        Cookie[] cookies = request.getCookies();
        
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
            
            ArrayList<Image> images = model.listAll(u.getId());
            
            request.setAttribute("images", images);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
