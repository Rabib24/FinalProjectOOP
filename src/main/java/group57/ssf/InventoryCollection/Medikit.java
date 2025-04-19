package group57.ssf.InventoryCollection;

import java.util.List;

public class Medikit extends InventoryItems {
    private List<String> items; // List of medical items (bandages, medicines, etc.)

    public Medikit(String category, String model, String status, String serialNumber,
                   double price, int quantity, List<String> items) {
        super(category, model, status, serialNumber, price, quantity);
        this.items = items;
    }

    // Getters and Setters
    public List<String> getItems() { return items; }
    public void setItems(List<String> items) { this.items = items; }

    // Method to check if an item exists in the medikit
    public boolean containsItem(String item) {
        return items.contains(item);
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", Items=" + items + '}';
    }
}