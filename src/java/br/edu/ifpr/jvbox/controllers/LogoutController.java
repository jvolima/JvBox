/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.jvbox.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jvolima
 */
@WebServlet(name = "LogoutController", urlPatterns = {"/LogoutController"})
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        session.invalidate();
        
        Cookie[] cookies = request.getCookies();
        
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("keepLogged")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        
        response.sendRedirect("LoginController");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
