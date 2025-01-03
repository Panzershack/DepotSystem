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
        views.getEditParcelButton().addActionListener(e -> handleEditParcel());
        views.getSaveParcelButton().addActionListener(e -> handleSaveParcel());
        views.getDeleteParcelButton().addActionListener(e -> handleDeleteParcel());
        views.getSearchButton().addActionListener(e -> handleSearchParcel());
        views.getResetButton().addActionListener(e -> handleResetParcelsTable());


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

private void handleEditParcel() {
    int selectedRow = views.getParcelsTable().getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(views, "Please select a parcel to edit!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Retrieve data from the selected row
    DefaultTableModel model = (DefaultTableModel) views.getParcelsTable().getModel();
    String parcelID = model.getValueAt(selectedRow, 0).toString();
    double weight = Double.parseDouble(model.getValueAt(selectedRow, 1).toString());
    String dimension = model.getValueAt(selectedRow, 2).toString();
    String status = model.getValueAt(selectedRow, 3).toString();

    // Split dimension string into parts
    String[] dimensions = dimension.split("x");
    double width = Double.parseDouble(dimensions[0]);
    double height = Double.parseDouble(dimensions[1]);
    double length = Double.parseDouble(dimensions[2]);

    // Populate form fields
    views.getParcelIdTxt().setText(parcelID);
    views.getWeightTxt().setText(String.valueOf(weight));
    views.getStatusTxt().setText(status);
    views.getWidthTxt().setText(String.valueOf(width));
    views.getHeightTxt().setText(String.valueOf(height));
    views.getLengthTxt().setText(String.valueOf(length));
}

private void handleSaveParcel() {
    String parcelID = views.getParcelIdTxt().getText();
    double weight = Double.parseDouble(views.getWeightTxt().getText());
    String status = views.getStatusTxt().getText();
    double width = Double.parseDouble(views.getWidthTxt().getText());
    double height = Double.parseDouble(views.getHeightTxt().getText());
    double length = Double.parseDouble(views.getLengthTxt().getText());

    // Confirm the save operation
    int confirm = JOptionPane.showConfirmDialog(views, "Do you want to save changes?", "Confirm Save", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        DefaultTableModel model = (DefaultTableModel) views.getParcelsTable().getModel();
        int selectedRow = views.getParcelsTable().getSelectedRow();

        // Update the table
        model.setValueAt(weight, selectedRow, 1);
        model.setValueAt(width + "x" + height + "x" + length, selectedRow, 2);
        model.setValueAt(status, selectedRow, 3);

        // Update ParcelMap
        Parcel parcel = parcelMap.getParcel(parcelID);
        parcel.setWeight(weight);
        parcel.setDimension(new Dimension(width, height, length));
        parcel.setStatus(status);

        // Update the parcels.txt file
        updateParcelStatusInFile(parcelID, status);
        JOptionPane.showMessageDialog(views, "Parcel details updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}

private void handleDeleteParcel() {
    int selectedRow = views.getParcelsTable().getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(views, "Please select a parcel to delete!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Confirm the delete operation
    int confirm = JOptionPane.showConfirmDialog(views, "Are you sure you want to delete this parcel?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        DefaultTableModel model = (DefaultTableModel) views.getParcelsTable().getModel();
        String parcelID = model.getValueAt(selectedRow, 0).toString();

        // Remove from table
        model.removeRow(selectedRow);

        // Remove from ParcelMap
        parcelMap.removeParcel(parcelID);

        // Update the parcels.txt file
        updateParcelStatusInFile(parcelID, null); // null to indicate removal
        JOptionPane.showMessageDialog(views, "Parcel deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
 * Handles the search functionality for the parcels table by Parcel ID only.
 */
private void handleSearchParcel() {
    String searchText = views.getSearchParcelTxt().getText().trim().toLowerCase();

    if (searchText.isEmpty()) {
        JOptionPane.showMessageDialog(views, "Please enter a Parcel ID to search.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    DefaultTableModel model = (DefaultTableModel) views.getParcelsTable().getModel();
    DefaultTableModel tempModel = new DefaultTableModel(new String[]{"Parcel ID", "Weight", "Dimension", "Parcel Status", "Days in Depot"}, 0);

    boolean found = false;

    for (int i = 0; i < model.getRowCount(); i++) {
        String parcelID = model.getValueAt(i, 0).toString().toLowerCase();

        if (parcelID.contains(searchText)) {
            tempModel.addRow(new Object[]{
                model.getValueAt(i, 0), // Parcel ID
                model.getValueAt(i, 1), // Weight
                model.getValueAt(i, 2), // Dimension
                model.getValueAt(i, 3), // Parcel Status
                model.getValueAt(i, 4)  // Days in Depot
            });
            found = true;
        }
    }

    if (found) {
        views.getParcelsTable().setModel(tempModel);
    } else {
        JOptionPane.showMessageDialog(views, "No result found. Enter a valid Parcel ID.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}



/**
 * Resets the parcels table to show all data.
 */
private void handleResetParcelsTable() {
    DefaultTableModel model = (DefaultTableModel) views.getParcelsTable().getModel();
    model.setRowCount(0); // Clear the table
    loadAndRenderParcels(); // Reload all data
}






  
    
}
