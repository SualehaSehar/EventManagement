/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DateTimeUtil;
import Model.EquipmentManagement;
import Model.Event;
import Model.FoodManagement;
import View.LoginForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ammar
 */
public class EventDao {
    public static boolean addEvent(Event event){
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pst = null;
        try{
            conn = SQL.getSqlInstance().createConnection();
            String query = "insert into Event(EventID,PersonID,EventType,VenueID,VenueType,StartDateTime,EndDateTime,NoOfGuest) values (?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, event.getEventID());
            pst.setString(2, LoginForm.getPersonID());
            pst.setString(3, event.getEventType());
            pst.setInt(4, event.getVenueID());
            pst.setString(5, event.getVenueType());
            pst.setDate(6, new java.sql.Date(DateTimeUtil.updateTime(event.getEventDate(), event.getStartTime()).getTime()));
            pst.setDate(7, new java.sql.Date(DateTimeUtil.updateTime(event.getEventDate(), event.getEndTime()).getTime()));
            pst.setInt(8, event.getNoOfGuest());
            pst.executeUpdate();
            flag = true;
            pst.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
    
    public static boolean addEventFood(String eventID, int foodID){
        boolean flag = false;
        String query = "insert into EventFoodID(EventID,FoodID) values ('"+eventID+"','"+foodID+"')";
        try{
            SQL.executeUpdate(query); 
            flag = true;
        } catch(Exception e){
            e.printStackTrace();
            flag = false;
        } 
        return flag;
    }
    
    public static boolean addEventEquipment(String eventID, int equipmentID){
    boolean flag = false;
        String query = "insert into EventEquipmentID(EventID,EquipmentID) values ('"+eventID+"','"+equipmentID+"')";
        try{
            SQL.executeUpdate(query); 
            flag = true;
        } catch(Exception e){
            e.printStackTrace();
            flag = false;
        } 
        return flag;
    }
    
    public static Event readEvent(String eventID){
        ArrayList<FoodManagement> fd_list = new ArrayList<>();
        ArrayList<EquipmentManagement> eq_list = new ArrayList<>();
        double foodcost = 0;
        double eqcost = 0;
        String query1 = "select a.PersonID, a.EventType, a.VenueID, a.VenueType, a.StartDateTime, a.EndDateTime, a.NoOfGuest, "
                    + "b.VenueName,b.VenueCost,b.VenueImage"
                    + " from Event a, Venue b "
                    + " where a.VenueID = b.VenueID "
                    + " and a.EventID = '" + eventID + "'";
        String query2 = "select a.FoodID,b.FoodName,b.FoodCost from EventFoodID a , Food b "
                + "where a.FoodID = b.FoodID and a.EventID = '" + eventID + "'";
        String query3 = "select a.EquipmentID,b.EquipmentName,b.EquipmentCost from EventEquipmentID a , Equipment b "
                + "where a.EquipmentID = b.EquipmentID and a.EventID = '" + eventID + "'";
        Event event = null;
        try{
            ResultSet rs = SQL.execute(query2); 
            while(rs.next()){
                String name = rs.getString("FoodName");
                double cost = rs.getDouble("FoodCost");
                foodcost = foodcost + cost;
                fd_list.add(new FoodManagement(name,cost));
            }
            
            rs = SQL.execute(query3); 
            while(rs.next()){
                String name = rs.getString("EquipmentName");
                double cost = rs.getDouble("EquipmentCost");
                eqcost = eqcost + cost; 
                eq_list.add(new EquipmentManagement(name,cost));
            }
            
            rs = SQL.execute(query1); 
            if(rs.next()){
                String eventType = rs.getString("EventType");
                String personID = rs.getString("PersonID");
                int venueID = rs.getInt("VenueID");
                String venueName = rs.getString("VenueName");
                String venueType = rs.getString("VenueType");
                java.sql.Date StartDate = rs.getDate("StartDateTime");
                java.sql.Date EndDate = rs.getDate("EndDateTime");
                java.sql.Date eventDate = rs.getDate("StartDateTime");
                String startTime =  String.valueOf(rs.getTime("StartDateTime"));
                String endTime =  String.valueOf(rs.getTime("EndDateTime"));
                int noOfGuest = rs.getInt("NoOfGuest");
                String venueImage = rs.getString("VenueImage");
                double venueCost = rs.getDouble("VenueCost");
                foodcost = foodcost * noOfGuest;
                double totalCost = venueCost+foodcost+eqcost;
                event = new Event (eventID,personID,eventType, venueID, venueName, venueType,eventDate,startTime,endTime,
                        noOfGuest, fd_list , eq_list, venueImage, venueCost, foodcost, 
                        eqcost, totalCost, StartDate, EndDate);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return event;
        }
    
    /**public static Event readEventFood(String eventID){
        ArrayList<FoodManagement> fd_list = new ArrayList<>();
        double foodcost = 0;
        Event event = null;
        String query = "select a.FoodID,b.FoodName,b.FoodCost from EventFoodID a , Food b where a.FoodID = b.FoodID and a.EventID = '" + eventID + "'";
        try{
            ResultSet rs = SQL.execute(query); 
            while(rs.next()){
                String name = rs.getString("FoodName");
                double cost = rs.getDouble("FoodCost");
                foodcost = foodcost + cost;
                fd_list.add(new FoodManagement(name,cost));
            }
            event = new Event(fd_list, foodcost);
        } catch(Exception e){
            e.printStackTrace();
        }
        return event;
        }
    
    public static Event readEventEquipment(String eventID){
        ArrayList<EquipmentManagement> eq_list = new ArrayList<>();
        double eqcost = 0;
        Event event = null;
        String query = "select a.EquipmentID,b.EquipmentName,b.EquipmentCost from EventEquipmentID a , Equipment b where a.EquipmentID = b.EquipmentID and a.EventID = '" + eventID + "'";
        try{
            ResultSet rs = SQL.execute(query); 
            while(rs.next()){
                String name = rs.getString("EquipmentName");
                double cost = rs.getDouble("EquipmentCost");
                eqcost = eqcost + cost; 
                eq_list.add(new EquipmentManagement(name,cost));
            }
            event = new Event(eventID,eq_list,eqcost);
        } catch(Exception e){
            e.printStackTrace();
        }
        return event;
   }**/
    
    public static boolean isEventExisted(int venueId, java.sql.Date start, java.sql.Date end){
        boolean flag = false;  
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = SQL.getSqlInstance().createConnection();
            String query = "select * from Event where VenueID = ? and( ? between StartDateTime and EndDateTime or ? "
                    +"between StartDateTime and EndDateTime)";
            pst = conn.prepareStatement(query);
            pst.setInt(1, venueId);
            pst.setDate(2, start);
            pst.setDate(3, end);
            rs = pst.executeQuery();
            if (rs.next()) flag = true;
            pst.close();
            conn.close();
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
            flag=false;
        }
        return flag;
    }


public static void deleteEvent(String eventID){
        try {
            String qu = " delete from Event where EventID ='"+eventID+"'";
            SQL.delete(qu);             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteEventFood(String eventID){
        try {
            String qu = " delete from EventFoodID where EventID ='"+eventID+"'";
            SQL.delete(qu);             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteEventEquipment(String eventID){
        try {
            String qu = " delete from EventEquipmentID where EventID ='"+eventID+"'";
            SQL.delete(qu);             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Event> readAllEvents(){
        ArrayList<Event> ev_list = new ArrayList<>();
        String query = "select a.EventID a.PersonID, a.EventType, a.VenueID, a.VenueType, a.StartDateTime, a.EndDateTime, a.NoOfGuest, "
                    + "b.VenueName from Event a, Venue b "
                    + " where a.VenueID = b.VenueID ";
        try{
            ResultSet rs = SQL.execute(query); 
            while(rs.next()){
                String eventID = rs.getString("EventID");
                String personID = rs.getString("PersonID");
                String eventType = rs.getString("EventType");
                String venueName = rs.getString("VenueName");
                String venueType = rs.getString("VenueType");
                java.sql.Date eventDate = rs.getDate("StartDateTime");
                String startTime =  String.valueOf(rs.getTime("StartDateTime"));
                String endTime =  String.valueOf(rs.getTime("EndDateTime"));
                int noOfGuest = rs.getInt("NoOfGuest");
                ev_list.add(new Event (eventID,personID,eventType,venueName, venueType,eventDate,startTime,endTime,noOfGuest));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return ev_list;
        }
    
    public static ArrayList<Event> readEventsByPersonID(String personID){
        ArrayList<Event> ev_list = new ArrayList<>();
        String query = "select a.EventID, a.EventType, a.VenueID, a.VenueType, a.StartDateTime, a.EndDateTime, a.NoOfGuest, "
                    + "b.VenueName from Event a, Venue b "
                    + " where a.VenueID = b.VenueID "
                    + "and a.PersonID= '" + personID + "'";
        try{
            ResultSet rs = SQL.execute(query); 
            while(rs.next()){
                String eventID = rs.getString("EventID");
                String eventType = rs.getString("EventType");
                String venueName = rs.getString("VenueName");
                String venueType = rs.getString("VenueType");
                java.sql.Date eventDate = rs.getDate("StartDateTime");
                String startTime =  String.valueOf(rs.getTime("StartDateTime"));
                String endTime =  String.valueOf(rs.getTime("EndDateTime"));
                int noOfGuest = rs.getInt("NoOfGuest");
                 ev_list.add(new Event (eventID,personID,eventType,venueName, venueType,eventDate,startTime,endTime,noOfGuest));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return ev_list;
        }
    
}