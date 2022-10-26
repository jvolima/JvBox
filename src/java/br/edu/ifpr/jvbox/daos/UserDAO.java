/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.jvbox.daos;

import br.edu.ifpr.jvbox.entities.User;
import br.edu.ifpr.jvbox.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jvolima
 */
public class UserDAO {
    public void register(User u) throws SQLException {
        String sql = "INSERT INTO USERS (NAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, u.getName());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getPassword());
        
        stmt.execute();
        
        stmt.close();
        connection.close();
    }
    
    public User findUserByEmail(String email) throws SQLException {
        String sql = "SELECT ID, NAME, EMAIL, PASSWORD FROM USERS WHERE EMAIL = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        
        User u = null;
        
        if(rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            String password = rs.getString("PASSWORD");
            
            u = new User(id, name, email, password);
        }
        
        stmt.close();
        connection.close();
        rs.close();
        
        return u;
    }
} 

