package group57.ssf.nonUser;

import group57.ssf.UserClasses.User;
import java.util.List;

public class Notification {
    private String notificationType;
    private String title;
    private String description;
    private String sourceID;
    private List<User> destinationID;
    private String status; // e.g., "Sent", "Pending", "Failed"

    public Notification(String notificationType, String title, String description,
                        String sourceID, List<User> destinationID) {
        this.notificationType = notificationType;
        this.title = title;
        this.description = description;
        this.sourceID = sourceID;
        this.destinationID = destinationID;
        this.status = "Pending";
    }

    // Getters and Setters
    public String getNotificationType() { return notificationType; }
    public void setNotificationType(String notificationType) { this.notificationType = notificationType; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSourceID() { return sourceID; }
    public void setSourceID(String sourceID) { this.sourceID = sourceID; }

    public List<User> getDestinationID() { return destinationID; }
    public void setDestinationID(List<User> destinationID) { this.destinationID = destinationID; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Method to send notification
    public void SendNotification() {
        System.out.println("Notification sent to " + destinationID.size() + " users.");
        this.status = "Sent";
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationType='" + notificationType + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", sourceID='" + sourceID + '\'' +
                ", destinationID=" + destinationID +
                ", status='" + status + '\'' +
                '}';
    }
}