package group57.ssf.Safin_1921111;

import group57.ssf.UserClasses.User;

import java.io.Serializable;

public class Commander extends User implements Serializable {
    private String assignedTeamID;
    private String badgeID;
    private String specialization;
    private String teamID;

    public Commander(int id, String password, String fullName, String email, String contact, String bloodType, String gender, String role, String status, float salary, String assignedTeamID, String badgeID, String specialization, String teamID) {
        super(id, password, fullName, email, contact, bloodType, gender, role, status, salary);
        this.assignedTeamID = assignedTeamID;
        this.badgeID = badgeID;
        this.specialization = specialization;
        this.teamID = teamID;
    }

    public String getAssignedTeamID() { return assignedTeamID; }
    public void setAssignedTeamID(String assignedTeamID) { this.assignedTeamID = assignedTeamID; }

    public String getBadgeID() { return badgeID; }
    public void setBadgeID(String badgeID) { this.badgeID = badgeID; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getTeamID() { return teamID; }
    public void setTeamID(String teamID) { this.teamID = teamID; }
}