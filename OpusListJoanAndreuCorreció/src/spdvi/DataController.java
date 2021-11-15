/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Joan Andreu
 */
public class DataController {
    private static ArrayList<Obra> obras = new ArrayList<>();
    static boolean obrasLoaded = false;
    public static final String APP_FOLDER = System.getProperty("user.home") + "\\AppData\\Local\\OpusList\\";
    public static final String IMAGES_FOLDER = System.getProperty("user.home") + "\\AppData\\Local\\OpusList\\images\\";
    public static final String NO_IMAGE = "/spdvi/noImage.png";
    public static final java.lang.reflect.Type LIST_OF_OBRA_TYPE = new com.google.gson.reflect.TypeToken<List<Obra>>() {}.getType();
    public static final String JSON_DATA_FILE = System.getProperty("user.home") + "\\AppData\\Local\\OpusList\\data\\obres.json";
    public static final int DEFAULT_PROFILE_IMAGE_WIDTH = 96;
    public static final int DEFAULT_PROFILE_IMAGE_HEIGHT = 96;
    public static final String DEFAULT_PROFILE_IMAGE_TYPE = "jpg";
    
    private static void loadObras() {
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(JSON_DATA_FILE));
            obras = gson.fromJson(reader, LIST_OF_OBRA_TYPE);
            obrasLoaded = true;
            reader.close();
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public static void saveObras() {
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter(JSON_DATA_FILE);
            gson.toJson(obras, writer);
            writer.flush();
            writer.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public static ArrayList<Obra> getObras() {
        if (!obrasLoaded) {
            loadObras();          
        }
        return obras;
    }
    
    public static void insertObra(Obra newObra, String newProfileImageFilePath) throws Exception{
        if (!obrasContains(newObra)) {
            obras.add(newObra);
            if(!NO_IMAGE.equals(newProfileImageFilePath)) {
                File newProfileImageFile = new File(IMAGES_FOLDER + newObra.getRegistre() + "." + DEFAULT_PROFILE_IMAGE_TYPE);
                if (!newProfileImageFile.exists()) {
                    try {
                        BufferedImage profileBufferedImage = ImageIO.read(new File(newProfileImageFilePath));
                        BufferedImage resizedBufferedImage = resizeImageIcon(profileBufferedImage,
                                DEFAULT_PROFILE_IMAGE_WIDTH, DEFAULT_PROFILE_IMAGE_HEIGHT );
                        ImageIO.write(resizedBufferedImage, DEFAULT_PROFILE_IMAGE_TYPE, newProfileImageFile);
                        newObra.setImatge(newProfileImageFile.getName());
                    }
                    catch(IOException ioe) {
                        newObra.setImatge(NO_IMAGE);
                        ioe.printStackTrace();
                    }

                }
            }
            else {
                newObra.setImatge(NO_IMAGE);
            }
        }
        else
            throw new Exception("Obra " + newObra.getRegistre() + " already exists in database");
    }
    
    private static boolean obrasContains(Obra obraToCheck) {
        for (Obra o: obras) {
            if (obraToCheck.getRegistre().equals(o.getRegistre())) {
                return true;
            }
        }
        return false;
    }

    static Obra getObra(String id) {
        if (!obrasLoaded) {
            loadObras();
        }
        for (Obra o: obras) {
            if (o.getRegistre().equals(id)) {
                return o;
            }
        }
        return null;
    }
    
    static void updateObra(Obra selectedObra, String titol, String any, String format, String autor, String newProfileImageFilePath) {
        selectedObra.setTitol(titol);
        selectedObra.setAny(any);
        selectedObra.setFormat(format);
        selectedObra.setAutor(autor);

        if (newProfileImageFilePath != null) {
            File newProfileImageFile = new File(IMAGES_FOLDER + selectedObra.getRegistre() + "." + DEFAULT_PROFILE_IMAGE_TYPE);
            if (!newProfileImageFile.exists()) {
                try {
                    BufferedImage profileBufferedImage = ImageIO.read(new File(newProfileImageFilePath));
                    BufferedImage resizedBufferedImage = resizeImageIcon(profileBufferedImage,
                            DEFAULT_PROFILE_IMAGE_WIDTH, DEFAULT_PROFILE_IMAGE_HEIGHT );
                    ImageIO.write(resizedBufferedImage, DEFAULT_PROFILE_IMAGE_TYPE, newProfileImageFile);
                    selectedObra.setImatge(newProfileImageFile.getName());
                }
                catch(IOException ioe) {
                    selectedObra.setImatge(NO_IMAGE);
                    ioe.printStackTrace();
                }

            }
        }
        else {
            selectedObra.setImatge(NO_IMAGE);
        }
    }

    static void deleteObra(Obra selectedObra) {
        if (!NO_IMAGE.equals(selectedObra.getImatge())) {
            File fileToDelete = new File(IMAGES_FOLDER + selectedObra.getImatge());
            if (fileToDelete.exists()) {
                fileToDelete.delete();
            }
        }
        obras.remove(selectedObra);
        saveObras();
    }
    
    public static BufferedImage resizeImageIcon (BufferedImage originalImage, int desiredWidth, int desiredHeight) {
        int newHeight = 0;    
        int newWidth = 0;
        float aspectRatio = (float)originalImage.getWidth() / originalImage.getHeight();
        if (originalImage.getWidth() > originalImage.getHeight()) {
            newWidth = desiredWidth;
            newHeight = Math.round( desiredWidth / aspectRatio);                
        }
        else {
            newHeight = desiredHeight;
            newWidth = Math.round(desiredHeight * aspectRatio);
        }
        Image resultingImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        
        return outputImage;
    }
}

