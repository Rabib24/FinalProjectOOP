package group57.ssf.InventoryCollection;

import group57.ssf.MainController;
import group57.ssf.UserClasses.User;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class InventoryViewController
{
    @javafx.fxml.FXML
    private ComboBox MainTableFilter_Status;
//    @javafx.fxml.FXML
//    private TableColumn MainTable_Status;
    @javafx.fxml.FXML
    private Label ViewInventooryPane_TableReportBar;
//    @javafx.fxml.FXML
//    private TableColumn MainTable_Category;
//    @javafx.fxml.FXML
//    private TableColumn MainTable_Quantity;
//    @javafx.fxml.FXML
//    private TableColumn MainTable_Condition;
//    @javafx.fxml.FXML
//    private TableColumn MainTable_Tittle;
//    @javafx.fxml.FXML
//    private ComboBox MainTableFilter_Category;
//    @javafx.fxml.FXML
//    private TableView ViewInventoryPane_MainTable;
//    @javafx.fxml.FXML
//    private TableColumn<> MainTable_AssignedTeamID;
    private MainController mainController;
    private User loggedInUser;

    public void setMainController(MainController mainController, User user) {
        this.mainController = mainController;
        this.loggedInUser  = user;
    }
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void MainTableSavePDF(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void MainTable_FindItemsBTN(ActionEvent actionEvent) {
    }
}