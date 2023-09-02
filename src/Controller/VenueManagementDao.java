/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.VenueManagement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ammar
 */
public class VenueManagementDao {
    public static boolean addVenue(VenueManagement em){
        boolean flag = false;
        int id = em.getVenueID();
        String name = em.getVenueName();
        String placeName = em.getVenuePlace();
        double cost = em.getVenueCost();
        String contactNo = em.getVenueContactNo();
        String image = em.getVenueImage();
        String query = "insert into Venue(VenueID,VenueName,VenuePlaceName,VenueCost,VenueContactNo,VenueImage)"
                +"values ('"+id+"','"+name+"','"+placeName+"','"+cost+"','"+contactNo+"','"+image+"')";
        try{
            SQL.executeUpdate(query); ;
            flag = true;
        } catch(Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
        }
    
    public static ArrayList<VenueManagement> readVenue(){
        ArrayList<VenueManagement> eq_list = new ArrayList<>();
        String query = "select * from Venue";
        try{
            ResultSet rs = SQL.execute(query); 
            while(rs.next()){
                int id = rs.getInt("VenueID");
                String name = rs.getString("VenueName");
                String placeName = rs.getString("VenuePlaceName");
                double cost = rs.getDouble("VenueCost");
                String contactNo = rs.getString("VenueContactNo");
                String url = rs.getString("VenueImage");
                eq_list.add(new VenueManagement(id,name,placeName,cost,contactNo,url));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return eq_list;
        }
    
    public static void deleteVenue(int id){
        String query = "delete from Venue where VenueID ='"+id+"'";
        try{
            SQL.delete(query);    
        } catch(Exception e){
            e.printStackTrace();
        } 
    }
    public static void updateVenue(int id,String name,String placename,double cost,String no,String url){
        String query = "update Venue set VenueName = '"+name+"',VenuePlaceName = '"+placename+"',VenueCost = '"+cost+"',VenueContactNo = '"+no+"',VenueImage = '"+url+"' where VenueID = '"+id+"'";
        try{
            SQL.executeUpdate(query);    
        } catch(Exception e){
            e.printStackTrace();
        } 
    }
    public static boolean isIDExisted(int id){
        boolean flag = false;
        String query = "select * from Venue where VenueID = '"+id+"'"; 
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
