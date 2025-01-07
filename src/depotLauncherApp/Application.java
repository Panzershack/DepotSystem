package depotLauncherApp;

import controllers.MainController;
import utils.Log;

/*
  Entry point for the Parcel Management System application.
 */
public class Application {
    public static void main(String[] args) {
        // Launches the MainController, which initializes the GUI and handles logic
        new MainController();
        
        // Added a shutdown hook to close the logger
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Log.getInstance().close();
            System.out.println("Logger closed.");
        }));

    }
}
