/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.jvbox.models;

import br.edu.ifpr.jvbox.daos.ImageDAO;
import br.edu.ifpr.jvbox.entities.Image;
import java.sql.SQLException;

/**
 *
 * @author jvolima
 */
public class ImageModel {
    ImageDAO dao = new ImageDAO();
    
    public void registerImage(Image img) throws SQLException {
        dao.registerImage(img);
    }
}
