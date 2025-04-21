package group57.ssf.InventoryCollection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fuels extends InventoryItems implements Serializable {
    private ArrayList<Vehicle> bestFor; // ArrayList of compatible vehicle types (e.g., ["Truck", "Helicopter"])

    public Fuels(String category, String model, String status, String serialNumber,
                 double price, int quantity, ArrayList<Vehicle> bestFor) {
        super(category, model, status, serialNumber, price, quantity);
        this.bestFor = bestFor;
    }

    // Getters and Setters
    public ArrayList<Vehicle> getBestFor() { return bestFor; }
    public void setBestFor(ArrayList<Vehicle> bestFor) { this.bestFor = bestFor; }

    // Check compatibility with a vehicle type
    public boolean isCompatible(String vehicleType) {
        return bestFor.contains(vehicleType);
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", BestFor=" + bestFor + '}';
    }
}