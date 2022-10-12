/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.jvbox.entities;

/**
 *
 * @author jvolima
 */
public class Image {
    private int id;
    private String name;
    private String description;
    private String imageType;
    private byte[] imageContent;
    private int idUser;
    
    public Image(int id, String name, String description, String imageType, byte[] imageContent, int idUser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageType = imageType;
        this.imageContent = imageContent;
        this.idUser = idUser;
    }
    
    public Image(String name, String description, String imageType, byte[] imageContent, int idUser) {
        this.name = name;
        this.description = description;
        this.imageType = imageType;
        this.imageContent = imageContent;
        this.idUser = idUser;
    }
    
    public Image() {
        
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public String getImageType() {
        return imageType;
    }

    public byte[] getImageContent() {
        return imageContent;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public void setImageContent(byte[] imageContent) {
        this.imageContent = imageContent;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
