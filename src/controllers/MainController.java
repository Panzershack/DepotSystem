package controllers;

import models.Parcel;
import models.Dimension;
import models.ParcelMap;
import models.QueueOfCustomers;
import models.Customer;
import views.MainUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


/**
 * Main controller for handling the Depot System logic.
 */
public class MainController {

    private MainUI views;
    private ParcelMap parcelMap;
    private QueueOfCustomers queueOfCustomers;

    public MainController() {
        // Initialize UI and models
        views = new MainUI();
        parcelMap = new ParcelMap();
        queueOfCustomers = new QueueOfCustomers();
        views.setVisible(true);
        
        // Load and render data
        loadAndRenderParcels();
        loadAndRenderCustomers();

        // Add action listeners for buttons
        views.getAddParcelButton().addActionListener(e -> handleAddParcel());
        views.getProcessParcelButton().addActionListener(e -> handleProcessParcel());
        views.getAddCustomerButton().addActionListener(e -> handleAddCustomer());
    }

    /**
     * Loads parcels from the text file and renders them in the table.
     */
    private void loadAndRenderParcels() {
        DefaultTableModel model = (DefaultTableModel) views.getParcelsTable().getModel();
        try (BufferedReader reader = new BufferedReader(new FileReader("parcels.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line: " + line); // Debug print
                String[] parts = line.split(",");
                if (parts.length == 5) { // Ensure correct number of fields
                    String parcelID = parts[0];
                    double weight = Double.parseDouble(parts[1]);
                    int daysInDepot = Integer.parseInt(parts[2]);
                    String dimensionString = parts[3];
                    String status = parts[4];

                    // Parse the dimension string to create a Dimension object
                    String[] dimensionParts = dimensionString.split("x");
                    Dimension dimension = new Dimension(
                        Double.parseDouble(dimensionParts[0]),
                        Double.parseDouble(dimensionParts[1]),
                        Double.parseDouble(dimensionParts[2])
                    );

                    // Create the Parcel object with the Dimension
                    Parcel parcel = new Parcel(parcelID, weight, status, dimension);
                    parcel.incrementDaysInDepot();

                    // Add the Parcel to ParcelMap
                    parcelMap.addParcel(parcel);

                    // Add to the table as a formatted string
                    model.addRow(new Object[]{parcelID, weight, dimensionString, status, daysInDepot});
                    System.out.println("Added parcel to map and table: " + parcelID); // Debug print
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads customers from the text file and renders them in the table.
     */
    private void loadAndRenderCustomers() {
        DefaultTableModel model = (DefaultTableModel) views.getCustomersTable().getModel();
        try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line: " + line); // Debug print
                String[] parts = line.split(",");
                if (parts.length == 3) { // Ensure correct number of fields
                    int seqNum = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String parcelID = parts[2];

                    // Create and add Customer to the queue
                    Customer customer = new Customer(seqNum, name, parcelID);
                    queueOfCustomers.enqueue(customer);

                    // Add to the table
                    model.addRow(new Object[]{seqNum, name, parcelID});
                    System.out.println("Added customer to queue and table: " + name); // Debug print
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void updateParcelStatusInFile(String parcelID, String newStatus) {
    File inputFile = new File("parcels.txt");
    File tempFile = new File("parcels_temp.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].equals(parcelID)) {
                // Update the status in the file
                parts[4] = newStatus;
                line = String.join(",", parts);
            }
            writer.write(line);
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Replace old file with updated file
    if (!inputFile.delete()) {
        System.err.println("Could not delete original file!");
        return;
    }
    if (!tempFile.renameTo(inputFile)) {
        System.err.println("Could not rename temp file!");
    }
}


    /**
     * Handles the Add Parcel button click event.
     */
private void handleAddParcel() {
    // Created input fields
    JTextField customerNameField = new JTextField();
    JTextField weightField = new JTextField();
    JTextField lengthField = new JTextField();
    JTextField heightField = new JTextField();
    JTextField widthField = new JTextField();

    // Panel for the input form
    JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
    panel.add(new JLabel("Customer Name:"));
    panel.add(customerNameField);
    panel.add(new JLabel("Weight (kg):"));
    panel.add(weightField);
    panel.add(new JLabel("Length (m):"));
    panel.add(lengthField);
    panel.add(new JLabel("Height (m):"));
    panel.add(heightField);
    panel.add(new JLabel("Width (m):"));
    panel.add(widthField);

    // Showing the dialog
    int result = JOptionPane.showConfirmDialog(
        views, 
        panel, 
        "Add New Parcel", 
        JOptionPane.OK_CANCEL_OPTION, 
        JOptionPane.PLAIN_MESSAGE
    );

    if (result == JOptionPane.OK_OPTION) {
        try {
            // Parse inputs
            String customerName = customerNameField.getText().trim();
            double weight = Double.parseDouble(weightField.getText().trim());
            double length = Double.parseDouble(lengthField.getText().trim());
            double height = Double.parseDouble(heightField.getText().trim());
            double width = Double.parseDouble(widthField.getText().trim());

            // Validate inputs
            if (customerName.isEmpty() || weight <= 0 || length <= 0 || height <= 0 || width <= 0) {
                JOptionPane.showMessageDialog(views, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if customer is returning
            boolean isReturning = queueOfCustomers.getQueue().stream()
                .anyMatch(customer -> customer.getCustomerName().equalsIgnoreCase(customerName));

            // Generate IDs
            String parcelPrefix = isReturning ? "X" : "C";
            int nextParcelNumber = parcelMap.getAllParcels().size() + 1;
            String parcelID = parcelPrefix + nextParcelNumber;

            int nextSeqNumber = queueOfCustomers.getQueue().size() + 1;

            // Create Dimension and Parcel
            Dimension dimension = new Dimension(length, width, height);
            Parcel parcel = new Parcel(parcelID, weight, "Awaiting Collection", dimension);

            // Add Parcel to the system
            parcelMap.addParcel(parcel);

            // Create and add Customer to the system
            Customer customer = new Customer(nextSeqNumber, customerName, parcelID);
            queueOfCustomers.enqueue(customer);

            // Add to tables
            DefaultTableModel parcelModel = (DefaultTableModel) views.getParcelsTable().getModel();
            parcelModel.addRow(new Object[]{parcelID, weight, dimension.toString(), "Awaiting Collection", 0});

            DefaultTableModel customerModel = (DefaultTableModel) views.getCustomersTable().getModel();
            customerModel.addRow(new Object[]{nextSeqNumber, customerName, parcelID});

            // Save to files
            appendToFile("parcels.txt", String.format("%s,%.2f,0,%s,Awaiting Collection%n", parcelID, weight, dimension));
            appendToFile("customers.txt", String.format("%d,%s,%s%n", nextSeqNumber, customerName, parcelID));

            // Success message
            JOptionPane.showMessageDialog(views, "Parcel Added to System Awaiting Collection", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(views, "Invalid number format. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(views, "An error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

/**
 * Appends a string to a file.
 */
private void appendToFile(String filename, String content) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
        writer.write(content);
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    /**
     * Handles the Process Parcel button click event.
     */
private void handleProcessParcel() {
    int selectedRow = views.getParcelsTable().getSelectedRow();

    if (selectedRow == -1) {
        // No row selected, show a message
        JOptionPane.showMessageDialog(views, "Please select a parcel to process!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Get parcel details from the selected row
    DefaultTableModel model = (DefaultTableModel) views.getParcelsTable().getModel();
    String parcelID = model.getValueAt(selectedRow, 0).toString();
    String status = model.getValueAt(selectedRow, 3).toString();
    double weight = Double.parseDouble(model.getValueAt(selectedRow, 1).toString());
    String[] dimensionsParts = model.getValueAt(selectedRow, 2).toString().split("x");
    double length = Double.parseDouble(dimensionsParts[0]);
    double width = Double.parseDouble(dimensionsParts[1]);
    double height = Double.parseDouble(dimensionsParts[2]);
    int daysInDepot = Integer.parseInt(model.getValueAt(selectedRow, 4).toString());

    // Check if parcel is already collected
    if ("Collected".equalsIgnoreCase(status)) {
        JOptionPane.showMessageDialog(views, "Parcel is already collected!", "Info", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // Calculate base fee
    double volume = length * width * height;
    double baseFee = (weight * 2) + (volume * 10) + (daysInDepot * 1);

    // Calculate discount
    double discount = 0;
    if (parcelID.startsWith("X")) {
        discount = 0.20 * baseFee;
    }

    double totalFee = baseFee - discount;

    // Show confirmation dialog with fee details
    int confirm = JOptionPane.showConfirmDialog(
        views,
        String.format(
            "Total: £%.2f\nDiscount: £%.2f (%s)\nRequest Customer to Pay Total: £%.2f\n\nHas the customer collected the parcel?",
            baseFee, discount, parcelID.startsWith("X") ? "20% discount for X prefix" : "No discount", totalFee
        ),
        "Confirm Collection",
        JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {
        // Update status to "Collected"
        model.setValueAt("Collected", selectedRow, 3);

        // Update parcels.txt
        updateParcelStatusInFile(parcelID, "Collected");

        // Log collection details (to be implemented later in the Log class)
        System.out.println("Parcel collected: " + parcelID + ", Fee Paid: £" + totalFee);
    }
}



    /**
     * Handles the Add Customer button click event.
     */
    private void handleAddCustomer() {
        System.out.println("Logic for adding customer in Controller");
        // Add your implementation here
    }
}
