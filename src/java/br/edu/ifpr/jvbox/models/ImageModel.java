/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.jvbox.models;

import br.edu.ifpr.jvbox.daos.ImageDAO;
import br.edu.ifpr.jvbox.entities.Image;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jvolima
 */
public class ImageModel {
    ImageDAO dao = new ImageDAO();
    
    public void registerImage(Image img) throws SQLException {
        dao.registerImage(img);
    }
    
    public Image findImageById(int id) throws SQLException {
        Image img = dao.findImageById(id);
        
        return img;
    }
    
    public ArrayList<Image> listAll(int id_user) throws SQLException {
        ArrayList<Image> images = dao.listAll(id_user);
        
        return images;
    }
    
    public void removeById(int id) throws SQLException {
        dao.removeById(id);
    }
}
