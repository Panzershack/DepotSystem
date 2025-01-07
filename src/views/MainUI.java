package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainUI extends JFrame {
    private JTable parcelsTable;
    private JTable customersTable;
    private JTextField parcelIdTxt, weightTxt, statusTxt, widthTxt, heightTxt, lengthTxt, searchParcelTxt;
    private JButton addParcelButton, processParcelButton, editParcelButton, saveBtn, deleteBtn, searchButton, resetButton;
    private JLabel dateTimeLbl;

    public MainUI() {
        setTitle("Depot System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new BorderLayout());

        // Top Panel - Date and Time
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dateTimeLbl = new JLabel("DateTime");
        topPanel.add(dateTimeLbl);
        add(topPanel, BorderLayout.NORTH);

        // Center Panel - Tables
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        parcelsTable = createTable(new String[]{"Parcel ID", "Weight", "Dimension", "Parcel Status", "Days in Depot"});
        customersTable = createTable(new String[]{"Sequence Number", "Name", "Parcel ID"});
        centerPanel.add(new JScrollPane(parcelsTable));
        centerPanel.add(new JScrollPane(customersTable));
        add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel - Controls
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        parcelIdTxt = new JTextField(10);
        weightTxt = new JTextField(10);
        statusTxt = new JTextField(10);
        widthTxt = new JTextField(5);
        heightTxt = new JTextField(5);
        lengthTxt = new JTextField(5);
        searchParcelTxt = new JTextField(10);

        addParcelButton = new JButton("Add Parcel");
        processParcelButton = new JButton("Process Parcel");
        editParcelButton = new JButton("Edit Parcel");
        saveBtn = new JButton("Save");
        deleteBtn = new JButton("Delete");
        searchButton = new JButton("Search");
        resetButton = new JButton("Reset Table");

        bottomPanel.add(new JLabel("Parcel ID:"));
        bottomPanel.add(parcelIdTxt);
        bottomPanel.add(new JLabel("Weight:"));
        bottomPanel.add(weightTxt);
        bottomPanel.add(new JLabel("Status:"));
        bottomPanel.add(statusTxt);
        bottomPanel.add(new JLabel("Dimensions (W x H x L):"));
        bottomPanel.add(widthTxt);
        bottomPanel.add(heightTxt);
        bottomPanel.add(lengthTxt);
        bottomPanel.add(addParcelButton);
        bottomPanel.add(processParcelButton);
        bottomPanel.add(editParcelButton);
        bottomPanel.add(saveBtn);
        bottomPanel.add(deleteBtn);
        bottomPanel.add(new JLabel("Search:"));
        bottomPanel.add(searchParcelTxt);
        bottomPanel.add(searchButton);
        bottomPanel.add(resetButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // Start Clock
        startClock();

        setVisible(true);
    }

    private JTable createTable(String[] columnNames) {
        DefaultTableModel model = new DefaultTableModel(null, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class; // Adjust based on column data types
            }
        };
        return new JTable(model);
    }

    public void startClock() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timer timer = new Timer(1000, e -> dateTimeLbl.setText(formatter.format(new Date())));
        timer.start();
    }

    // Getters for components to maintain compatibility
    public JTable getParcelsTable() {
        return parcelsTable;
    }

    public JTable getCustomersTable() {
        return customersTable;
    }

    public JTextField getParcelIdTxt() {
        return parcelIdTxt;
    }

    public JTextField getWeightTxt() {
        return weightTxt;
    }

    public JTextField getStatusTxt() {
        return statusTxt;
    }

    public JTextField getWidthTxt() {
        return widthTxt;
    }

    public JTextField getHeightTxt() {
        return heightTxt;
    }

    public JTextField getLengthTxt() {
        return lengthTxt;
    }

    public JTextField getSearchParcelTxt() {
        return searchParcelTxt;
    }

    public JButton getAddParcelButton() {
        return addParcelButton;
    }

    public JButton getProcessParcelButton() {
        return processParcelButton;
    }

    public JButton getEditParcelButton() {
        return editParcelButton;
    }

    public JButton getSaveParcelButton() {
        return saveBtn;
    }

    public JButton getDeleteParcelButton() {
        return deleteBtn;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void addActionListener(ActionListener listener) {
        addParcelButton.addActionListener(listener);
        processParcelButton.addActionListener(listener);
        editParcelButton.addActionListener(listener);
        saveBtn.addActionListener(listener);
        deleteBtn.addActionListener(listener);
        searchButton.addActionListener(listener);
        resetButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        new MainUI();
    }
}
