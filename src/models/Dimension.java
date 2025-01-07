package models;

 //Represents the dimensions of a parcel.

public class Dimension {
    private double length;
    private double width;
    private double height;

    // Constructor
    public Dimension(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // Getter for length
    public double getLength() {
        return length;
    }

    // Setter for length
    public void setLength(double length) {
        this.length = length;
    }

    // Getter for width
    public double getWidth() {
        return width;
    }

    // Setter for width
    public void setWidth(double width) {
        this.width = width;
    }

    // Getter for height
    public double getHeight() {
        return height;
    }

    // Setter for height
    public void setHeight(double height) {
        this.height = height;
    }

    // Method to display the dimensions as a string
    @Override
    public String toString() {
        return length + " x " + width + " x " + height;
    }
}
