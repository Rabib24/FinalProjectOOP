package group57.ssf;

import group57.ssf.Rabib_2221005.Administrator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    @FXML
    private AnchorPane LoginRightContainer;
    @FXML
    private TextField input_FO_BatchNo;
    @FXML
    private TextField input_Commander_BatchNo;
    @FXML
    private TextField LoginUsername;
    @FXML
    private TextField select_Signup_Contact;
    @FXML
    private TextField input_Sniper_BatchNo;
    @FXML
    private TextField input_FO_AsignZone;
    @FXML
    private Pane madicSignup;
    @FXML
    private TextField input_madic_SpecializeField;
    @FXML
    private TextField input_Logistic_WarehouseCode;
    @FXML
    private Pane LoginArea;
    @FXML
    private Label AboutAccount;
    @FXML
    private Pane comOperatorSignup;
    @FXML
    private TextField input_FO_TeamId;
    @FXML
    private PasswordField LoginPassword;
    @FXML
    private TextField select_Signup_BloodType;
    @FXML
    private ComboBox<String> input_comOperator_EncyptionProtocol;
    @FXML
    private Pane demolitionSignup;
    @FXML
    private TextField input_logistic_WarehouseAddress;
    @FXML
    private Pane fieldOfficerSignup;
    @FXML
    private Pane SignUpArea1;
    @FXML
    private TextField inputAdmin_AccessCode;
    @FXML
    private ToggleButton UserLoginOptionBTN;
    @FXML
    private Label Generated_Signup_UserID;
    @FXML
    private DatePicker select_Signup_Dob;
    @FXML
    private Pane commanderSignup;
    @FXML
    private ComboBox<String> select_Signup_Gender;
    @FXML
    private TextField Input_comOperator_AccessCode;
    @FXML
    private TextField UserFulname;
    @FXML
    private TextField select_Signup_FullName;
    @FXML
    private Pane AdminSignup;
    @FXML
    private ComboBox<String> Input_Sniper_PrefferedWeapon;
    @FXML
    private TextField input_Madic_LisenceNo;
    @FXML
    private TextField inputCommanderSpecialize;
    @FXML
    private AnchorPane LoginLeftContainer;
    @FXML
    private Pane logisticManagerSignup;
    @FXML
    private TextField select_Signup_Email;
    @FXML
    private ComboBox<String> input_Commander_SecurityLevel;
    @FXML
    private Label LoginReportText;
    @FXML
    private Pane sniperSignup;
    @FXML
    private ComboBox<String> select_Signup_UserRole;

    protected ArrayList<String> adminAccessCode;  // 111 222 333 444 555
    protected ArrayList<Integer> warehouseAccessCode;
    protected ArrayList<String> CommunicatorOperatorAccessCode;



    private ArrayList<String> teamList;
    private ArrayList<String> missionList;
    private ArrayList<String> inventoryList;
    private ArrayList<String> weaponsList;
    private ArrayList<String> ammoList;
    private ArrayList<String> fuelList;
    private ArrayList<String> vehicleList;
    private ArrayList<String> mediKitList;
    @FXML
    private PasswordField select_Signup_Password;
    @FXML
    private Label SelectRoleAlertMSG;


    public void initialize(){
//        AdminAccessCode.addAll();
        input_Commander_SecurityLevel.getItems().addAll("5 TOP_SECRET_SCI(TS/SCI)", "4 TOP_SECRET(TS)", "3 SECRET(S)", "2 CONFIDENTIAL(C)", "1 RESTRICTED(R)");
//        TeamList;
        select_Signup_UserRole.getItems().addAll("Administrator","Commander", "Sniper", "Field Officer", "Communication Officer", "Demolition", "Logistic Manager", "medic" );
        select_Signup_Gender.getItems().addAll("Male","Female", "Other");


        // Add listener to handle selection changes
        select_Signup_UserRole.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> UpdateAccountCreationPane(newValue)
        );


    }

    private void UpdateAccountCreationPane(String AccountPane) throws IOError {
        if (AccountPane != null) {
            SelectRoleAlertMSG.setVisible(false);

            // Create list of all panes
            ArrayList<Pane> panList = new ArrayList<>();
            panList.add(AdminSignup);
            panList.add(commanderSignup);
            panList.add(fieldOfficerSignup);
            panList.add(comOperatorSignup);
            panList.add(sniperSignup);
            panList.add(logisticManagerSignup);
            panList.add(madicSignup);
            panList.add(demolitionSignup);

            // First set all panes to invisible
            for (Pane pane : panList) {
                pane.setVisible(false);
            }

            // Then show the selected pane
            switch (AccountPane) {
                case "Administrator":
                    AdminSignup.setVisible(true);
                    break;
                case "Commander":
                    commanderSignup.setVisible(true);
                    break;
                case "Field Officer":
                    fieldOfficerSignup.setVisible(true);
                    break;
                case "Logistic Manager":
                    logisticManagerSignup.setVisible(true);
                    break;
                case "Communication Officer":
                    comOperatorSignup.setVisible(true);
                    break;
                case "Demolition":
                    demolitionSignup.setVisible(true);
                    break;
                case "medic":
                    madicSignup.setVisible(true);
                    break;
                case "Sniper":
                    sniperSignup.setVisible(true);
                    break;

            }
        } else {
            SelectRoleAlertMSG.setText("No protocol selected");
        }
    }

    @FXML
    public void CreateMadicAccount(ActionEvent actionEvent) {
    }

    @FXML
    public void LogInCheckBTN(ActionEvent actionEvent) {
    }

    @FXML
    public void CreateCommanderAccount(ActionEvent actionEvent) {
    }

    @FXML
    public void createDemolitionerAccount(ActionEvent actionEvent) {
    }

    @FXML
    public void createLogisticManagerAccount(ActionEvent actionEvent) {
    }

    @FXML
    public void CreateSniperAccount(ActionEvent actionEvent) {
    }

    @FXML
    public void CreateCommunicatorAccount(ActionEvent actionEvent) {
    }

    @FXML
    public void CreateFieldOfficerAccount(ActionEvent actionEvent) {
    }

    @FXML
    public void CreateAdministratorAccount(ActionEvent actionEvent) {
    }

    @FXML
    void UserLoginChoiceBTN(ActionEvent event) {
        if (LoginArea.isVisible()){;
            SignUpArea1.setVisible(true);
            UserLoginOptionBTN.setText("Log In");
            LoginArea.setVisible(false);
            AboutAccount.setText("Already have an account?");

        }else {
            LoginArea.setVisible(true);
            UserLoginOptionBTN.setText("Sign up");
            SignUpArea1.setVisible(false);
//            SignUpfarmer.setVisible(false);
            AboutAccount.setText("Create new account?");
        }
    }

//    @FXML
    public int generateUserID(String SelectedRole) {
//        String userID = "";
//        switch (SelectedRole) {
//            case "Administrator":
//                userID = "1" + "000"+ "";
//                break;
//            case "Commander":
//                userID = "2" + "0"+ "";
//                break;
//            case "Field Officer":
//                userID = "3" + "0"+ "";
//                break;
//            case "Logistic Manager":
//                userID = "4" + "000"+ "";
//                break;
//            case "Sniper":
//                userID = "5" + "0"+ "";
//                break;
//            case "Communication Officer":
//                userID = "6" + "0"+ "";
//                break;
//            case "Demolition":
//                userID = "7" + "0"+ "";
//                break;
//            case "medic":
//                userID = "8" + "0"+ "";
//                break;
//
//        };
//
//        return Integer.parseInt(userID);
        return 0;
    }
}