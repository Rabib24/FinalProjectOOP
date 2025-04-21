package group57.ssf.Rabib_2221005;

import group57.ssf.MainController;
import group57.ssf.UserClasses.User;
import group57.ssf.nonUser.SendNotificationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import javax.print.attribute.standard.Finishings;
import java.io.IOException;

public class LogisticManagerDashboardViewController {
    @javafx.fxml.FXML
    private BorderPane AdminDashboardBorderpan;
    @javafx.fxml.FXML
    private Label LogisticDashBoard_ReportStatus;
    @javafx.fxml.FXML
    private MenuBar MenuBar;
    @javafx.fxml.FXML
    private Pane CenterLogisticDashboardPane;

    // Method to set the main controller and user information
    private MainController mainController;
    private User loggedInUser;


    public void setMainController(MainController mainController, User user) {
        this.mainController = mainController;
        this.loggedInUser  = user;
        System.out.println("Login User: " + user.getFullName());
        loadHomeDashboard(); // Load the home dashboard on initialization
    }
    private void loadHomeDashboard() {
        System.out.println("Loading Dashboard");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/group57/ssf/Rabib/AdminUser/AdminDashboardHomePane.fxml"));
            Pane homePane = loader.load();
            // Pass user information to the home controller
            DashboardHomePaneController homeController = loader.getController();
            homeController.setUserInfo(loggedInUser ); // Set user info

            CenterLogisticDashboardPane.getChildren().setAll(homePane);
        } catch (IOException e) {
            e.printStackTrace();
            LogisticDashBoard_ReportStatus.setText("Failed to load home dashboard");
        }
    }

    @javafx.fxml.FXML
    public void LogisticDashBoard_GenerateMissionCost(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void AboutApplicationPopUp(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void LogisticDashBoard_CreateSupplyRequest(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void LogoutActionBTN_Menu(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void LogisticDashBoard_AddInventory(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/group57/ssf/Rabib/LogisticUser/AddInventoryView.fxml"));
            Pane NotificationPane = loader.load();

            AddInventoryViewController controller = loader.getController();
            controller.setMainController(mainController, loggedInUser);

            CenterLogisticDashboardPane.getChildren().setAll(NotificationPane);
        } catch (IOException e) {
            e.printStackTrace();
            LogisticDashBoard_ReportStatus.setText("Failed to load user creation form");
        }

    }

    @javafx.fxml.FXML
    public void LogisticDashBoard_LogoutActionBTN(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void LogisticDashBoard_MonitorInventory(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void LogisticDashBoard_ReviewResourceRequests(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void LogisticDashBoard_AnalyzeResources(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void LogisticDashBoard_editProfile(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void HelpPopUpWindow(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void LogisticDashBoard_AssignVehicle(ActionEvent actionEvent) {
    }

}
