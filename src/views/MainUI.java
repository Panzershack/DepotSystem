/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author pasanpitigala
 */
public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form mainUI
     */
    public MainUI() {
        initComponents();
        startClock();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        parcelsTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        customersTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        parcelIdLbl = new javax.swing.JLabel();
        weightLbl = new javax.swing.JLabel();
        statusLbl = new javax.swing.JLabel();
        parcelIdTxt = new javax.swing.JTextField();
        weightTxt = new javax.swing.JTextField();
        statusTxt = new javax.swing.JTextField();
        dimensionsLbl = new javax.swing.JLabel();
        widthLbl = new javax.swing.JLabel();
        heightLbl = new javax.swing.JLabel();
        lengthLbl = new javax.swing.JLabel();
        widthTxt = new javax.swing.JTextField();
        heightTxt = new javax.swing.JTextField();
        lengthTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        addParcelButton = new javax.swing.JButton();
        processParcelButton = new javax.swing.JButton();
        dateTimeLbl = new javax.swing.JLabel();
        editParcelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchParcelTxt = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Depot System");

        parcelsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parcel ID", "Weight", "Dimension", "Parcel Status", "Days in Depot"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        parcelsTable.setShowGrid(true); // Enable grid lines
        parcelsTable.setGridColor(java.awt.Color.BLACK); // Set grid color to black
        parcelsTable.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12)); // Make headings bold
        parcelsTable.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK)); // Add border
        jScrollPane1.setViewportView(parcelsTable);

        customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sequence Number", "Name", "Parcel ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        customersTable.setShowGrid(true); // Enable grid lines
        customersTable.setGridColor(java.awt.Color.BLACK); // Set grid color to black
        customersTable.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12)); // Make headings bold
        customersTable.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK)); // Add border
        jScrollPane2.setViewportView(customersTable);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        parcelIdLbl.setText("Parcel ID:");

        weightLbl.setText("Weight:");

        statusLbl.setText("Status:");

        dimensionsLbl.setText("Dimensions:");

        widthLbl.setText("W:");

        heightLbl.setText("H:");

        lengthLbl.setText("L:");

        saveBtn.setText("Save");

        deleteBtn.setText("Delete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveBtn)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(parcelIdLbl)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(weightLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(statusLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(dimensionsLbl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(parcelIdTxt)
                            .addComponent(weightTxt)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(widthLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(widthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(heightLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(heightTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lengthLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lengthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(statusTxt))
                        .addGap(105, 105, 105))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parcelIdLbl)
                    .addComponent(parcelIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weightLbl)
                    .addComponent(weightTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLbl)
                    .addComponent(statusTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dimensionsLbl)
                    .addComponent(widthLbl)
                    .addComponent(heightLbl)
                    .addComponent(lengthLbl)
                    .addComponent(widthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heightTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lengthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(deleteBtn))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        addParcelButton.setText("Add Parcel");
        addParcelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addParcelButtonActionPerformed(evt);
            }
        });

        processParcelButton.setText("Process Parcel");
        processParcelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processParcelButtonActionPerformed(evt);
            }
        });

        dateTimeLbl.setText("DateTime");

        editParcelButton.setText("Edit Parcel");

        jLabel1.setText("Search Parcel:");

        searchButton.setText("Search");

        resetButton.setText("Reset Table");

        jLabel2.setText("Customers Table");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addParcelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editParcelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(processParcelButton)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchParcelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(resetButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dateTimeLbl, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(21, 171, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(searchParcelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton)
                            .addComponent(resetButton)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addParcelButton)
                            .addComponent(processParcelButton))
                        .addGap(18, 18, 18)
                        .addComponent(editParcelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateTimeLbl)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Exposing parcels table to controller
    public javax.swing.JTable getParcelsTable() {
        return parcelsTable;
    }

    // Exposing customers table to controller
    public javax.swing.JTable getCustomersTable() {
        return customersTable;
    }

    // Exposing buttons to controller
    public javax.swing.JButton getAddParcelButton() {
        return addParcelButton;
    }

    public javax.swing.JButton getProcessParcelButton() {
        return processParcelButton;
    }
    
    public javax.swing.JButton getEditParcelButton() {
        return editParcelButton;
    }
    
    public javax.swing.JButton getSaveParcelButton() {
        return saveBtn;
    }
    
    public javax.swing.JButton getDeleteParcelButton() {
        return deleteBtn;
    }
    
    public javax.swing.JTextField getSearchParcelTxt() {
        return searchParcelTxt;
    }

    public javax.swing.JButton getSearchButton() {
        return searchButton;
    }

    public javax.swing.JButton getResetButton() {
        return resetButton;
    }


    private void addParcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addParcelButtonActionPerformed
        System.out.println("Add Parcel button clicked!");
    }//GEN-LAST:event_addParcelButtonActionPerformed

    private void processParcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processParcelButtonActionPerformed
        System.out.println("Process Parcel button clicked!"); 
    }//GEN-LAST:event_processParcelButtonActionPerformed

    // Getter for Parcel ID Text Field
    public javax.swing.JTextField getParcelIdTxt() {
        return parcelIdTxt;
    }

    // Getter for Weight Text Field
    public javax.swing.JTextField getWeightTxt() {
        return weightTxt;
    }

    // Getter for Status Text Field
    public javax.swing.JTextField getStatusTxt() {
        return statusTxt;
    }

    // Getter for Width Text Field
    public javax.swing.JTextField getWidthTxt() {
        return widthTxt;
    }

    // Getter for Height Text Field
    public javax.swing.JTextField getHeightTxt() {
        return heightTxt;
    }

    // Getter for Length Text Field
    public javax.swing.JTextField getLengthTxt() {
        return lengthTxt;
    }


    public void addActionListener(java.awt.event.ActionListener listener) {
    addParcelButton.addActionListener(listener);
    processParcelButton.addActionListener(listener);
    editParcelButton.addActionListener(listener);
    saveBtn.addActionListener(listener);
    deleteBtn.addActionListener(listener);
    
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }
    


    public void startClock() {
        // Format for displaying date and time
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Create a Timer to update the clock every second
        Timer timer = new Timer(1000, e -> {
            String currentTime = formatter.format(new Date());
            dateTimeLbl.setText(currentTime);
        });

        // Start the timer
        timer.start();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addParcelButton;
    private javax.swing.JTable customersTable;
    private javax.swing.JLabel dateTimeLbl;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel dimensionsLbl;
    private javax.swing.JButton editParcelButton;
    private javax.swing.JLabel heightLbl;
    private javax.swing.JTextField heightTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lengthLbl;
    private javax.swing.JTextField lengthTxt;
    private javax.swing.JLabel parcelIdLbl;
    private javax.swing.JTextField parcelIdTxt;
    private javax.swing.JTable parcelsTable;
    private javax.swing.JButton processParcelButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchParcelTxt;
    private javax.swing.JLabel statusLbl;
    private javax.swing.JTextField statusTxt;
    private javax.swing.JLabel weightLbl;
    private javax.swing.JTextField weightTxt;
    private javax.swing.JLabel widthLbl;
    private javax.swing.JTextField widthTxt;
    // End of variables declaration//GEN-END:variables
}
