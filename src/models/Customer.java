package models;

//Represents a customer in the depot system, each customer has a unique sequence number, a name, and a parcel ID.

public class Customer {
    private int seqNum;        // Sequence number in the queue
    private String customerName;  // Customer's name
    private String parcelID;      // Associated parcel ID

    // Constructor
    public Customer(int seqNum, String customerName, String parcelID) {
        this.seqNum = seqNum;
        this.customerName = customerName;
        this.parcelID = parcelID;
    }

    // Getter for sequence number
    public int getSeqNum() {
        return seqNum;
    }

    // Setter for sequence number
    public void setSeqNum(int seqNum) {
        this.seqNum = seqNum;
    }

    // Getter for customer name
    public String getCustomerName() {
        return customerName;
    }

    // Setter for customer name
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Getter for parcel ID
    public String getParcelID() {
        return parcelID;
    }

    // Setter for parcel ID
    public void setParcelID(String parcelID) {
        this.parcelID = parcelID;
    }
    
    //for debugging (check)
    @Override
    public String toString() {
        return "Customer{" +
               "SeqNum=" + seqNum +
               ", Name='" + customerName + '\'' +
               ", ParcelID='" + parcelID + '\'' +
               '}';
    }
}
