package group57.ssf.InventoryCollection;

public class Weapons extends InventoryItems {
    private String weaponType;
    private String status; // Operational/Damaged
    private String ammoType; // e.g., "9mm", "5.56mm"

    public Weapons(String category, String model, String status, String serialNumber,
                  double price, int quantity, String weaponType, String ammoType) {
        super(category, model, status, serialNumber, price, quantity);
        this.weaponType = weaponType;
        this.ammoType = ammoType;
        this.status = "Operational"; // Default status
    }

    // Getters and Setters
    public String getWeaponType() { return weaponType; }
    public void setWeaponType(String weaponType) { this.weaponType = weaponType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAmmoType() { return ammoType; }
    public void setAmmoType(String ammoType) { this.ammoType = ammoType; }

    @Override
    public String displayInfo() {
        return super.displayInfo() +
                ", WeaponType='" + weaponType + '\'' +
                ", Status='" + status + '\'' +
                ", AmmoType='" + ammoType + '\'' +
                '}';
    }
}