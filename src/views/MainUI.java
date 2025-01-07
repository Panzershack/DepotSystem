package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Main User Interface for the Depot System.
 */
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
        setLocationRelativeTo(null); // Centering the window on the screen
        setLayout(new BorderLayout());

        // Top Panel: Date and Time
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dateTimeLbl = new JLabel("DateTime");
        topPanel.add(dateTimeLbl);
        add(topPanel, BorderLayout.NORTH);

        // Center Panel: Split Pane with Tables
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setResizeWeight(0.5); // Equal initial size for both tables
        splitPane.setDividerSize(8);

        parcelsTable = createTable(new String[]{"Parcel ID", "Weight", "Dimension", "Parcel Status", "Days in Depot"});
        JScrollPane parcelsScrollPane = new JScrollPane(parcelsTable);
        parcelsScrollPane.setBorder(BorderFactory.createTitledBorder("Parcels"));

        customersTable = createTable(new String[]{"Sequence Number", "Name", "Parcel ID"});
        JScrollPane customersScrollPane = new JScrollPane(customersTable);
        customersScrollPane.setBorder(BorderFactory.createTitledBorder("Customers"));

        splitPane.setLeftComponent(parcelsScrollPane);
        splitPane.setRightComponent(customersScrollPane);
        add(splitPane, BorderLayout.CENTER);

        // Bottom Panel: Controls
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

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
        resetButton = new JButton("Reset");

        // Row 1: Search
        gbc.gridx = 0;
        gbc.gridy = 0;
        bottomPanel.add(new JLabel("Search Parcel:"), gbc);
        gbc.gridx = 1;
        bottomPanel.add(searchParcelTxt, gbc);
        gbc.gridx = 2;
        bottomPanel.add(searchButton, gbc);
        gbc.gridx = 3;
        bottomPanel.add(resetButton, gbc);

        // Row 2: Parcel Info
        gbc.gridy = 1;
        gbc.gridx = 0;
        bottomPanel.add(new JLabel("Parcel ID:"), gbc);
        gbc.gridx = 1;
        bottomPanel.add(parcelIdTxt, gbc);
        gbc.gridx = 2;
        bottomPanel.add(new JLabel("Weight:"), gbc);
        gbc.gridx = 3;
        bottomPanel.add(weightTxt, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        bottomPanel.add(new JLabel("Status:"), gbc);
        gbc.gridx = 1;
        bottomPanel.add(statusTxt, gbc);
        gbc.gridx = 2;
        bottomPanel.add(new JLabel("Dimensions (W x H x L):"), gbc);
        gbc.gridx = 3;
        JPanel dimensionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        dimensionPanel.add(widthTxt);
        dimensionPanel.add(new JLabel(" x "));
        dimensionPanel.add(heightTxt);
        dimensionPanel.add(new JLabel(" x "));
        dimensionPanel.add(lengthTxt);
        bottomPanel.add(dimensionPanel, gbc);

        // Row 3: Buttons
        gbc.gridy = 3;
        gbc.gridx = 0;
        bottomPanel.add(addParcelButton, gbc);
        gbc.gridx = 1;
        bottomPanel.add(processParcelButton, gbc);
        gbc.gridx = 2;
        bottomPanel.add(editParcelButton, gbc);
        gbc.gridx = 3;
        bottomPanel.add(saveBtn, gbc);
        gbc.gridx = 4;
        bottomPanel.add(deleteBtn, gbc);

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
