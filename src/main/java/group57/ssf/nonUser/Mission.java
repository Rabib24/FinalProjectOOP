package group57.ssf.nonUser;


import group57.ssf.nonUser.Notification;
import java.util.List;

public class Mission {
    private String missionID; // Unique identifier
    private String title;
    private String location;
    private String description;
    private String assignedTeamId; // Foreign key to Team
    private String status; // e.g., "Planning", "Active", "Completed"

    public Mission(String missionID, String title, String location,
                   String description, String assignedTeamId) {
        this.missionID = missionID;
        this.title = title;
        this.location = location;
        this.description = description;
        this.assignedTeamId = assignedTeamId;
        this.status = "Planning";
    }

    // Getters and Setters
    public String getMissionID() { return missionID; }
    public void setMissionID(String missionID) { this.missionID = missionID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAssignedTeamId() { return assignedTeamId; }
    public void setAssignedTeamId(String assignedTeamId) { this.assignedTeamId = assignedTeamId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Method to send mission notifications
    public void SendNotification() {
        System.out.println("Mission update: " + title + " (Status: " + status + ")");
    }

    @Override
    public String toString() {
        return "Mission{" +
                "missionID='" + missionID + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", assignedTeamId='" + assignedTeamId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}