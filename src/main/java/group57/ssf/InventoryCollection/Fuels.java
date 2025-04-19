package group57.ssf.InventoryCollection;

import java.util.List;

public class Fuels extends InventoryItems {
    private List<String> bestFor; // List of compatible vehicle types (e.g., ["Truck", "Helicopter"])

    public Fuels(String category, String model, String status, String serialNumber,
                 double price, int quantity, List<String> bestFor) {
        super(category, model, status, serialNumber, price, quantity);
        this.bestFor = bestFor;
    }

    // Getters and Setters
    public List<String> getBestFor() { return bestFor; }
    public void setBestFor(List<String> bestFor) { this.bestFor = bestFor; }

    // Check compatibility with a vehicle type
    public boolean isCompatible(String vehicleType) {
        return bestFor.contains(vehicleType);
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", BestFor=" + bestFor + '}';
    }
}