package group57.ssf.nonUser;

import group57.ssf.InventoryCollection.InventoryItems;
import group57.ssf.Safin_1921111.Commander;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private ComboBox<Commander> CreateTeam_SelectCommander;
    @javafx.fxml.FXML
    private Label TeamMemberNameDisplay;
    @javafx.fxml.FXML
    private ComboBox<String> CreateTeam_TeamStatus;
    @javafx.fxml.FXML
    private TextField CreateTeam_Area;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void CreateNewTeam(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void AddMemberToTeam(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void AssignInventoryItemToTeam(ActionEvent actionEvent) {
    }
}