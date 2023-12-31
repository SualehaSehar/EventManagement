/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EventDao;
import Model.DateTimeUtil;
import Model.EquipmentManagement;
import Model.Event;
import Model.FoodManagement;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author Ammar
 */
public class BookingDetailsForm extends javax.swing.JPanel {
    private MainUI main;
    private String eventID;
    /**
     * Creates new form BookingDetailsForm
     */
    public BookingDetailsForm(MainUI main,String eventID) {
        this.main = main;
        initComponents();
        this.eventID = eventID; 
        txtbkID.setVisible(false);
        loadData(eventID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblimage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listfood = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listequipment = new javax.swing.JList<>();
        txtbkID = new javax.swing.JTextField();
        txteventType = new javax.swing.JTextField();
        txtvenueType = new javax.swing.JTextField();
        txtvenueName = new javax.swing.JTextField();
        txtstartDT = new javax.swing.JTextField();
        txtendDT = new javax.swing.JTextField();
        txtnoOfGuest = new javax.swing.JTextField();
        txtvenueCost = new javax.swing.JTextField();
        txtfoodCost = new javax.swing.JTextField();
        txtEquipmentCost = new javax.swing.JTextField();
        txtTotalCost = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel8.setText("Event Type");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 20));

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel9.setText("Venue");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 20));

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel10.setText("No Of Guest");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel11.setText("Equipment Items");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, -1, -1));

        jLabel12.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel12.setText("Venue Type");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 20));

        jLabel14.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel14.setText("Start Time");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel15.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel15.setText("End Time");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel16.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel16.setText("Food Items");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, 20));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel1.setText("VIEW EVENT");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 130, 50));

        lblimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lblimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 280, 230));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel3.setText("Venue Cost");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, 30));

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel4.setText("Food Cost");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, -1, 30));

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel5.setText("Equipment Cost");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, -1, 30));

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel6.setText("Total Cost");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, -1, 30));

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 80, 30));

        jScrollPane1.setViewportView(listfood);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 170, 90));

        jScrollPane2.setViewportView(listequipment);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 170, 90));
        add(txtbkID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 120, 20));

        txteventType.setEditable(false);
        add(txteventType, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 160, 30));

        txtvenueType.setEditable(false);
        add(txtvenueType, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 160, 30));

        txtvenueName.setEditable(false);
        add(txtvenueName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 180, 30));

        txtstartDT.setEditable(false);
        add(txtstartDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 160, 30));

        txtendDT.setEditable(false);
        add(txtendDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 160, 30));

        txtnoOfGuest.setEditable(false);
        add(txtnoOfGuest, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 160, 30));

        txtvenueCost.setEditable(false);
        add(txtvenueCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 150, 40));

        txtfoodCost.setEditable(false);
        add(txtfoodCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 150, 40));

        txtEquipmentCost.setEditable(false);
        add(txtEquipmentCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, 150, 40));

        txtTotalCost.setEditable(false);
        add(txtTotalCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 540, 150, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/406199-white-abstract-wallpaper.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        this.main.addComponent(new BookingsForm(this.main));
    }//GEN-LAST:event_btnbackActionPerformed
    private void loadData(String eventid){
        Event event = EventDao.readEvent(eventid);
        txtbkID.setText(event.getEventID());
        txteventType.setText(event.getEventType());
        txtvenueName.setText(event.getVenueName());
        txtvenueType.setText(event.getVenueType());
        Date startDateTime = DateTimeUtil.updateTime(event.getEventDate(), event.getStartTime());
        Date endDateTime = DateTimeUtil.updateTime(event.getEventDate(), event.getEndTime());
        txtstartDT.setText(String.valueOf(startDateTime));
        txtendDT.setText(String.valueOf(endDateTime));
        txtnoOfGuest.setText(String.valueOf(event.getNoOfGuest()));
        txtvenueCost.setText(String.valueOf(event.getVenueCost()));
        txtfoodCost.setText(String.valueOf(event.getFoodCost()));
        txtEquipmentCost.setText(String.valueOf(event.getEquipmentCost()));
        txtTotalCost.setText(String.valueOf(event.getTotalCost()));
        setFoodItems(event.getFoodItems());
        setEquipmentList(event.getEquipments());
        //lblimage.setIcon(new ImageIcon(event.getVenueImage()));
        loadImage(event.getVenueImage());
        
    }
    private void setFoodItems(ArrayList<FoodManagement> list){
        DefaultListModel<FoodManagement> foodlistModel = new DefaultListModel<>();
        for (FoodManagement fi : list) {
            foodlistModel.addElement(fi);
        }
        listfood.setModel(foodlistModel);
    }
    
    private void setEquipmentList(ArrayList<EquipmentManagement> list){
        DefaultListModel<EquipmentManagement> equiplistModel = new DefaultListModel<>();
        for (EquipmentManagement eq : list) {
            equiplistModel.addElement(eq);
        }
        listequipment.setModel(equiplistModel);
    }
    
    private void loadImage(String path) {

        if (path != null && !path.trim().equalsIgnoreCase("null") && path.trim().length() > 0) {
            try {
                BufferedImage myPicture = ImageIO.read(new File(path));
                //lblimage.setIcon(new ImageIcon(myPicture));
                lblimage.setIcon(new ImageIcon(myPicture.getScaledInstance(280, 280, 280)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblimage;
    private javax.swing.JList<EquipmentManagement> listequipment;
    private javax.swing.JList<FoodManagement> listfood;
    private javax.swing.JTextField txtEquipmentCost;
    private javax.swing.JTextField txtTotalCost;
    private javax.swing.JTextField txtbkID;
    private javax.swing.JTextField txtendDT;
    private javax.swing.JTextField txteventType;
    private javax.swing.JTextField txtfoodCost;
    private javax.swing.JTextField txtnoOfGuest;
    private javax.swing.JTextField txtstartDT;
    private javax.swing.JTextField txtvenueCost;
    private javax.swing.JTextField txtvenueName;
    private javax.swing.JTextField txtvenueType;
    // End of variables declaration//GEN-END:variables
}
