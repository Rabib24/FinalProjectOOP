package group57.ssf.Saida_2220179;


import group57.ssf.UserClasses.User;

import java.io.Serializable;

public class CommunicationOfficer extends User implements Serializable {
    private String radioFrequencyAccessCode;
    private String encryptionProtocol;
    private String teamID;

    public CommunicationOfficer(int id, String password, String fullName, String email, String contact, String bloodType, String gender, String role, String status, float salary, String radioFrequencyAccessCode, String encryptionProtocol, String teamID) {
        super(id, password, fullName, email, contact, bloodType, gender, role, status, salary);
        this.radioFrequencyAccessCode = radioFrequencyAccessCode;
        this.encryptionProtocol = encryptionProtocol;
        this.teamID = teamID;
    }

    public String getRadioFrequencyAccessCode() {
        return radioFrequencyAccessCode;
    }

    public void setRadioFrequencyAccessCode(String radioFrequencyAccessCode) {
        this.radioFrequencyAccessCode = radioFrequencyAccessCode;
    }

    public String getEncryptionProtocol() {
        return encryptionProtocol;
    }

    public void setEncryptionProtocol(String encryptionProtocol) {
        this.encryptionProtocol = encryptionProtocol;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }
}

