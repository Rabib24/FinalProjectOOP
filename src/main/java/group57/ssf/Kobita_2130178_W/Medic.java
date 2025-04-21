package group57.ssf.Kobita_2130178_W;

import group57.ssf.UserClasses.User;

import java.io.Serializable;

public class Medic extends User implements Serializable {
    private String medicalLicenseNumber;

    public Medic(int id, String password, String fullName, String email, String contact, String bloodType, String gender, String role, String status, float salary, String medicalLicenseNumber) {
        super(id, password, fullName, email, contact, bloodType, gender, role, status, salary);
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    public String getMedicalLicenseNumber() { return medicalLicenseNumber; }
    public void setMedicalLicenseNumber(String medicalLicenseNumber) { this.medicalLicenseNumber = medicalLicenseNumber; }
}