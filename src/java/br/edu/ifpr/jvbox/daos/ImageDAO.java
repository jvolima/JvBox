/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.jvbox.daos;

import br.edu.ifpr.jvbox.entities.Image;
import br.edu.ifpr.jvbox.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
