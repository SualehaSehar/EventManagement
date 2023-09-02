/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller; 
import Model.EquipmentManagement;
import java.sql.*;
import java.util.*;

public class EquipmentManagementDao {
    public static boolean addEquipment(EquipmentManagement em){
        boolean flag = false;
        int id = em.getEquipmentId();
        String name = em.getEquipmentName();
        double cost = em.getEquipmentCost();
        String image = em.getEquipmentImage();
        String query = "insert into Equipment(EquipmentID,EquipmentName,EquipmentCost,EquipmentImage)"
                +"values ('"+id+"','"+name+"','"+cost+"','"+image+"')";
        try{
            SQL.executeUpdate(query); 
            flag = true;
        } catch(Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
        }
    
    public static ArrayList<EquipmentManagement> readEquipment(){
        ArrayList<EquipmentManagement> eq_list = new ArrayList<>();
        String query = "select * from Equipment";
        try{
            ResultSet rs = SQL.execute(query); 
            while(rs.next()){
                int id = rs.getInt("EquipmentID");
                String name = rs.getString("EquipmentName");
                double cost = rs.getDouble("EquipmentCost");
                String url = rs.getString("EquipmentImage");
                eq_list.add(new EquipmentManagement(id,name,cost,url));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return eq_list;
        }
    
    public static void deleteEquipment(int id){
        String query = "delete from Equipment where EquipmentID ='"+id+"'";
        try{
            SQL.delete(query);    
        } catch(Exception e){
            e.printStackTrace();
        } 
    }
    public static void updateEquipment(int id,String name,double cost,String url){
        String query = "update Equipment set EquipmentName = '"+name+"',EquipmentCost = '"+cost+"',EquipmentImage = '"+url+"' where EquipmentID = '"+id+"'";
        try{
            SQL.executeUpdate(query);    
        } catch(Exception e){
            e.printStackTrace();
        } 
    }
    public static boolean isIDExisted(int id){
        boolean flag = false;
        String query = "select * from Equipment where EquipmentID = '"+id+"'";
        try{
            ResultSet rs = SQL.execute(query); 
            if(rs.next()){
                flag = true;
            }
        } catch(Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
