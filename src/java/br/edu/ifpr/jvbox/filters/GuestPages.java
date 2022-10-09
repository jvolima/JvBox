/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package br.edu.ifpr.jvbox.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jvolima
 */
@WebFilter(filterName = "GuestPages", 
        servletNames = { "LoginController", "UserRegisterController" })
public class GuestPages implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("authenticated") != null) {  
            response.sendRedirect("HomeController");
        } else {
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie: cookies) {
                    if ("keepLogged".equals(cookie.getName())) {
                        String email = cookie.getValue();
                                             
                        session = request.getSession(true);
                        session.setAttribute("authenticated", email);
                     
                        request.getRequestDispatcher("HomeController").forward(req, res);
                        break;
                    }
                }
            }
            
            chain.doFilter(req, res);
        }
    }
}