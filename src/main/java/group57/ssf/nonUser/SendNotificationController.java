package group57.ssf.nonUser;

import group57.ssf.MainController;
import group57.ssf.UserClasses.User;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SendNotificationController
{
    @javafx.fxml.FXML
    private ComboBox<User> SentNotification_selectUser;
    @javafx.fxml.FXML
    private TextField SendNotification_Subject;
    @javafx.fxml.FXML
    private ComboBox<String> SendNotification_NotificationType;
    @javafx.fxml.FXML
    private TextField SendNotification_Tittle;
    @javafx.fxml.FXML
    private Label SendNotification_DestinationListView;
    @javafx.fxml.FXML
    private TextArea SendNotification_Message;

    private User CreatedBy;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void SendNotification_SendBTN(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SendNotification_AddUserToDestinationList(ActionEvent actionEvent) {
    }

    private MainController mainController;
    public void setMainController(MainController mainController, User user) {
        this.mainController = mainController;
        this.CreatedBy  = user;
    }
}