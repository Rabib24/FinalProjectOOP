package group57.ssf.Saida_2220179;


import group57.ssf.UserClasses.User;

import java.io.Serializable;

public class Sniper extends User implements Serializable {
    private String sniperCertificationID;

    public Sniper(int id, String password, String fullName, String email, String contact, String bloodType, String gender, String role, String status, float salary, String sniperCertificationID) {
        super(id, password, fullName, email, contact, bloodType, gender, role, status, salary);
        this.sniperCertificationID = sniperCertificationID;
    }

    public String getSniperCertificationID() { return sniperCertificationID; }
    public void setSniperCertificationID(String sniperCertificationID) { this.sniperCertificationID = sniperCertificationID; }
}