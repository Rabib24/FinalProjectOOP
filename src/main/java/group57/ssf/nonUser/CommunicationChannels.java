package group57.ssf.nonUser;

public class CommunicationChannels {
    private float frequencyID; // Unique identifier
    private String encryptionProtocol;
    private String managedBy; // e.g., "Admin", "Team Leader"

    public CommunicationChannels(float frequencyID, String encryptionProtocol, String managedBy) {
        this.frequencyID = frequencyID;
        this.encryptionProtocol = encryptionProtocol;
        this.managedBy = managedBy;
    }

    // Getters and Setters
    public float getFrequencyID() { return frequencyID; }
    public void setFrequencyID(float frequencyID) { this.frequencyID = frequencyID; }

    public String getEncryptionProtocol() { return encryptionProtocol; }
    public void setEncryptionProtocol(String encryptionProtocol) { this.encryptionProtocol = encryptionProtocol; }

    public String getManagedBy() { return managedBy; }
    public void setManagedBy(String managedBy) { this.managedBy = managedBy; }

    // Method to change encryption protocol
    public void updateEncryption(String newProtocol) {
        this.encryptionProtocol = newProtocol;
        System.out.println("Encryption updated to: " + newProtocol);
    }

    @Override
    public String toString() {
        return "CommunicationChannels{" +
                "frequencyID=" + frequencyID +
                ", encryptionProtocol='" + encryptionProtocol + '\'' +
                ", managedBy='" + managedBy + '\'' +
                '}';
    }
}