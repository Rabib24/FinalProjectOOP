package group57.ssf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LogInViewController {
    @FXML private TextField LoginUsername;
    @FXML private Pane LoginArea;
    @FXML private Label LoginReportText;
    @FXML private PasswordField LoginPassword;

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void LogInCheckBTN(ActionEvent actionEvent) {
        String username = LoginUsername.getText().trim();
        String password = LoginPassword.getText().trim();

        // Validate input
        if (username.isEmpty() || password.isEmpty()) {
            showError("Username and password are required");
            return;
        }

        // Check against admin access codes (example validation)
        if (isValidAdmin(username, password)) {
            showSuccess("Admin login successful");
            // TODO: Proceed to admin dashboard
        }
        else if (isValidUser(username, password)) {
            showSuccess("Login successful");
            // TODO: Proceed to user dashboard
        }
        else {
            showError("Invalid credentials");
        }
    }

    private boolean isValidAdmin(String username, String password) {
        // Check against admin access codes from main controller
        return mainController.getAdminAccessCode().contains(password) &&
                username.equalsIgnoreCase("admin");
    }

    private boolean isValidUser(String username, String password) {
        // Add your user validation logic here
        // This is just a placeholder implementation
        return password.length() >= 8 &&
                username.matches("^[a-zA-Z0-9_]{4,20}$");
    }

    private void showError(String message) {
        LoginReportText.setStyle("-fx-text-fill: #ff4444;"); // Red color for errors
        LoginReportText.setText(message);
    }

    private void showSuccess(String message) {
        LoginReportText.setStyle("-fx-text-fill: #00C851;"); // Green color for success
        LoginReportText.setText(message);
    }

    // Helper method to clear the form
    public void clearForm() {
        LoginUsername.clear();
        LoginPassword.clear();
        LoginReportText.setText("");
    }

    public void handleLogin() {
    }
}