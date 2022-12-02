/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.jvbox.controllers;

import br.edu.ifpr.jvbox.entities.User;
import br.edu.ifpr.jvbox.models.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
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
import br.edu.ifpr.jvbox.errors.Error;

/**
 *
 * @author jvolima
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
@MultipartConfig()
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserModel model = new UserModel();

        try {
            User user = model.findUserByEmail(email);

            if (user != null && user.getPassword().equals(password)) {

                HttpSession session = request.getSession(true);
                session.setAttribute("authenticated", user.getEmail());

                Cookie cookie = new Cookie("keepLogged", user.getEmail());
                cookie.setMaxAge(60 * 60 * 24 * 30); //calculo referente a 30 dias
                response.addCookie(cookie);
                
                Gson gsonParser = new Gson();
                PrintWriter out = response.getWriter();
                
                out.print(gsonParser.toJson(user));
            } else {
                Gson gsonParser = new Gson();
                PrintWriter out = response.getWriter();
                out.print(gsonParser.toJson(new Error(403, "Email ou senha incorretos.")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
