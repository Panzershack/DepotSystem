/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import views.MainUI;
/**
 *
 * @author pasanpitigala
 */
public class MainController {

    private MainUI views;

    public MainController() {
        views = new MainUI();
        views.setVisible(true);

        // Redirect to Controller logic using view methods
        views.getAddParcelButton().addActionListener(e -> handleAddParcel());
        views.getProcessParcelButton().addActionListener(e -> handleProcessParcel());
        views.getAddCustomerButton().addActionListener(e -> handleAddCustomer());
    }

    private void handleAddParcel() {
        System.out.println("Logic for adding parcel in Controller");
    }

    private void handleProcessParcel() {
        System.out.println("Logic for processing parcel in Controller");
    }

    private void handleAddCustomer() {
        System.out.println("Logic for adding customer in Controller");
    }
}
