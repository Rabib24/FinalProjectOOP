package group57.ssf.InventoryCollection;

import java.util.ArrayList;

public class Ammos extends InventoryItems {
    private float size;
    private ArrayList<String> supportedWeapons; // List of weapon types this ammo fits

    public Ammos(String category, String model, String status, String serialNumber,
                double price, int quantity, float size) {
        super(category, model, status, serialNumber, price, quantity);
        this.size = size;
        this.supportedWeapons = new ArrayList<>();
    }

    // Getters and Setters
    public float getSize() { return size; }
    public void setSize(float size) { this.size = size; }

    public ArrayList<String> getSupportedWeapons() { return supportedWeapons; }
    public void addSupportedWeapon(String weaponType) {
        supportedWeapons.add(weaponType);
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() +
                ", Size=" + size +
                ", SupportedWeapons=" + supportedWeapons + '}';
    }
}