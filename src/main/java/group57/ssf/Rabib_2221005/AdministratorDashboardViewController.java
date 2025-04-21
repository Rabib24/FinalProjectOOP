package group57.ssf.Rabib_2221005;

import group57.ssf.InventoryCollection.InventoryViewController;
import group57.ssf.MainController;
import group57.ssf.UserClasses.AddNewUserController;
import group57.ssf.UserClasses.User; // Import User class
import group57.ssf.nonUser.CreateTeamViewController;
import group57.ssf.nonUser.SendNotificationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AdministratorDashboardViewController {
    @FXML
    private MenuBar MenuBar;
    @FXML
    private Label ReportStatus;
    @FXML
    private BorderPane AdminDashboardBorderpan;

    // User information to be displayed
    private User loggedInUser ;
    @FXML
    private Pane CenterAdminDashboardBorderPane;

    // Method to set the main controller and user information
    private MainController mainController;
    public void setMainController(MainController mainController, User user) {
        this.mainController = mainController;
        this.loggedInUser  = user;
        System.out.println("Login User: " + user.getFullName());
        loadHomeDashboard(); // Load the home dashboard on initialization
    }
    public void initialize(){
//        loadHomeDashboard(); // Load the home dashboard on initialization
    }

    // Load the home dashboard
    private void loadHomeDashboard() {
        System.out.println("Loading Dashboard");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/group57/ssf/Rabib/AdminUser/AdminDashboardHomePane.fxml"));
            Pane homePane = loader.load();
            // Pass user information to the home controller
            DashboardHomePaneController homeController = loader.getController();
            homeController.setUserInfo(loggedInUser ); // Set user info

            CenterAdminDashboardBorderPane.getChildren().setAll(homePane);
        } catch (IOException e) {
            e.printStackTrace();
            ReportStatus.setText("Failed to load home dashboard");
        }
    }

    @FXML
    public void LogoutActionBTN(ActionEvent actionEvent) {
        // Logout logic here
    }

    @FXML
    public void SendMailBTN(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/group57/ssf/Rabib/AdminUser/SendNotificationView.fxml"));
            Pane NotificationPane = loader.load();

            SendNotificationController controller = loader.getController();
            controller.setMainController(mainController, loggedInUser);

            CenterAdminDashboardBorderPane.getChildren().setAll(NotificationPane);
        } catch (IOException e) {
            e.printStackTrace();
            ReportStatus.setText("Failed to load user creation form");
        }
    }

    @FXML
    public void FIndUserBTN(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/group57/ssf/Rabib/AdminUser/FindUserDetails.fxml"));
            Pane UserDetails = loader.load();

            FindUserDetailsController controller = loader.getController();
            controller.setMainController(mainController);

            CenterAdminDashboardBorderPane.getChildren().setAll(UserDetails);
        } catch (IOException e) {
            e.printStackTrace();
            ReportStatus.setText("Failed to load user creation form");
        }
    }

    @FXML
    public void AboutApplicationPopUp(ActionEvent actionEvent) {
        // About application logic here
    }

    @FXML
    public void GenerateReportBTN(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/group57/ssf/Rabib/AdminUser/GenerateReportPane.fxml"));
            Pane ReportPane = loader.load();

            GenerateReportPaneController controller = loader.getController();
            controller.setMainController(mainController, loggedInUser);

            CenterAdminDashboardBorderPane.getChildren().setAll(ReportPane);
        } catch (IOException e) {
            e.printStackTrace();
            ReportStatus.setText("Failed to load user creation form");
        }
    }

    @FXML
    public void LogoutActionBTN_Menu(ActionEvent actionEvent) {
        // Logout logic here
    }

    @FXML
    public void CreateNewUserBTN(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/group57/ssf/Rabib/AdminUser/AddNewUserPane.fxml"));
            Pane addUserPane = loader.load();

            AddNewUserController controller = loader.getController();
            controller.setMainController(mainController);

            CenterAdminDashboardBorderPane.getChildren().setAll(addUserPane);
        } catch (IOException e) {
            e.printStackTrace();
            ReportStatus.setText("Failed to load user creation form");
        }
    }

    @FXML
    public void ViewInventoryBTN(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/group57/ssf/Rabib/AdminUser/ViewInventoryPane.fxml"));
            Pane InventoryPane = loader.load();

            InventoryViewController controller = loader.getController();
            controller.setMainController(mainController, loggedInUser);

            CenterAdminDashboardBorderPane.getChildren().setAll(InventoryPane);
        } catch (IOException e) {
            e.printStackTrace();
            ReportStatus.setText("Failed to load user creation form");
        }
    }

    @FXML
    public void HelpPopUpWindow(ActionEvent actionEvent) {
        // Help popup logic here
    }

    @FXML
    public void CreateTeamBTN(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/group57/ssf/Rabib/AdminUser/CreateTeamPane.fxml"));
            Pane TeamPane = loader.load();

            CreateTeamViewController controller = loader.getController();
            controller.setMainController(mainController, loggedInUser);

            CenterAdminDashboardBorderPane.getChildren().setAll(TeamPane);
        } catch (IOException e) {
            e.printStackTrace();
            ReportStatus.setText("Failed to load user creation form");
        }
    }

    @FXML
    public void goToHome(ActionEvent actionEvent) {
        loadHomeDashboard();
    }
}