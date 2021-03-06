/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package spdvi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;

/**
 *
 * @author Joan Andreu
 */
public class MainForm extends javax.swing.JFrame {
    ArrayList<Obra> obres = new ArrayList<Obra>();
    final static String fileName = "C:\\Users\\Joan Andreu\\AppData\\Local\\OpusList\\data\\obres.json";
    final static String imagesFolder = System.getProperty("user.home") + "\\AppData\\Local\\OpusList\\images";
    final static String noPictureFileName = "noImage.png";
    public String oldPictureFileName;
    public JFileChooser fchObraImageChooser;
    public boolean confirmSave = false;
    public JList<Obra> lstObres;
    public boolean dataChanged = false;
    public static final java.lang.reflect.Type LIST_OF_OBRA_TYPE = new TypeToken<List<Obra>>() {}.getType();
    private final String OPUS_DIR = System.getProperty("user.home") + "\\AppData\\Local\\OpusList\\data\\obres.json";
    private final String OPUS_FILE = "obres.json";
     /*
     * Creates new form Obres
     */
    public MainForm() {
        initComponents();
        lstObres = new JList<Obra>();
        jScrollPane2.setViewportView(lstObres);
        lstObres.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsersValueChanged(evt);
            }
        });
        fchObraImageChooser = new JFileChooser();
//        String noImageFileString = getClass().getClassLoader().getResourceAsStream("/images/" + noPictureFileName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLoadImage = new javax.swing.JButton();
        lblObraImage = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuMenu = new javax.swing.JMenu();
        mniInsert = new javax.swing.JMenuItem();
        mniUpdate = new javax.swing.JMenuItem();
        mniDelete = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLoadImage.setText("Load Image");
        btnLoadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadImageActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        mnuMenu.setText("Menu");

        mniInsert.setText("Insert New Opus");
        mniInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniInsertActionPerformed(evt);
            }
        });
        mnuMenu.add(mniInsert);

        mniUpdate.setText("Update Opus");
        mniUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUpdateActionPerformed(evt);
            }
        });
        mnuMenu.add(mniUpdate);

        mniDelete.setText("Delete Opus");
        mniDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDeleteActionPerformed(evt);
            }
        });
        mnuMenu.add(mniDelete);

        jMenuBar1.add(mnuMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnLoadImage))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblObraImage, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLoad)
                        .addGap(91, 91, 91)
                        .addComponent(btnSave))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblObraImage, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoadImage)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnLoad))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean isConfirmSave() {
        return confirmSave;
    }

    public void setConfirmSave(boolean confirmSave) {
        this.confirmSave = confirmSave;
    }
    
    private void mniInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniInsertActionPerformed
        InsertDialog insert = new InsertDialog(this, true);
        insert.setVisible(true);
    }//GEN-LAST:event_mniInsertActionPerformed

    private void mniUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUpdateActionPerformed
        UpdateDialog update = new UpdateDialog(this, true);
        update.setVisible(true);
    }//GEN-LAST:event_mniUpdateActionPerformed

    private void mniDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDeleteActionPerformed
        DeleteDialog delete = new DeleteDialog(this, true);
        delete.setVisible(true);
    }//GEN-LAST:event_mniDeleteActionPerformed

    private void btnLoadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadImageActionPerformed
        int result = fchObraImageChooser.showOpenDialog(this);
        BufferedImage originalImage = null;
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage bufferedImage = ImageIO.read(new File(fchObraImageChooser.getSelectedFile().getAbsolutePath()));
                ImageIcon icon = resizeImageIcon(bufferedImage, lblObraImage.getWidth(), lblObraImage.getHeight());
                lblObraImage.setIcon(icon);
                for (Obra u: obres) {
                    if (u.getRegistre().equals(u.getRegistre()))
                    u.setPictureModified(true);
                    u.setOldPictureFileName(u.getPictureFileName());
                    String fileName = fchObraImageChooser.getSelectedFile().getName();
                    String extension = fileName.substring(fileName.lastIndexOf('.')+1);
                    u.setPictureFileName(u.getRegistre() + "." + extension);
                    u.setPicture(bufferedImage);
                }
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnLoadImageActionPerformed
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        ConfirmSaveDialog saveDialog = new ConfirmSaveDialog(this, true);
        saveDialog.setVisible(true);
        
        if (this.confirmSave) {
            SaveToFile();
            dataChanged = false;
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void populateList() {
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.home") + "\\AppData\\Local\\OpusList\\data\\obres.json"));
            obres = gson.fromJson(reader, LIST_OF_OBRA_TYPE);
                    
            UpdateObraListView();
            
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
    
    void UpdateObraListView() {
    try{
        DefaultListModel<Obra> obresListModel = new DefaultListModel<Obra>();
        for(Obra u: obres) {
            obresListModel.addElement(u);
        }
        lstObres.setModel(obresListModel);      
    } catch (Exception e){
        
    }
            }
    
    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
         populateList();
    }//GEN-LAST:event_btnLoadActionPerformed
    
    private void SaveToFile() {
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for(Obra u: obres) {
                String obresString = u.getRegistre() + "," + u.getTitol() + "," + u.getAny() + "," + u.getFormat() + ", " + u.getAutor()+ System.lineSeparator();
                writer.append(obresString);
               
                if (u.isPictureModified()) {
                    File oldImageFile = new File(imagesFolder + u.getOldPictureFileName());
                    if (oldImageFile.exists()) {
                        oldImageFile.delete();
                    }

                    ImageIO.write(u.getPicture(), "jpg", new File(imagesFolder + u.getPictureFileName()));
                    
                    u.setPictureModified(false);
                }
            }
            writer.close();
                   
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }       
    }
    
    private boolean isImageInArrayList (File image, ArrayList<File> images) {
        for (File f: images) {
            if (f.getName().equals(image.getName())) {
                return true;
            }
        }
        return false;
    }
    
    private void lstUsersValueChanged(javax.swing.event.ListSelectionEvent evt) {
        MainForm mf = new MainForm();
        Obra selectedObra = lstObres.getSelectedValue();
        if (selectedObra != null) {
            for (Obra u: mf.obres) {
                    try {
                        BufferedImage bufferedImage;
                        if (u.getPictureFileName().equals(noPictureFileName)) {
                           String noImageFileString = getClass().getResource(imagesFolder + noPictureFileName).toString();
                           bufferedImage = ImageIO.read(getClass().getResource(imagesFolder + noPictureFileName)); 
                        }
                        else {
                            bufferedImage = ImageIO.read(new File(imagesFolder + u.getPictureFileName()));
                        }
                        ImageIcon icon = resizeImageIcon(bufferedImage, lblObraImage.getWidth(), lblObraImage.getHeight());
                        lblObraImage.setIcon(icon);
                    }
                    catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }            
        }
    
        
    private ImageIcon resizeImageIcon (BufferedImage originalImage, int desiredWidth, int desiredHeight) {
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
        ImageIcon imageIcon = new ImageIcon(outputImage);
        return imageIcon;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnLoadImage;
    private javax.swing.JButton btnSave;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblObraImage;
    private javax.swing.JMenuItem mniDelete;
    private javax.swing.JMenuItem mniInsert;
    private javax.swing.JMenuItem mniUpdate;
    private javax.swing.JMenu mnuMenu;
    // End of variables declaration//GEN-END:variables

}
