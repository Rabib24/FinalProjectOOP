package group57.ssf.nonUser;

import group57.ssf.UserClasses.User;
import group57.ssf.InventoryCollection.InventoryItems;
import java.util.List;

public class Team {
    private String assignedMissionID; // Foreign key to Mission
    private String teamName;
    private String area;
    private String commander;
    private List<User> teamMembers;
    private String teamDescription;
    private String teamStatus; // e.g., "Active", "On Leave", "Disbanded"
    private List<InventoryItems> equipmentInventory;
    private float radioChannels;
    private String creationTimestamp;

    public Team(String assignedMissionID, String teamName, String area,
                String commander, List<User> teamMembers, String teamDescription) {
        this.assignedMissionID = assignedMissionID;
        this.teamName = teamName;
        this.area = area;
        this.commander = commander;
        this.teamMembers = teamMembers;
        this.teamDescription = teamDescription;
        this.teamStatus = "Active";
        this.radioChannels = 0.0f;
        this.creationTimestamp = java.time.LocalDateTime.now().toString();
    }

    // Getters and Setters
    public String getAssignedMissionID() { return assignedMissionID; }
    public void setAssignedMissionID(String assignedMissionID) { this.assignedMissionID = assignedMissionID; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getCommander() { return commander; }
    public void setCommander(String commander) { this.commander = commander; }

    public List<User> getTeamMembers() { return teamMembers; }
    public void setTeamMembers(List<User> teamMembers) { this.teamMembers = teamMembers; }

    public String getTeamDescription() { return teamDescription; }
    public void setTeamDescription(String teamDescription) { this.teamDescription = teamDescription; }

    public String getTeamStatus() { return teamStatus; }
    public void setTeamStatus(String teamStatus) { this.teamStatus = teamStatus; }

    public List<InventoryItems> getEquipmentInventory() { return equipmentInventory; }
    public void setEquipmentInventory(List<InventoryItems> equipmentInventory) {
        this.equipmentInventory = equipmentInventory;
    }

    public float getRadioChannels() { return radioChannels; }
    public void setRadioChannels(float radioChannels) { this.radioChannels = radioChannels; }

    public String getCreationTimestamp() { return creationTimestamp; }
    public void setCreationTimestamp(String creationTimestamp) { this.creationTimestamp = creationTimestamp; }

    // Method to add a member to the team
    public void addTeamMember(User member) {
        teamMembers.add(member);
    }

    @Override
    public String toString() {
        return "Team{" +
                "assignedMissionID='" + assignedMissionID + '\'' +
                ", teamName='" + teamName + '\'' +
                ", area='" + area + '\'' +
                ", commander='" + commander + '\'' +
                ", teamMembers=" + teamMembers.size() +
                ", teamDescription='" + teamDescription + '\'' +
                ", teamStatus='" + teamStatus + '\'' +
                ", equipmentInventory=" + (equipmentInventory != null ? equipmentInventory.size() : 0) +
                ", radioChannels=" + radioChannels +
                ", creationTimestamp='" + creationTimestamp + '\'' +
                '}';
    }
}