package group57.ssf.Rabib_2221005;

import group57.ssf.nonUser.Team;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class MissionCostViewController {
    @javafx.fxml.FXML
    private Label MissionCost_Ammo;
    @javafx.fxml.FXML
    private Label MissionCost_Medikit;
    @javafx.fxml.FXML
    private Label MissionCost_Reserve;
    @javafx.fxml.FXML
    private ComboBox<Team> MissionCost_SelectTeam;
    @javafx.fxml.FXML
    private Label MissionCost_Equipment;
    @javafx.fxml.FXML
    private Label MissionCost_Fules;
    @javafx.fxml.FXML
    private Label MissionCost_Transportation;
    @javafx.fxml.FXML
    private Label MissionCost_TotalSalary;
    @javafx.fxml.FXML
    private Label MissionCost_TotalFinal;
    @javafx.fxml.FXML
    private Label MissionCost_Items_Total;

    @javafx.fxml.FXML
    public void MissionCost_GenerateReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void appendAndSaveDataToExistingFile(ActionEvent actionEvent) {
    }
}
