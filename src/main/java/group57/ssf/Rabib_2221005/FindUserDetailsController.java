package group57.ssf.Rabib_2221005;

import group57.ssf.MainController;
import group57.ssf.UserClasses.User;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FindUserDetailsController
{
    @javafx.fxml.FXML
    private TextField FindUserEmailInput;
    @javafx.fxml.FXML
    private Label FindUserReport_Location;
    @javafx.fxml.FXML
    private Label FindUserReport_FullName;
    @javafx.fxml.FXML
    private Label FindUserReport_Contact;
    @javafx.fxml.FXML
    private Label FindUserReport_MissionDuration;
    @javafx.fxml.FXML
    private Label FindUserReport_Role;
    @javafx.fxml.FXML
    private Label FindUserReport_MissionID;
    @javafx.fxml.FXML
    private ComboBox<String> FindUser_FilterSearchedBy;
    @javafx.fxml.FXML
    private Label FindUserReport_Salary;
    @javafx.fxml.FXML
    private Label FindUserReport_AssignedAmmo;
    @javafx.fxml.FXML
    private Label FindUserReport_AssignedVehicle;
    @javafx.fxml.FXML
    private Label FindUserReport_Gender;
    @javafx.fxml.FXML
    private Label FindUserReport_BloodType;
    @javafx.fxml.FXML
    private Label FindUserReport_TeamName;
    @javafx.fxml.FXML
    private Label FindUserReport_MissionStatus;
    @javafx.fxml.FXML
    private Label FindUserReport_Status;
    @javafx.fxml.FXML
    private Label FindUserReport_AssignedWeapon;
    @javafx.fxml.FXML
    private Label FindUserReport_Email;
    @javafx.fxml.FXML
    private Label FindUserReport_TeamCommander;
    private MainController mainController;
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void FindUserBTN(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ExportSearchedReportAsPDF(ActionEvent actionEvent) {
    }
}