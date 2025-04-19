package group57.ssf;

import group57.ssf.UserClasses.AddNewUserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    // Login View Components
    @FXML private AnchorPane LoginRightContainer;
    @FXML private Label AboutAccount;
    @FXML private ToggleButton UserLoginOptionBTN;

    // Data Collections
    protected ArrayList<String> adminAccessCode = new ArrayList<>();
    protected ArrayList<Integer> warehouseAccessCode = new ArrayList<>();
    protected ArrayList<String> CommunicatorOperatorAccessCode = new ArrayList<>();
    private ArrayList<String> teamList = new ArrayList<>();
    private ArrayList<String> missionList = new ArrayList<>();
    private ArrayList<String> inventoryList = new ArrayList<>();
    private ArrayList<String> weaponsList = new ArrayList<>();
    private ArrayList<String> ammoList = new ArrayList<>();
    private ArrayList<String> fuelList = new ArrayList<>();
    private ArrayList<String> vehicleList = new ArrayList<>();
    private ArrayList<String> mediKitList = new ArrayList<>();

    // Controllers
    private LogInViewController loginViewController;
    private AddNewUserController signUpViewController;
    @FXML
    private AnchorPane LoginLeftContainer;
    @FXML
    private SplitPane LoginSplitPane;

    @FXML
    public void initialize() {
        loadLoginView();
    }

    private void loadLoginView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/group57/ssf/LoginView.fxml"));
            Pane loginView = loader.load();
            loginViewController = loader.getController();
            loginViewController.setMainController(this);

            LoginRightContainer.getChildren().setAll(loginView);
            setLoginViewState(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSignUpView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/group57/ssf/Rabib/AdminUser/AddNewUserPane.fxml"));
            Pane signUpView = loader.load();
            signUpViewController = loader.getController();
            signUpViewController.setMainController(this);

            LoginRightContainer.getChildren().setAll(signUpView);
            setLoginViewState(false);

        } catch (IOException e) {
            System.out.println("Failed to load signup view: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void setLoginViewState(boolean isLoginVisible) {
        if(isLoginVisible) {
            UserLoginOptionBTN.setText("Sign Up");
            AboutAccount.setText("Create new account?");
        } else {
            UserLoginOptionBTN.setText("Log In");
            AboutAccount.setText("Already have an account?");
        }
    }

    @FXML
    void UserLoginChoiceBTN(ActionEvent event) {
        if(UserLoginOptionBTN.getText().equals("Sign Up")) {
            loadSignUpView();
        } else {
            loadLoginView();
        }
    }

    @Deprecated
    void LogInCheckBTN(ActionEvent actionEvent) {
        // Delegate to login view controller
        loginViewController.handleLogin();
    }



    // Getters for data access
    public ArrayList<String> getAdminAccessCode() { return adminAccessCode; }
    public ArrayList<Integer> getWarehouseAccessCode() { return warehouseAccessCode; }
    public ArrayList<String> getCommunicatorOperatorAccessCode() { return CommunicatorOperatorAccessCode; }
}