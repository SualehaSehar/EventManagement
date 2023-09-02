/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ammar
 */
public class VenueManagement {
    private int venueID;
    private String venueName;
    private String venuePlace;
    private double venueCost;
    private String venueContactNo;
    private String venueImage;

    public VenueManagement() {
    }

    public VenueManagement(int venueID, String venueName, String venuePlace, double venueCost, String venueContactNo, String venueImage) {
        this.venueID = venueID;
        this.venueName = venueName;
        this.venuePlace = venuePlace;
        this.venueCost = venueCost;
        this.venueContactNo = venueContactNo;
        this.venueImage = venueImage;
    }

    public VenueManagement(String venueName, String venuePlace, double venueCost, String venueContactNo, String venueImage) {
        this.venueName = venueName;
        this.venuePlace = venuePlace;
        this.venueCost = venueCost;
        this.venueContactNo = venueContactNo;
        this.venueImage = venueImage;
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

    public String getVenuePlace() {
        return venuePlace;
    }

    public void setVenuePlace(String venuePlace) {
        this.venuePlace = venuePlace;
    }

    public double getVenueCost() {
        return venueCost;
    }

    public void setVenueCost(double venueCost) {
        this.venueCost = venueCost;
    }

    public String getVenueContactNo() {
        return venueContactNo;
    }

    public void setVenueContactNo(String venueContactNo) {
        this.venueContactNo = venueContactNo;
    }

    public String getVenueImage() {
        return venueImage;
    }

    public void setVenueImage(String venueImage) {
        this.venueImage = venueImage;
    }

    @Override
    public String toString() {
        return "" + venueName ;
    }
    
}
