package group57.ssf.nonUser;

import java.time.LocalDate;
import java.util.List;

public class ResupplyRequest {
    private int supplyId; // Unique identifier
    private int requestTeamId;
    private int currentLocation;
    private LocalDate timeLimit;
    private int missionId;
    private List<String> requestItems;
    private String requestStatus; // e.g., "Pending", "Approved", "Denied", "Fulfilled"

    public ResupplyRequest(int supplyId, int requestTeamId, int currentLocation,
                           LocalDate timeLimit, int missionId, List<String> requestItems) {
        this.supplyId = supplyId;
        this.requestTeamId = requestTeamId;
        this.currentLocation = currentLocation;
        this.timeLimit = timeLimit;
        this.missionId = missionId;
        this.requestItems = requestItems;
        this.requestStatus = "Pending"; // Default status
    }

    // Getters and Setters
    public int getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(int supplyId) {
        this.supplyId = supplyId;
    }

    public int getRequestTeamId() {
        return requestTeamId;
    }

    public void setRequestTeamId(int requestTeamId) {
        this.requestTeamId = requestTeamId;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public LocalDate getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(LocalDate timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    public List<String> getRequestItems() {
        return requestItems;
    }

    public void setRequestItems(List<String> requestItems) {
        this.requestItems = requestItems;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    // Method to add an item to the request
    public void addRequestItem(String item) {
        this.requestItems.add(item);
    }

    // Method to remove an item from the request
    public void removeRequestItem(String item) {
        this.requestItems.remove(item);
    }

    // Method to check if request is urgent (time limit is within 3 days)
    public boolean isUrgent() {
        return LocalDate.now().plusDays(3).isAfter(timeLimit);
    }

    @Override
    public String toString() {
        return "ResupplyRequest{" +
                "supplyId=" + supplyId +
                ", requestTeamId=" + requestTeamId +
                ", currentLocation=" + currentLocation +
                ", timeLimit=" + timeLimit +
                ", missionId=" + missionId +
                ", requestItems=" + requestItems +
                ", requestStatus='" + requestStatus + '\'' +
                '}';
    }
}