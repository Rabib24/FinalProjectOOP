package group57.ssf.InventoryCollection;

import group57.ssf.UserClasses.User;

import java.io.Serializable;

public class Vehicle extends InventoryItems implements Serializable {
    private String vehicleType;
    private int licenseNo;
    private String assignStatus;
    private User assignTo;

    public Vehicle(String category, String model, String status, String serialNumber,
                   double price, int quantity, String vehicleType, int licenseNo) {
        super(category, model, status, serialNumber, price, quantity);
        this.vehicleType = vehicleType;
        this.licenseNo = licenseNo;
        this.assignStatus = "Unassigned"; // Default status
    }

    // Getters and Setters
    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public int getLicenseNo() { return licenseNo; }
    public void setLicenseNo(int licenseNo) { this.licenseNo = licenseNo; }

    public String getAssignStatus() { return assignStatus; }
    public void setAssignStatus(String assignStatus) { this.assignStatus = assignStatus; }

    public User getAssignTo() { return assignTo; }
    public void setAssignTo(User assignTo) {
        this.assignTo = assignTo;
        this.assignStatus = "Assigned";
    }

    // Override displayInfo
    @Override
    public String displayInfo() {
        return super.displayInfo() +
                ", VehicleType='" + vehicleType + '\'' +
                ", LicenseNo=" + licenseNo +
                ", AssignStatus='" + assignStatus + '\'' +
                ", AssignTo=" + (assignTo != null ? assignTo.getFullName() : "None") +
                '}';
    }
}