/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author pasanpitigala
 */
public class Parcel {
    private String parcelID;
    private double weight;
    private Dimension dimension;
    private String status;
    private int daysInDepot;

    // Parcel Constructor
    public Parcel(String parcelID, double weight, String status, Dimension dimension) {
        this.parcelID = parcelID;
        this.weight = weight;
        this.dimension = dimension;
        this.status = status;
        this.daysInDepot = 0;
    }

    // Getter and Setter Methods
    public String getParcelID() {
        return parcelID;
    }

    public void setParcelID(String parcelID) {
        this.parcelID = parcelID;
    }

    public double getWeight() {
        return weight;
    }    

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getDaysInDepot() {
    return daysInDepot;
}

    public void incrementDaysInDepot() {
    this.daysInDepot++;
}

}
