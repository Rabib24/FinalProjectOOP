package group57.ssf.Rabib_2221005;

import group57.ssf.UserClasses.User;

import java.io.Serializable;

public class LogisticManager extends User implements Serializable {
    // Additional fields from UML
    private String wareHouseAccessCode;
    private String phoneNumber;
    private String emailAddress;

    // Constructor (calls superclass constructor)
    public LogisticManager(int id, String password, String fullName, String email, String contact,
                           String bloodType, String gender, String role, String status, float salary,
                           String wareHouseAccessCode, String phoneNumber, String emailAddress) {
        super(id, password, fullName, email, contact, bloodType, gender, role, status, salary);
        this.wareHouseAccessCode = wareHouseAccessCode;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    // Getters & Setters for new fields
    public String getWareHouseAccessCode() {
        return wareHouseAccessCode;
    }

    public void setWareHouseAccessCode(String wareHouseAccessCode) {
        this.wareHouseAccessCode = wareHouseAccessCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    // Methods from UML
    public void requestSuppliesRespond() {
        System.out.println("Supplies request processed.");
    }

    public void updateInventory() {
        System.out.println("Inventory updated.");
    }

    public void assignVehicle() {
        System.out.println("Vehicle assigned.");
    }

    public void generateChartAndGraph() {
        System.out.println("Charts/graphs generated.");
    }

    public void calculateTotalCosting() {
        System.out.println("Total costing calculated.");
    }
}