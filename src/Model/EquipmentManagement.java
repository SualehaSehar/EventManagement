/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class EquipmentManagement {

    private int equipmentId;
    private String equipmentName;
    private double equipmentCost;
    private String equipmentImage;

    public EquipmentManagement() {
    }

    public EquipmentManagement(String equipmentName, double equipmentCost) {
        this.equipmentName = equipmentName;
        this.equipmentCost = equipmentCost;
    }

    public EquipmentManagement(int equipmentId, String equipmentName, double equipmentCost, String equipmentImage) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.equipmentCost = equipmentCost;
        this.equipmentImage = equipmentImage;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public double getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(double equipmentCost) {
        this.equipmentCost = equipmentCost;
    }

    public String getEquipmentImage() {
        return equipmentImage;
    }

    public void setEquipmentImage(String equipmentImage) {
        this.equipmentImage = equipmentImage;
    }

    @Override
    public String toString() {
        return "" + equipmentName + " : " + equipmentCost + " pkr " ;
    }
}