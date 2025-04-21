package group57.ssf.InventoryCollection;

import java.io.Serializable;
import java.util.ArrayList;

public class Medikit extends InventoryItems implements Serializable {
    private ArrayList<String> items; // List of medical items (bandages, medicines, etc.)

    public Medikit(String category, String model, String status, String serialNumber,
                   double price, int quantity, ArrayList<String> items) {
        super(category, model, status, serialNumber, price, quantity);
        this.items = items;
    }

//    @Override
//    public ArrayList<String> getItems() {
//        return items;
//    }
//
//    public void setItems(ArrayList<String> items) {
//        this.items = items;
//    }

    // Method to check if an item exists in the medikit
    public boolean containsItem(String item) {
        return items.contains(item);
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", Items=" + items + '}';
    }
}