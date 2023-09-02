/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.FoodManagementDao;
import Model.FoodManagement;
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
public class FoodManagementForm extends javax.swing.JPanel {
    private MainUI main;
    private String imagePath;
    DefaultTableModel model;
    /**
     * Creates new form FoodManagementForm
     */
    public FoodManagementForm(MainUI main) {
        this.main = main;
        initComponents();
        model = (DefaultTableModel) tblfood.getModel();
        tblfood.removeColumn(tblfood.getColumnModel().getColumn(3));
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
        lblfood = new javax.swing.JLabel();
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
        tblfood = new javax.swing.JTable();
        txtname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 700));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(txtcost, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 216, 200, 40));

        lblfood.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        lblfood.setText("FOOD MANAGEMENT");
        add(lblfood, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 220, 60));

        lblimage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lblimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 230, 207));

        btnchooseimage.setText("CHOOSE IMAGE");
        btnchooseimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchooseimageActionPerformed(evt);
            }
        });
        add(btnchooseimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, -1, 25));

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
        add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 70, 25));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel1.setText("FOOD ID");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 70, 22));

        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, 25));

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel2.setText("FOOD NAME");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 100, 29));

        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 70, 25));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel3.setText("COST");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 40, 22));

        btnclear.setText("CLEAR");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 70, 25));
        add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 200, 40));

        tblfood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " FoodID", " FoodName", " FoodCost", " FoodImage"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblfood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblfoodMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblfood);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 338, 780, 350));
        add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 153, 200, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/406199-white-abstract-wallpaper.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));
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
            double cost = Double.parseDouble(txtcost.getText());
            
            boolean flag = FoodManagementDao.addFood(new FoodManagement(id,name,cost,imagePath));
            resetField();
            if (flag){
                JOptionPane.showMessageDialog(FoodManagementForm.this, "Food added successfully");
                loadData();
            }
            else{
                JOptionPane.showMessageDialog(FoodManagementForm.this, "Item Already Exists");
            }
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        int i = tblfood.getSelectedRow();
        if(i!=-1){
            int id = Integer.parseInt(txtid.getText());
            String name = txtname.getText();
            double cost = Double.parseDouble(txtcost.getText());
            String url = imagePath;
            FoodManagementDao.updateFood(id, name, cost, url);
            loadData();
            resetField();
        }else{
            JOptionPane.showMessageDialog(FoodManagementForm.this, "Select any Row");
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        int i = tblfood.getSelectedRow();
        if(i!=-1){
            int id = Integer.parseInt(txtid.getText());
            FoodManagementDao.deleteFood(id);
            loadData();
            resetField();
        }else{
            JOptionPane.showMessageDialog(FoodManagementForm.this, "Select any Row");
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        resetField();
    }//GEN-LAST:event_btnclearActionPerformed

    private void tblfoodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblfoodMouseClicked
        // TODO add your handling code here:
        int i = tblfood.getSelectedRow();
        if(i!=-1){
            txtid.setText(model.getValueAt(i, 0).toString());
            txtname.setText(model.getValueAt(i, 1).toString());
            txtcost.setText(model.getValueAt(i, 2).toString());
            imagePath = model.getValueAt(i, 3).toString();
            loadImage(imagePath);
        }else{
            JOptionPane.showMessageDialog(FoodManagementForm.this, "Select any Row");
        }

    }//GEN-LAST:event_tblfoodMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        tblfood.clearSelection();
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
        txtcost.setText(null);
        lblimage.setIcon(null);
        imagePath = null;
    }
    
    private boolean validateFields(){
        if(txtid.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(FoodManagementForm.this, "Enter id");
            txtid.grabFocus();
            return false;
        }
        else if(FoodManagementDao.isIDExisted(Integer.parseInt(txtid.getText()))){
            JOptionPane.showMessageDialog(FoodManagementForm.this, "ID already exists");
            txtid.grabFocus();
            return false;
        }
        else if(txtname.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(FoodManagementForm.this, "Enter name");
            txtname.grabFocus();
            return false;
        }
        else if(txtcost.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(FoodManagementForm.this, "Enter cost");
            txtcost.grabFocus();
            return false;
        }
        return true;
    }
    
    private void addRow(int id,String name,double cost,String url){
       model.insertRow(tblfood.getRowCount(), new Object[]{
       id, name, cost, url});
    }
    
    private void loadData(){
        ArrayList<FoodManagement> list = FoodManagementDao.readFood();
        model.setRowCount(0);
        for(int i=0; i<list.size(); i++){
            FoodManagement item = list.get(i);
            int id = item.getFoodId();
            String name = item.getFoodName();
            double cost = item.getFoodCost();
            String url = item.getFoodImage();
            addRow(id,name,cost,url);
        }
    }
    public void enablePageAsCustomer() {
        lblfood.setText("See Food Menue");
        lblfood.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfood;
    private javax.swing.JLabel lblimage;
    private javax.swing.JTable tblfood;
    private javax.swing.JTextField txtcost;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
