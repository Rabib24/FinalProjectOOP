package group57.ssf.InventoryCollection;

import java.io.Serializable;

public class InventoryItems extends Inventory implements Serializable {
    private String category, model, status, serialNumber;
    private double price;
    private int quantity;

    public InventoryItems()  {
    }

    public InventoryItems(String category, String model, String status, String serialNumber, double price, int quantity) {
        this.category = category;
        this.model = model;
        this.status = status;
        this.serialNumber = serialNumber;
        this.price = price;
        this.quantity = quantity;
    }

    public void AddToInventoryList(){}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String displayInfo(){
        return "InventoryItems{" +
                "category='" + category + '\'' +
                ", model='" + model + '\'' +
                ", status='" + status + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public String toString() {
        return "InventoryItems{" +
                "category='" + category + '\'' +
                ", model='" + model + '\'' +
                ", status='" + status + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
