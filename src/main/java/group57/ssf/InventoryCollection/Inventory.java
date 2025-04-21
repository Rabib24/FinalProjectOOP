package group57.ssf.InventoryCollection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Inventory implements Serializable {
    private ArrayList<InventoryItems> items;

    public Inventory() {
       this.items = new ArrayList<InventoryItems>();
    }

    // Add item to inventory
    public void addItem(InventoryItems item) {
        items.add(item);
    }

    public ArrayList<InventoryItems> getItems() {
        return items;
    }

    public void setItems(ArrayList<InventoryItems> items) {
        this.items = items;
    }

    public ArrayList<InventoryItems> getItemsByCategory(String category) {
        // Validate input
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }

        // Safely handle null items list
        if (items == null) {
            return new ArrayList<>(); // Return empty list instead of null
        }

        return items.stream()
                .filter(item -> item != null) // Filter out null items
                .filter(item -> category.equalsIgnoreCase(item.getCategory()))
                .collect(Collectors.toCollection(ArrayList::new)); // Explicit ArrayList
    }

    // Specific category getters
    public ArrayList<InventoryItems> getAllFuel() {
        return getItemsByCategory("Fuel");
    }

    public ArrayList<InventoryItems> getAllVehicles() {
        return getItemsByCategory("Vehicle");
    }

    public ArrayList<InventoryItems> getAllMediKits() {
        return getItemsByCategory("Medical Kit");
    }

    public ArrayList<InventoryItems> getAllWeapons() {
        return getItemsByCategory("Weapon");
    }

    public ArrayList<InventoryItems> getAllAmmo() {
        return getItemsByCategory("Ammo");
    }

    // Display all items of a category
    public void displayAllItems(String category) {
        ArrayList<InventoryItems> categoryItems = getItemsByCategory(category);
        if (categoryItems.isEmpty()) {
            System.out.println("No " + category + " items found.");
        } else {
            System.out.println("--- " + category + " Items ---");
            categoryItems.forEach(InventoryItems::displayInfo);
        }
    }

    // Additional useful methods
    public int getTotalItemCount() {
        return items.size();
    }

    public double getInventoryValue() {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    public boolean removeItem(String serialNumber) {
        return items.removeIf(item -> item.getSerialNumber().equals(serialNumber));
    }

    public InventoryItems findItemBySerial(String serialNumber) {
        return items.stream()
                .filter(item -> item.getSerialNumber().equals(serialNumber))
                .findFirst()
                .orElse(null);
    }
}