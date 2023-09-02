/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EquipmentManagementDao;
import Controller.EventDao;
import Controller.FoodManagementDao;
import Controller.VenueManagementDao;
import Model.DateTimeUtil;
import Model.EquipmentManagement;
import Model.Event;
import Model.FoodManagement;
import Model.VenueManagement;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Ammar
 */
public class EventForm extends javax.swing.JPanel {
    private MainUI main;
    private String imagePath;
    private double foodCost = 0;
    private double equipmentCost = 0;
    private double venueCost = 0;
    private double totalCost = 0;
    
    
    /**
     * Creates new form EventForm
     */
    public EventForm(MainUI main) {
        this.main = main;
        //initComponents();
        initComponent();

    }
    private void initComponent(){
        jLabel1 = new javax.swing.JLabel();
        lblimage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtVenueCost = new javax.swing.JTextField();
        txtFoodCost = new javax.swing.JTextField();
        txtEquipmentCost = new javax.swing.JTextField();
        txtTotalCost = new javax.swing.JTextField();
        btnbook = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtbkID = new javax.swing.JTextField();
        cmbEventType = new javax.swing.JComboBox<>();
        cmbStartTime = new javax.swing.JComboBox<>();
        cmbVenueType = new javax.swing.JComboBox<>();
        cmbDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        cmbVenue = new javax.swing.JComboBox<VenueManagement>();
        cmbEndTime = new javax.swing.JComboBox<>();
        txtNoOfGuest = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listfood = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listequipment = new javax.swing.JList<>();
        btnback = new javax.swing.JButton();
        lblicon = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel1.setText("BOOK EVENT");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 150, 50));

        lblimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lblimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 280, 230));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel3.setText("Venue Cost");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, -1, 40));

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel4.setText("Food Cost");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, -1, 30));

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel5.setText("Equipment Cost");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, -1, 30));

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel6.setText("Total Cost");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 550, 90, 20));

        txtVenueCost.setEditable(false);
        add(txtVenueCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 150, 40));

        txtFoodCost.setEditable(false);
        add(txtFoodCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 150, 40));

        txtEquipmentCost.setEditable(false);
        add(txtEquipmentCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, 150, 40));

        txtTotalCost.setEditable(false);
        add(txtTotalCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 540, 150, 40));

        btnbook.setText("Book");
        btnbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbookActionPerformed(evt);
            }
        });
        add(btnbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 620, 80, 30));

        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 620, 80, 30));

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel8.setText("Event Type");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 20));

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel9.setText("Venue");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, 20));

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel10.setText("No Of Guest");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel11.setText("Equipment Items");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, -1, -1));

        jLabel12.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel12.setText("Venue Type");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, 20));

        jLabel13.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel13.setText("Event Date");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 248, -1, 30));

        jLabel14.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel14.setText("Start Time");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 298, -1, 30));

        jLabel15.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel15.setText("End Time");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));
        add(txtbkID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 120, 20));
        txtbkID.setVisible(false);

        cmbEventType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select One---", "Wedding", "Birthday Party", "Family Event", "Conference", "Theme Party", "School Function", "Other", " " }));
        add(cmbEventType, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 170, 30));

        cmbStartTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select One---", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", " ", " ", " ", " ", " " }));
        add(cmbStartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 170, 30));

        cmbVenueType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select One---", "Indoor", "Open Air", " ", " " }));
        add(cmbVenueType, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 170, 30));
        add(cmbDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 170, 30));

        jLabel16.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel16.setText("Food Items");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 20));

        cmbVenue.setBackground(new java.awt.Color(255, 255, 204));
        cmbVenue.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        for (VenueManagement vm : VenueManagementDao.readVenue()) {
            cmbVenue.addItem(vm);
        }
        cmbVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVenueActionPerformed(evt);
            }
        });
        add(cmbVenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 190, 30));

        cmbEndTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select One---", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        add(cmbEndTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 170, 30));

        txtNoOfGuest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoOfGuestKeyReleased(evt);
            }
        });
        add(txtNoOfGuest, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 170, 30));

        //jlist food
        listfood.setBackground(new java.awt.Color(255, 255, 204));
        listfood.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        DefaultListModel<FoodManagement> listfoodModel = new DefaultListModel<>();
        for (FoodManagement fi : FoodManagementDao.readFood()) {
            listfoodModel.addElement(fi);
        }
        listfood.setModel(listfoodModel);
        listfood.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        listfood.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listfoodValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listfood);
        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 170, 90));

        //jlist equipment
        listequipment.setBackground(new java.awt.Color(255, 255, 204));
        listequipment.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        DefaultListModel<EquipmentManagement> listequipmentModel = new DefaultListModel<>();
        for (EquipmentManagement em : EquipmentManagementDao.readEquipment()) {
            listequipmentModel.addElement(em);
        }
        listequipment.setModel(listequipmentModel);
        jScrollPane2.setViewportView(listequipment);
        
        listequipment.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listequipmentValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listequipment);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 170, 90));


        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 80, 30));

        lblicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/406199-white-abstract-wallpaper.jpg"))); // NOI18N
        lblicon.setText("jLabel2");
        add(lblicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));
    
    
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblimage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtVenueCost = new javax.swing.JTextField();
        txtFoodCost = new javax.swing.JTextField();
        txtEquipmentCost = new javax.swing.JTextField();
        txtTotalCost = new javax.swing.JTextField();
        btnbook = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtbkID = new javax.swing.JTextField();
        cmbEventType = new javax.swing.JComboBox<>();
        cmbStartTime = new javax.swing.JComboBox<>();
        cmbVenueType = new javax.swing.JComboBox<>();
        cmbDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        cmbVenue = new javax.swing.JComboBox<>();
        cmbEndTime = new javax.swing.JComboBox<>();
        txtNoOfGuest = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listfood = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listequipment = new javax.swing.JList<>();
        btnback = new javax.swing.JButton();
        lblicon = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel1.setText("BOOK EVENT");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 150, 50));

        lblimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lblimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 280, 230));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel3.setText("Venue Cost");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, -1, 40));

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel4.setText("Food Cost");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, -1, 30));

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel5.setText("Equipment Cost");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, -1, 30));

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel6.setText("Total Cost");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 550, 90, 20));

        txtVenueCost.setEditable(false);
        add(txtVenueCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 150, 40));

        txtFoodCost.setEditable(false);
        add(txtFoodCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 150, 40));

        txtEquipmentCost.setEditable(false);
        add(txtEquipmentCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, 150, 40));

        txtTotalCost.setEditable(false);
        add(txtTotalCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 540, 150, 40));

        btnbook.setText("Book");
        btnbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbookActionPerformed(evt);
            }
        });
        add(btnbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 620, 80, 30));

        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 620, 80, 30));

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel8.setText("Event Type");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 20));

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel9.setText("Venue");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, 20));

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel10.setText("No Of Guest");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel11.setText("Equipment Items");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, -1, -1));

        jLabel12.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel12.setText("Venue Type");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, 20));

        jLabel13.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel13.setText("Event Date");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 248, -1, 30));

        jLabel14.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel14.setText("Start Time");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 298, -1, 30));

        jLabel15.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel15.setText("End Time");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));
        add(txtbkID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 120, 20));

        cmbEventType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select One---", "Wedding", "Birthday Party", "Family Event", "Conference", "Theme Party", "School Function", "Other", " " }));
        add(cmbEventType, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 170, 30));

        cmbStartTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select One---", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", " ", " ", " ", " ", " " }));
        add(cmbStartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 170, 30));

        cmbVenueType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select One---", "Indoor", "Open Air", " ", " " }));
        add(cmbVenueType, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 170, 30));
        add(cmbDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 170, 30));

        jLabel16.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel16.setText("Food Items");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 20));

        cmbVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVenueActionPerformed(evt);
            }
        });
        add(cmbVenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 190, 30));

        cmbEndTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select One---", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        add(cmbEndTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 170, 30));

        txtNoOfGuest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoOfGuestKeyReleased(evt);
            }
        });
        add(txtNoOfGuest, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 170, 30));

        listfood.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listfoodValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listfood);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 170, 90));

        listequipment.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listequipmentValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listequipment);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 170, 90));

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 80, 30));

        lblicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/406199-white-abstract-wallpaper.jpg"))); // NOI18N
        lblicon.setText("jLabel2");
        add(lblicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        this.main.addComponent(new HomePageForm(this.main));     
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        resetField();
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbookActionPerformed
        // TODO add your handling code here:
        if(validateFields()) bookEvent();
    }//GEN-LAST:event_btnbookActionPerformed

    private void cmbVenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVenueActionPerformed
        // TODO add your handling code here:
        VenueManagement venueObj = (VenueManagement) cmbVenue.getSelectedItem();
        venueCost = venueObj.getVenueCost();
        txtVenueCost.setText(String.valueOf(venueCost));
        imagePath = venueObj.getVenueImage();
        loadImage(imagePath);
        setTotalCost();
    }//GEN-LAST:event_cmbVenueActionPerformed

    private void txtNoOfGuestKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoOfGuestKeyReleased
        // TODO add your handling code here:
        setFoodCost();
        setTotalCost();
    }//GEN-LAST:event_txtNoOfGuestKeyReleased

    private void listfoodValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listfoodValueChanged
        // TODO add your handling code here:
        setFoodCost();
        setTotalCost();
    }//GEN-LAST:event_listfoodValueChanged

    private void listequipmentValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listequipmentValueChanged
        // TODO add your handling code here:
        double cost=0.0;
        List<EquipmentManagement> list = listequipment.getSelectedValuesList();
        ArrayList<EquipmentManagement> equipments = new ArrayList<EquipmentManagement>(list);
        for(EquipmentManagement em: equipments){ 
            cost = cost + em.getEquipmentCost();
        }
        txtEquipmentCost.setText(String.valueOf(cost));
        equipmentCost=cost;
        setTotalCost();
    }//GEN-LAST:event_listequipmentValueChanged
    
    private void bookEvent(){
        String eventID = UUID.randomUUID().toString();
        String eventType = (String) cmbEventType.getSelectedItem();
        String personID = LoginForm.getPersonID();
        VenueManagement venueObj = (VenueManagement) cmbVenue.getSelectedItem();
        String venueType = (String) cmbVenueType.getSelectedItem();
        Date eventDate =  cmbDateChooser.getDate();
        String startTime = (String) cmbStartTime.getSelectedItem();
        String endTime = (String) cmbEndTime.getSelectedItem();
        int noOfGuest = Integer.parseInt(txtNoOfGuest.getText());
        //convert list into arraylist
        List<FoodManagement> list1 = listfood.getSelectedValuesList();
        ArrayList<FoodManagement> foodItems = new ArrayList<FoodManagement>(list1);
        
        List<EquipmentManagement> list2 = listequipment.getSelectedValuesList();
        ArrayList<EquipmentManagement> equipments = new ArrayList<EquipmentManagement>(list2);
        //adding fd and eq in database
        for(FoodManagement fm: foodItems){
            EventDao.addEventFood(eventID, fm.getFoodId());
        }
        for(EquipmentManagement em: equipments){ 
            EventDao.addEventEquipment(eventID, em.getEquipmentId());
        }
        //date + time
        Date startDateTime = DateTimeUtil.updateTime(cmbDateChooser.getDate(), (String) cmbStartTime.getSelectedItem());
        
        Date endDateTime = DateTimeUtil.updateTime(cmbDateChooser.getDate(), (String) cmbEndTime.getSelectedItem());
        
        Event event = new Event (eventID,personID,eventType, venueObj.getVenueID(), venueObj.getVenueName(), venueType,eventDate, 
           startTime,endTime, noOfGuest, foodItems , equipments, venueObj.getVenueImage(), venueCost, foodCost, 
                   equipmentCost, totalCost,startDateTime, endDateTime);
        EventDao.addEvent(event);
        JOptionPane.showMessageDialog(EventForm.this, "Event is successfully booked....");
    }
    
    private void setFoodCost() {
        double cost=0.0;
        List<FoodManagement> list = listfood.getSelectedValuesList();
        ArrayList<FoodManagement> foodItems = new ArrayList<FoodManagement>(list);
        for(FoodManagement fm: foodItems){
            cost = cost + fm.getFoodCost();
        }
        if (!txtNoOfGuest.getText().trim().isEmpty()) {
            cost = Integer.parseInt(txtNoOfGuest.getText())*cost;
        }
        txtFoodCost.setText(String.valueOf(cost));
        foodCost=cost;
    }
    
    private void setTotalCost() {
        if (foodCost !=0.0 && equipmentCost !=0.0 && venueCost!=0.0) {
            totalCost = venueCost + equipmentCost + foodCost; 
            txtTotalCost.setText(String.valueOf(totalCost));
        }
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
    
    private boolean validateFields() {
        if (cmbEventType.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(EventForm.this, "Select Event type");
            return false;
        } 
        else if (cmbVenue.getSelectedIndex() == 0 && txtVenueCost.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(EventForm.this, "Select Venue");
            return false;
        } 
        else if (cmbDateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(EventForm.this, "Select Date");
            return false;
        } 
        else if (cmbVenueType.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(EventForm.this, "Select Venue Type");
            return false;
        } 
        else if (cmbStartTime.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(EventForm.this, "Select Event Start Time");
            return false;
        } 
        else if (cmbEndTime.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(EventForm.this, "Select Event End Time");
            return false;
        } 
        else if (EventDao.isEventExisted(((VenueManagement) cmbVenue.getSelectedItem()).getVenueID(), 
                new java.sql.Date(DateTimeUtil.updateTime(cmbDateChooser.getDate(), (String) cmbStartTime.getSelectedItem()).getTime()), 
                new java.sql.Date(DateTimeUtil.updateTime(cmbDateChooser.getDate(), (String) cmbEndTime.getSelectedItem()).getTime()))) {
            JOptionPane.showMessageDialog(EventForm.this, "Another Event is Booked between these timings");
            return false;
        }
        else if (txtNoOfGuest.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(EventForm.this, "Select No of guest");
            txtNoOfGuest.grabFocus();
            return false;
        }
        return true;
    }
    private void resetField() {
        txtbkID.setText(null);
        cmbEventType.setSelectedIndex(0);
        cmbVenue.setSelectedIndex(0);
        cmbVenueType.setSelectedIndex(0);
        listfood.clearSelection();
        listequipment.clearSelection();
        cmbStartTime.setSelectedIndex(0);
        cmbEndTime.setSelectedIndex(0);
        txtNoOfGuest.setText(null);
        txtVenueCost.setText(null);
        txtFoodCost.setText(null);
        txtEquipmentCost.setText(null);
        txtTotalCost.setText(null);
        cmbDateChooser.setDate(null);
                
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnbook;
    private javax.swing.JButton btnclear;
    private com.toedter.calendar.JDateChooser cmbDateChooser;
    private javax.swing.JComboBox<String> cmbEndTime;
    private javax.swing.JComboBox<String> cmbEventType;
    private javax.swing.JComboBox<String> cmbStartTime;
    private javax.swing.JComboBox<VenueManagement> cmbVenue;
    private javax.swing.JComboBox<String> cmbVenueType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblicon;
    private javax.swing.JLabel lblimage;
    private javax.swing.JList<EquipmentManagement> listequipment;
    private javax.swing.JList<FoodManagement> listfood;
    private javax.swing.JTextField txtEquipmentCost;
    private javax.swing.JTextField txtFoodCost;
    private javax.swing.JTextField txtNoOfGuest;
    private javax.swing.JTextField txtTotalCost;
    private javax.swing.JTextField txtVenueCost;
    private javax.swing.JTextField txtbkID;
    // End of variables declaration//GEN-END:variables
}
