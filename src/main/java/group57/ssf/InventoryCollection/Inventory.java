package group57.ssf.InventoryCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    private List<InventoryItems> items;

    public Inventory() {
       this.items = new ArrayList<InventoryItems>();
    }

    // Add item to inventory
    public boolean addItem(InventoryItems item) {

        return false;
    }


    public List<InventoryItems> getItemsByCategory(String category) {
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
    public List<InventoryItems> getAllFuel() {
        return getItemsByCategory("Fuel");
    }

    public List<InventoryItems> getAllVehicles() {
        return getItemsByCategory("Vehicle");
    }

    public List<InventoryItems> getAllMediKits() {
        return getItemsByCategory("Medical Kit");
    }

    public List<InventoryItems> getAllWeapons() {
        return getItemsByCategory("Weapon");
    }

    public List<InventoryItems> getAllAmmo() {
        return getItemsByCategory("Ammo");
    }

    // Display all items of a category
    public void displayAllItems(String category) {
        List<InventoryItems> categoryItems = getItemsByCategory(category);
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