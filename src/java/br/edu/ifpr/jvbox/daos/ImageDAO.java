/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.jvbox.daos;

import br.edu.ifpr.jvbox.entities.Image;
import br.edu.ifpr.jvbox.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jvolima
 */
public class ImageDAO {
    public void registerImage(Image img) throws SQLException {
       String sql = "INSERT INTO IMAGES (NAME, DESCRIPTION, IMAGE_TYPE, IMAGE_CONTENT, ID_USER) VALUES (?, ?, ?, ?, ?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, img.getName());
        stmt.setString(2, img.getDescription());
        stmt.setString(3, img.getImageType());
        stmt.setBytes(4, img.getImageContent());
        stmt.setInt(5, img.getIdUser());
        
        stmt.execute();
        
        stmt.close();
        connection.close(); 
    }
    
    public Image findImageById(int id) throws SQLException {
        String sql = "SELECT ID, NAME, DESCRIPTION, IMAGE_TYPE, IMAGE_CONTENT, ID_USER FROM IMAGES WHERE ID = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        Image img = null;
        
        if(rs.next()) {
            String name = rs.getString("NAME");
            String description = rs.getString("DESCRIPTION");
            String imageType = rs.getString("IMAGE_TYPE");
            byte[] imageContent = rs.getBytes("IMAGE_CONTENT");
            int idUser = rs.getInt("ID_USER");
            
            img = new Image(id, name, description, imageType, imageContent, idUser);
        }
        
        return img;
    }
    
    public ArrayList<Image> listAll() throws SQLException {
        String sql = "SELECT ID, NAME, DESCRIPTION, IMAGE_TYPE, IMAGE_CONTENT, ID_USER FROM IMAGES";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Image> images = new ArrayList();
        
        while(rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            String description = rs.getString("DESCRIPTION");
            String imageType = rs.getString("IMAGE_TYPE");
            byte[] imageContent = rs.getBytes("IMAGE_CONTENT");
            int idUser = rs.getInt("ID_USER");
            
            Image img = new Image(id, name, description, imageType, imageContent, idUser);
            
            images.add(img);
        }
        
        return images;
    }
}
