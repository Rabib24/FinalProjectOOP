package group57.ssf;

import group57.ssf.Rabib_2221005.AdministratorDashboardViewController;
import group57.ssf.Rabib_2221005.LogisticManagerDashboardViewController;
import group57.ssf.UserClasses.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogInViewController {
    @FXML private TextField LoginUsername;
    @FXML private Pane LoginArea;
    @FXML private Label LoginReportText;
    @FXML private PasswordField LoginPassword;

    private MainController mainController;

    public void initialize(){
    }



    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void LogInCheckBTN(ActionEvent actionEvent) {
        String username = LoginUsername.getText().trim();
        String password = LoginPassword.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showError("Username and password are required");
            return;
        }

        User authenticatedUser = mainController.validateLogin(username, password);
        if (authenticatedUser != null) {
            showSuccess("Login successful!");
            redirectToDashboard(authenticatedUser);
        } else {
            showError("Invalid username or password");
        }
    }

    private void redirectToDashboard(User user) {
        try {
            String role = user.getRole().toLowerCase();
            String fxmlPath = "";

            // Map roles to FXML paths (update paths as per your project)
            switch (role) {
                case "administrator":
                    fxmlPath = "/group57/ssf/Rabib/AdminUser/AdministratorDashboardView.fxml";
                    break;
                case "logistic manager":
                    fxmlPath = "/group57/ssf/Rabib/LogisticUser/LogisticManagerDashboardView.fxml";
                    break;
                case "medic":
                    fxmlPath = "/group57/ssf/Kobita_W/MedicDashboardView.fxml";
                    break;
                case "commander":
                    fxmlPath = "/group57/ssf/Safin/CommanderDashboardView.fxml";
                    break;
                case "demolition":
                    fxmlPath = "/group57/ssf/Kobita_W/DemolitionDashboardView.fxml";
                    break;
                case "sniper":
                    fxmlPath = "/group57/ssf/Saida/SniperDashboardView.fxml";
                    break;
                case "communication officer":
                    fxmlPath = "/group57/ssf/Saida/CommunicationOfficerDashboardView.fxml";
                    break;
                case "field officer":
                    fxmlPath = "/group57/ssf/Safin/FieldOfficerDashboardView.fxml";
                    break;
                default:
                    showError("No dashboard found for role: " + role);
                    return;
            }
            System.out.println("user dashboard: LoginView: --> " + fxmlPath);

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            // Get the controller for the loaded FXML
            if (role.equals("administrator")) {
                AdministratorDashboardViewController adminController = loader.getController();
                adminController.setMainController(mainController, user); // Pass the user info
            } else if (role.equals("logistic manager")) {
                // Assuming you have a similar controller for Logistic Manager
                LogisticManagerDashboardViewController logisticController = loader.getController();
                logisticController.setMainController(mainController, user); // Pass the user info
            }
            // Add similar blocks for other roles if needed

            Stage stage = (Stage) LoginUsername.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(user.getRole() + " Dashboard");

        } catch (IOException e) {
            e.printStackTrace();
            showError("Failed to load dashboard");
        }
    }


    private void showError(String message) {
        LoginReportText.setStyle("-fx-text-fill: #ff4444;");
        LoginReportText.setText(message);
    }

    private void showSuccess(String message) {
        LoginReportText.setStyle("-fx-text-fill: #00C851;");
        LoginReportText.setText(message);
    }

}