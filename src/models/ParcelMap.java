package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages parcels using a Map data structure.
 * Provides methods to add, retrieve, and remove parcels.
 */
public class ParcelMap {
    private Map<String, Parcel> map;

    // Constructor
    public ParcelMap() {
        this.map = new HashMap<>();
    }

    // Add a parcel to the map
    public void addParcel(Parcel parcel) {
        map.put(parcel.getParcelID(), parcel);
    }

    // Get a parcel by ID
    public Parcel getParcel(String id) {
        return map.get(id);
    }

    // Remove a parcel by ID
    public void removeParcel(String id) {
        map.remove(id);
    }

    // Get all parcels (for display or processing)
    public Map<String, Parcel> getAllParcels() {
        return map;
    }

    // Check if a parcel exists
    public boolean containsParcel(String id) {
        return map.containsKey(id);
    }
}

