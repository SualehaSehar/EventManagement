/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ammar
 */
public class Event {
    private String eventID;
    private String personID;
    private String eventType;
    private int venueID;
    private String venueName;
    private String venueType;
    private Date eventDate;
    private String startTime;
    private String endTime;
    private int noOfGuest;
    private ArrayList<FoodManagement> foodItems;
    private ArrayList<EquipmentManagement> equipments;
    private String venueImage;
    private double venueCost;
    private double foodCost;
    private double equipmentCost;
    private double totalCost;
    private Date startDate;
    private Date endDate;


    public Event() {
    }
   
    public Event(String eventID, String personID, String eventType, String venueType, String venueName, Date startDate, 
            Date endDate, int noOfGuest, String venueImage ,double venueCost){
        this.eventID = eventID;
        this.personID = personID;
        this.eventType = eventType;
        this.venueType = venueType;
        this.venueName = venueName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.noOfGuest = noOfGuest;
        this.venueImage = venueImage;
        this.venueCost = venueCost;
    }

    public Event(String eventID, String personID, String eventType, int venueID, String venueName, String venueType, 
            Date eventDate, String startTime, String endTime, int noOfGuest, ArrayList<FoodManagement> foodItems, 
            ArrayList<EquipmentManagement> equipments, String venueImage, double venueCost, double foodCost, double equipmentCost, 
            double totalCost, Date startDate, Date endDate) {
        this.eventID = eventID;
        this.personID = personID;
        this.eventType = eventType;
        this.venueID = venueID;
        this.venueName = venueName;
        this.venueType = venueType;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.noOfGuest = noOfGuest;
        this.foodItems = foodItems;
        this.equipments = equipments;
        this.venueImage = venueImage;
        this.venueCost = venueCost;
        this.foodCost = foodCost;
        this.equipmentCost = equipmentCost;
        this.totalCost = totalCost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Event(String eventID, String personID, String eventType, String venueName, String venueType, Date eventDate, String startTime, String endTime, int noOfGuest) {
        this.eventID = eventID;
        this.personID = personID;
        this.eventType = eventType;
        this.venueName = venueName;
        this.venueType = venueType;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.noOfGuest = noOfGuest;

    }

    
    public Event(ArrayList<FoodManagement> foodItems, double foodCost) {
        this.foodItems = foodItems;
        this.foodCost = foodCost;
    }

    public Event(String eventID, ArrayList<EquipmentManagement> equipments, double equipmentCost) {
        this.eventID = eventID;
        this.equipments = equipments;
        this.equipmentCost = equipmentCost;
    }


    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getVenueID() {
        return venueID;
    }

    public void setVenueID(int venueID) {
        this.venueID = venueID;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueType() {
        return venueType;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getNoOfGuest() {
        return noOfGuest;
    }

    public void setNoOfGuest(int noOfGuest) {
        this.noOfGuest = noOfGuest;
    }

    public ArrayList<FoodManagement> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(ArrayList<FoodManagement> foodItems) {
        this.foodItems = foodItems;
    }

    public ArrayList<EquipmentManagement> getEquipments() {
        return equipments;
    }

    public void setEquipments(ArrayList<EquipmentManagement> equipments) {
        this.equipments = equipments;
    }

    public String getVenueImage() {
        return venueImage;
    }

    public void setVenueImage(String venueImage) {
        this.venueImage = venueImage;
    }

    public double getVenueCost() {
        return venueCost;
    }

    public void setVenueCost(double venueCost) {
        this.venueCost = venueCost;
    }

    public double getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }

    public double getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(double equipmentCost) {
        this.equipmentCost = equipmentCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    @Override
    public String toString() {
        return "Event{" + "eventID=" + eventID + ", personID=" + personID + ", eventType=" + eventType + ", venueID=" 
                + venueID + ", venueName=" + venueName + ", venueType=" + venueType + ", eventDate=" + eventDate 
                + ", startTime=" + startTime + ", endTime=" + endTime + ", noOfGuest=" + noOfGuest + ", foodItems=" + foodItems 
                + ", equipments=" + equipments + ", venueImage=" + venueImage + ", venueCost=" + venueCost + ", foodCost=" + foodCost 
                + ", equipmentCost=" + equipmentCost + ", totalCost=" + totalCost + ", StartDate=" + startDate + ", EndDate=" 
                + endDate + '}';
    }

}
