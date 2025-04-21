package group57.ssf.Safin_1921111;

import group57.ssf.UserClasses.User;

import java.io.Serializable;

public class FieldOperative extends User implements Serializable {
    private String teamID;
    private String weaponLicenseNumber;

    public FieldOperative(int id, String password, String fullName, String email, String contact, String bloodType, String gender, String role, String status, float salary, String teamID, String weaponLicenseNumber) {
        super(id, password, fullName, email, contact, bloodType, gender, role, status, salary);
        this.teamID = teamID;
        this.weaponLicenseNumber = weaponLicenseNumber;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public String getWeaponLicenseNumber() {
        return weaponLicenseNumber;
    }

    public void setWeaponLicenseNumber(String weaponLicenseNumber) {
        this.weaponLicenseNumber = weaponLicenseNumber;
    }
}