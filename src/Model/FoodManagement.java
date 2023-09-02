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
public class FoodManagement {
    private int FoodId;
    private String FoodName;
    private double FoodCost;
    private String FoodImage;

    public FoodManagement() {
    }

    public FoodManagement(int FoodId, String FoodName, double FoodCost, String FoodImage) {
        this.FoodId = FoodId;
        this.FoodName = FoodName;
        this.FoodCost = FoodCost;
        this.FoodImage = FoodImage;
    }

    public FoodManagement(String FoodName, double FoodCost) {
        this.FoodName = FoodName;
        this.FoodCost = FoodCost;

    }

    public int getFoodId() {
        return FoodId;
    }

    public void setFoodId(int FoodId) {
        this.FoodId = FoodId;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String FoodName) {
        this.FoodName = FoodName;
    }

    public double getFoodCost() {
        return FoodCost;
    }

    public void setFoodCost(double FoodCost) {
        this.FoodCost = FoodCost;
    }

    public String getFoodImage() {
        return FoodImage;
    }

    public void setFoodImage(String FoodImage) {
        this.FoodImage = FoodImage;
    }

    @Override
    public String toString() {
        return "" + FoodName + " : " + FoodCost + " pkr " ;
    }
}

