package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static Log instance; // Single instance of the Log class
    private static final String LOG_FILE = "log.txt"; // Path to the log file
    private BufferedWriter writer;

    // Private constructor to prevent instantiation
    private Log() {
        try {
            // Initialize the BufferedWriter to append to the log file
            writer = new BufferedWriter(new FileWriter(LOG_FILE, true));
        } catch (IOException e) {
            System.err.println("Failed to initialize the log file: " + e.getMessage());
        }
    }

    // Public method to get the single instance of Log
    public static synchronized Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    // Method to log an action
    public synchronized void logAction(String action) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String logEntry = "[" + timestamp + "] " + action;
            writer.write(logEntry);
            writer.newLine();
            writer.flush(); // Ensure the log is written immediately
            System.out.println("Log entry: " + logEntry); // Optional: Print log to console for debugging
        } catch (IOException e) {
            System.err.println("Failed to write to the log file: " + e.getMessage());
        }
    }

    // Close the writer when the application shuts down
    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Failed to close the log file: " + e.getMessage());
        }
    }
}
