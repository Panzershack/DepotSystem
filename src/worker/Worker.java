package worker;

import controllers.Manager;
import utils.Log;

/*
  Entry point for the Parcel Management System application.
 */
public class Worker {
    public static void main(String[] args) {
        // Launches the Manager, which initializes the GUI and handles logic
        new Manager();
        
        // Added a shutdown hook to close the logger
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Log.getInstance().close();
            System.out.println("Logger closed.");
        }));

    }
}
