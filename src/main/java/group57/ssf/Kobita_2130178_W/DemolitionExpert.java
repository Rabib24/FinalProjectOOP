package group57.ssf.Kobita_2130178_W;


import group57.ssf.UserClasses.User;

import java.io.Serializable;

public class DemolitionExpert extends User implements Serializable {
    private String explosivesHandlingLicenseID;

    public DemolitionExpert(int id, String password, String fullName, String email, String contact, String bloodType, String gender, String role, String status, float salary, String explosivesHandlingLicenseID) {
        super(id, password, fullName, email, contact, bloodType, gender, role, status, salary);
        this.explosivesHandlingLicenseID = explosivesHandlingLicenseID;
    }

    public String getExplosivesHandlingLicenseID() { return explosivesHandlingLicenseID; }
    public void setExplosivesHandlingLicenseID(String explosivesHandlingLicenseID) { this.explosivesHandlingLicenseID = explosivesHandlingLicenseID; }
}