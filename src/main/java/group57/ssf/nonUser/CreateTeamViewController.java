package group57.ssf.nonUser;

import group57.ssf.InventoryCollection.InventoryItems;
import group57.ssf.MainController;
import group57.ssf.Safin_1921111.Commander;
import group57.ssf.UserClasses.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CreateTeamViewController
{
    @javafx.fxml.FXML
    private TextField CreateTeam_TeamName;
    @javafx.fxml.FXML
    private ComboBox<String> CreateTeam_SelectCategory;
    @javafx.fxml.FXML
    private ComboBox<InventoryItems> CreateTeam_SelectInventoryItems;
    @javafx.fxml.FXML
    private TextField CreateTeam_ItemsQuantity;
    @javafx.fxml.FXML
    private ComboBox<String> CreateTeam_ChoiceMembers;
    @javafx.fxml.FXML
    private TextArea CreateTeam_TeamDescription;
    @javafx.fxml.FXML
    private TextField CreateTeam_Frequency;
    @javafx.fxml.FXML
    private ComboBox<Mission> CreateTeam_MissionList;
    @javafx.fxml.FXML
    private Label TeamInventoryDisplay;
    @javafx.fxml.FXML
    private ComboBox<String> CreateTeam_SelectCommander;
    @javafx.fxml.FXML
    private Label TeamMemberNameDisplay;
    @javafx.fxml.FXML
    private ComboBox<String> CreateTeam_TeamStatus;
    @javafx.fxml.FXML
    private TextField CreateTeam_Area;

    private MainController mainController;
    private User loggedInUser;

    public void setMainController(MainController mainController, User user) {
        this.mainController = mainController;
        this.loggedInUser  = user;
    }

    @javafx.fxml.FXML
    public void initialize() {
        CreateTeam_SelectCommander.getItems().addAll();
    }

    @FXML
    public void CreateNewTeam(ActionEvent actionEvent) {
        // Step 1: Collect team details
        String teamName = CreateTeam_TeamName.getText().trim();
        String area = CreateTeam_Area.getText().trim();
        String commander = CreateTeam_SelectCommander.getValue();
        String teamDescription = CreateTeam_TeamDescription.getText().trim();
        String teamStatus = CreateTeam_TeamStatus.getValue();
        Mission assignedMission = CreateTeam_MissionList.getValue();

        // Step 2: Perform validations
        if (!validateTeamDetails(teamName, area, commander, teamStatus, assignedMission)) {
            return; // Validation failed, exit the method
        }

        // Step 3: Create the team object
        Team newTeam = new Team(assignedMission.getMissionID(), teamName, area, commander, new ArrayList<User>(), teamDescription);

        // Step 4: Save the team details to a binary file
        if (saveTeamToFile(newTeam)) {
            System.out.println("Team created successfully");
            // Display success message to the user
        } else {
            System.out.println("Failed to create Team");
            // Display error message to the user
        }
    }

    private boolean validateTeamDetails(String teamName, String area, String commander, String teamStatus, Mission assignedMission) {
        // Check if team name is unique
        if (isTeamNameDuplicate(teamName)) {
            System.out.println("Team name must be unique");
            return false;
        }

        // Check if area is valid
        if (area.isEmpty()) {
            System.out.println("Area cannot be empty");
            return false;
        }

        // Check if commander is selected
        if (commander == null) {
            System.out.println("Please select a commander");
            return false;
        }

        // Check if team status is selected
        if (teamStatus == null) {
            System.out.println("Please select a team status");
            return false;
        }

        // Check if assigned mission is valid
        if (assignedMission != null && !isMissionValid(assignedMission)) {
            System.out.println("Invalid mission assignment");
            return false;
        }

        // Additional validations can be added here

        return true; // All validations passed
    }

    private boolean isTeamNameDuplicate(String teamName) {
        // Logic to check for duplicate team names in the database or file
        // This could involve reading existing teams from a file and checking if the name already exists
        return false; // Placeholder return value
    }

    private boolean isMissionValid(Mission mission) {
        // Logic to check if the mission exists and is not already assigned to another team
        return true; // Placeholder return value
    }

    private boolean saveTeamToFile(Team team) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teams.bin", true))) {
            oos.writeObject(team);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @javafx.fxml.FXML
    public void AddMemberToTeam(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void AssignInventoryItemToTeam(ActionEvent actionEvent) {
    }
}