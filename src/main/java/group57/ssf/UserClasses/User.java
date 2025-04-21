package group57.ssf.UserClasses;

import java.io.Serializable;

public class User implements Serializable {
    // Fields as specified in the image
    private int id;          // unique identifier
    private String password;
    private String fullName;
    private String email;
    private String contact;
    private String bloodType;
    private String gender;
    private String role;
    private String status;
    private float salary;
    private static final long serialVersionUID = 1L;

    public User(int id) {
        this.id = id;
    }

    public User(int id, String password, String fullName, String email, String contact, String bloodType, String gender, String role, String status, float salary) {
        this.id = id;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.contact = contact;
        this.bloodType = bloodType;
        this.gender = gender;
        this.role = role;
        this.status = status;
        this.salary = salary;
    }

    // Method to update profile
    public void UpdateProfile() {
        // Implementation would go here
        System.out.println("User profile updated");
    }

    // Getters and setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}