/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.jvbox.models;

import br.edu.ifpr.jvbox.daos.UserDAO;
import br.edu.ifpr.jvbox.entities.User;
import java.sql.SQLException;

/**
 *
 * @author jvolima
 */
public class UserModel {
    UserDAO dao = new UserDAO();
    
    public User registerUser(User u) throws SQLException, Exception {
        User userAlreadyExists = dao.findUserByEmail(u.getEmail());
            
        if (userAlreadyExists != null) {
            return userAlreadyExists;
        } else {
            dao.register(u);
            
            return null;
        }   
    }
    
    public User findUserByEmail(String email) throws SQLException {
        User u = dao.findUserByEmail(email);
        
        return u;
    }
}
