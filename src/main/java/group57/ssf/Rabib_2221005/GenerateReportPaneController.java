package group57.ssf.Rabib_2221005;

import group57.ssf.MainController;
import group57.ssf.UserClasses.User;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class GenerateReportPaneController
{
//    @javafx.fxml.FXML
//    private TableColumn<TableColumn,> GenerateReport_Table_UserID;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_MissionDuration;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_AssignedWeapon;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_Salary;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_Email;
//    @javafx.fxml.FXML
//    private TableView GenerateReport_TableView;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_TeamName;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_Gender;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_AssignedAmmo;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_AssignedVehicle;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_UserID;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_MissionID;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_TeamCommander;
    @javafx.fxml.FXML
    private AnchorPane GenerateReport_View2;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_Role;
    @javafx.fxml.FXML
    private AnchorPane GenerateReport_View1;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_Location;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_FullName;
//    @javafx.fxml.FXML
//    private TableColumn GenerateReport_Table_GenerateBTN;
//    @javafx.fxml.FXML
//    private TableColumn GenerateReport_Table_SpecificField;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_Status;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_MissionStatus;
//    @javafx.fxml.FXML
//    private TableColumn GenerateReport_Table_FullName;
//    @javafx.fxml.FXML
//    private TableColumn GenerateReport_Table_Role;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_BloodType;
//    @javafx.fxml.FXML
//    private TableColumn GenerateReport_Table_Email;
    @javafx.fxml.FXML
    private Label GeneratedReportResult_Contact;
    @javafx.fxml.FXML
    private ComboBox<String> FindUser_FilterSearchedBy;

    private MainController mainController;
    private User loggedInUser;

    public void setMainController(MainController mainController, User user) {
        this.mainController = mainController;
        this.loggedInUser  = user;
        this.initialize();
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void FindUserToGenerateReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void GoBackToMainGenerateReportView(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ExportGeneratedReportResultAsPDF(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void GenerateReport_RoleSelection(ActionEvent actionEvent) {
    }
}