/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;


/**
 *
 * @author DevMike
 */
public class Obra {

    public String getRegistre() {
        return registre;
    }

    public void setRegistre(String registre) {
        this.registre = registre;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAny() {
        return any;
    }

    public void setAny(String any) {
        this.any = any;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
     public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }
    
    public Obra(String registre, String titol, String any, String format, String autor, String imageFileName ) {
        this.registre = registre;
        this.titol = titol;
        this.any = any;
        this.format = format;
        this.autor = autor;
        this.pictureFileName = imageFileName;
    }
    
    private String registre;
    private String titol;
    private String any;
    private String format;
    private String autor;
    private String pictureFileName;
    private String oldPictureFileName;
    private BufferedImage picture;
    
    public BufferedImage getPicture() {
        return picture;
    }

    public void setPicture(BufferedImage picture) {
        this.picture = picture;
    }
    
    private boolean pictureModified = false;

    public String getOldPictureFileName() {
        return oldPictureFileName;
    }

    public void setOldPictureFileName(String oldPictureFileName) {
        this.oldPictureFileName = oldPictureFileName;
    }
    
    
    public boolean isPictureModified() {
        return pictureModified;
    }

    public void setPictureModified(boolean pictureModified) {
        this.pictureModified = pictureModified;
    }

    @Override
    public String toString() {
        StringBuilder strObra = new StringBuilder();
        strObra.append(this.registre + ", " + this.titol + ", " + this.any + ", " + this.format + ", " + this.autor);
        strObra.append(pictureFileName);        
        strObra.append(System.lineSeparator());
        return strObra.toString();
    }
    
    
}
