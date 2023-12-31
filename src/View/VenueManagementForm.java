/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.VenueManagementDao;
import Model.VenueManagement;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ammar
 */
public class VenueManagementForm extends javax.swing.JPanel {
    private MainUI main;
    private String imagePath;
    DefaultTableModel model;
    /**
     * Creates new form VenueManagementForm
     */
    public VenueManagementForm(MainUI main) {
        this.main = main;
        initComponents();
        model = (DefaultTableModel) tblvenue.getModel();
        tblvenue.removeColumn(tblvenue.getColumnModel().getColumn(5));
        loadData();
        if(LoginForm.getUserType().equalsIgnoreCase("CUSTOMER")){
            enablePageAsCustomer();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtcost = new javax.swing.JTextField();
        lblvenue = new javax.swing.JLabel();
        lblimage = new javax.swing.JLabel();
        btnchooseimage = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnupdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnclear = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblvenue = new javax.swing.JTable();
        txtname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtvenueplace = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcontactno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 700));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(txtcost, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 265, 200, 40));

        lblvenue.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        lblvenue.setText("   VENUE MANAGEMENT");
        add(lblvenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 14, -1, 42));

        lblimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lblimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 230, 207));

        btnchooseimage.setText("CHOOSE IMAGE");
        btnchooseimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchooseimageActionPerformed(evt);
            }
        });
        add(btnchooseimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 345, -1, 25));

        btnback.setText("Back");
        btnback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnbackMouseReleased(evt);
            }
        });
        add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 80, 30));

        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 70, 25));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel1.setText("VENUE ID");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 72, 80, 30));

        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 80, 25));

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel2.setText("VENUE NAME");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 129, 110, 40));

        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 70, 25));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel3.setText("COST");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 272, 50, 20));

        btnclear.setText("CLEAR");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 70, 25));
        add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 73, 200, 40));

        tblvenue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "VenueID", "VenueName", "VenuePlace", "VenueCost", "VenueContactNo", "VenueImage"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblvenue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblvenueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblvenue);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 780, 310));
        add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 135, 200, 40));

        jLabel7.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel7.setText("VENUE PLACE");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 198, -1, 30));
        add(txtvenueplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 201, 200, 40));

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel5.setText("CONTACT NO");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 78, -1, 30));
        add(txtcontactno, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 200, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/406199-white-abstract-wallpaper.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void btnchooseimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchooseimageActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        //fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setCurrentDirectory(new File("."));
        int result = fileChooser.showOpenDialog(this.main);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            imagePath = selectedFile.getAbsolutePath();
            loadImage(selectedFile.getAbsolutePath());
        }
    }//GEN-LAST:event_btnchooseimageActionPerformed

    private void btnbackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseReleased
        // TODO add your handling code here:
        this.main.addComponent(new HomePageForm(this.main));
    }//GEN-LAST:event_btnbackMouseReleased

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        if(validateFields()){
            int id = Integer.parseInt(txtid.getText());
            String name = txtname.getText();
            String placename = txtvenueplace.getText();
            double cost = Double.parseDouble(txtcost.getText());
            String contactno = txtcontactno.getText();
            boolean flag = VenueManagementDao.addVenue(new VenueManagement(id,name,placename,cost,contactno,imagePath));
            resetField();
            if (flag){
                JOptionPane.showMessageDialog(VenueManagementForm.this, "Venue added successfully");
                loadData();
            }
            else{
                JOptionPane.showMessageDialog(VenueManagementForm.this, "Venue Already Exists");
            }
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        int i = tblvenue.getSelectedRow();
        if(i!=-1){
            int id = Integer.parseInt(txtid.getText());
            String name = txtname.getText();
            String placename = txtvenueplace.getText();
            double cost = Double.parseDouble(txtcost.getText());
            String contactno = txtcontactno.getText();
            String url = imagePath;
            VenueManagementDao.updateVenue(id, name, placename, cost, contactno, url);
            loadData();
            resetField();
        }else{
            JOptionPane.showMessageDialog(VenueManagementForm.this, "Select any Row");
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        int i = tblvenue.getSelectedRow();
        if(i!=-1){
            int id = Integer.parseInt(txtid.getText());
            VenueManagementDao.deleteVenue(id);
            loadData();
            resetField();
        }else{
            JOptionPane.showMessageDialog(VenueManagementForm.this, "Select any Row");
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        resetField();
    }//GEN-LAST:event_btnclearActionPerformed

    private void tblvenueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblvenueMouseClicked
        // TODO add your handling code here:
        int i = tblvenue.getSelectedRow();
        if(i!=-1){
            txtid.setText(model.getValueAt(i, 0).toString());
            txtname.setText(model.getValueAt(i, 1).toString());
            txtvenueplace.setText(model.getValueAt(i, 2).toString());
            txtcost.setText(model.getValueAt(i, 3).toString());
            txtcontactno.setText(model.getValueAt(i, 4).toString());
            imagePath = model.getValueAt(i, 5).toString();
            loadImage(imagePath);
        }else{
            JOptionPane.showMessageDialog(VenueManagementForm.this, "Select any Row");
        }
    }//GEN-LAST:event_tblvenueMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        tblvenue.clearSelection();
    }//GEN-LAST:event_formMouseClicked
    private void loadImage(String path) {

        if (path != null && !path.trim().equalsIgnoreCase("null") && path.trim().length() > 0) {
            try {
                BufferedImage myPicture = ImageIO.read(new File(path));
                //lblimage.setIcon(new ImageIcon(myPicture));
                lblimage.setIcon(new ImageIcon(myPicture.getScaledInstance(230, 230, 230)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void resetField(){
        txtid.setText(null);
        txtname.setText(null);
        txtvenueplace.setText(null);
        txtcost.setText(null);
        txtcontactno.setText(null);
        lblimage.setIcon(null);
        imagePath = null;
    }
    
    private boolean validateFields(){
        if(txtid.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(VenueManagementForm.this, "Enter id");
            txtid.grabFocus();
            return false;
        }
        else if(VenueManagementDao.isIDExisted(Integer.parseInt(txtid.getText()))){
            JOptionPane.showMessageDialog(VenueManagementForm.this, "ID already exists");
            txtid.grabFocus();
            return false;
        }
        else if(txtname.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(VenueManagementForm.this, "Enter name");
            txtname.grabFocus();
            return false;
        }
        else if(txtvenueplace.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(VenueManagementForm.this, "Enter name of place");
            txtvenueplace.grabFocus();
            return false;
        }
        else if(txtcost.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(VenueManagementForm.this, "Enter cost");
            txtcost.grabFocus();
            return false;
        }
        else if(txtcontactno.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(VenueManagementForm.this, "Enter contact no");
            txtcontactno.grabFocus();
            return false;
        }
        return true;
    }
    
    private void addRow(int id,String name,String placename,double cost,String contactno,String url){
       model.insertRow(tblvenue.getRowCount(), new Object[]{
       id, name, placename, cost, contactno, url});
    }
    
    private void loadData(){
        ArrayList<VenueManagement> list = VenueManagementDao.readVenue();
        model.setRowCount(0);
        for(int i=0; i<list.size(); i++){
            VenueManagement item = list.get(i);
            int id = item.getVenueID();
            String name = item.getVenueName();
            String placename = item.getVenuePlace();
            double cost = item.getVenueCost();
            String contactno = item.getVenueContactNo();
            String url = item.getVenueImage();
            addRow(id,name,placename,cost,contactno,url);
        }
    }
    public void enablePageAsCustomer() {
        lblvenue.setText("See Venues");
        lblvenue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnadd.setVisible(false);
        btnclear.setVisible(false);
        btndelete.setVisible(false);
        btnupdate.setVisible(false);
        btnchooseimage.setVisible(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnchooseimage;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblimage;
    private javax.swing.JLabel lblvenue;
    private javax.swing.JTable tblvenue;
    private javax.swing.JTextField txtcontactno;
    private javax.swing.JTextField txtcost;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtvenueplace;
    // End of variables declaration//GEN-END:variables
}
