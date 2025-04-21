package group57.ssf.Rabib_2221005;

import group57.ssf.UserClasses.User;
import javafx.scene.control.Label;

public class DashboardHomePaneController
{
    @javafx.fxml.FXML
    private Label HomeDashboard_Name;
    @javafx.fxml.FXML
    private Label HomeDashboard_Email;
    @javafx.fxml.FXML
    private Label HomeDashboard_userID;
    @javafx.fxml.FXML
    private Label HomeDashboard_Contact;

    @javafx.fxml.FXML
    public void initialize() {

    }

    public void setUserInfo(User user) {
        HomeDashboard_Name.setText(user.getFullName());
        HomeDashboard_Contact.setText(user.getContact());
        HomeDashboard_Email.setText(user.getEmail());
        HomeDashboard_userID.setText(Integer.toString(user.getId()));
    }
}