/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.jvbox.controllers;

import br.edu.ifpr.jvbox.entities.User;
import br.edu.ifpr.jvbox.models.UserModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jvolima
 */
@WebServlet(name = "UserRegisterController", urlPatterns = {"/UserRegisterController"})
public class UserRegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/userRegister.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        User u = new User(name, email, password);
        
        UserModel model = new UserModel();
        
        try {
            model.registerUser(u);
            
            response.sendRedirect("LoginController");
        } catch (Exception ex) {
            // Erro no cadastro
            response.sendRedirect("UserRegisterController");
        } 
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
