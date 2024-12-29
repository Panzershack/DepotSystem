package depotLauncherApp;

import controllers.MainController;

/**
 * Entry point for the Parcel Management System application.
 */
public class Application {
    public static void main(String[] args) {
        // Launches the MainController, which initializes the GUI and handles logic
        new MainController();
    }
}
