package group57.ssf.UserClasses;

import group57.ssf.InventoryCollection.Weapons;
import group57.ssf.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class AddNewUserController {
    // Common fields
    @FXML private TextField select_Signup_FullName;
    @FXML private TextField select_Signup_Email;
    @FXML private TextField select_Signup_Contact;
    @FXML private PasswordField select_Signup_Password;
    @FXML private ComboBox<String> select_Signup_Gender;
    @FXML private TextField select_Signup_BloodType;
    @FXML private DatePicker select_Signup_Dob;
    @FXML private ComboBox<String> select_Signup_UserRole;
    @FXML private Label Generated_Signup_UserID;
    @FXML private Label SelectRoleAlertMSG;
    @FXML private Pane SignUpContent;

    // Role-specific panes
    @FXML private Pane AdminSignup;
    @FXML private Pane commanderSignup;
    @FXML private Pane fieldOfficerSignup;
    @FXML private Pane comOperatorSignup;
    @FXML private Pane sniperSignup;
    @FXML private Pane logisticManagerSignup;
    @FXML private Pane madicSignup;
    @FXML private Pane demolitionSignup;

    // Admin fields
    @FXML private TextField inputAdmin_AccessCode;

    // Commander fields
    @FXML private TextField input_Commander_BatchNo;
    @FXML private ComboBox<String> input_Commander_SecurityLevel;
    @FXML private TextField inputCommanderSpecialize;

    // Field Officer fields
    @FXML private TextField input_FO_BatchNo;
    @FXML private TextField input_FO_TeamId;
    @FXML private TextField input_FO_AsignZone;

    // Communication Operator fields
    @FXML private TextField Input_comOperator_AccessCode;
    @FXML private ComboBox<String> input_comOperator_EncyptionProtocol;

    // Sniper fields
    @FXML private TextField input_Sniper_BatchNo;
    @FXML private ComboBox<Weapons> Input_Sniper_PrefferedWeapon;

    // Logistic Manager fields
    @FXML private TextField input_Logistic_WarehouseCode;
    @FXML private TextField input_logistic_WarehouseAddress;

    // Medic fields
    @FXML private TextField input_madic_SpecializeField;
    @FXML private TextField input_Madic_LisenceNo;

    private MainController mainController;
    private Random random = new Random();

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {
        // Initialize combo boxes
        input_Commander_SecurityLevel.getItems().addAll(
                "5 TOP_SECRET_SCI(TS/SCI)",
                "4 TOP_SECRET(TS)",
                "3 SECRET(S)",
                "2 CONFIDENTIAL(C)",
                "1 RESTRICTED(R)"
        );

        select_Signup_UserRole.getItems().addAll(
                "Administrator", "Commander", "Sniper", "Field Officer",
                "Communication Officer", "Demolition", "Logistic Manager", "medic"
        );

        select_Signup_Gender.getItems().addAll("Male", "Female", "Other");
        input_comOperator_EncyptionProtocol.getItems().addAll("AES-256", "RSA-2048", "Blowfish");

        // Add role selection listener
        select_Signup_UserRole.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> updateAccountCreationPane(newValue)
        );
    }

    private void updateAccountCreationPane(String accountType) {
        if (accountType != null) {
            SelectRoleAlertMSG.setVisible(false);

            // Hide all panes first
            AdminSignup.setVisible(false);
            commanderSignup.setVisible(false);
            fieldOfficerSignup.setVisible(false);
            comOperatorSignup.setVisible(false);
            sniperSignup.setVisible(false);
            logisticManagerSignup.setVisible(false);
            madicSignup.setVisible(false);
            demolitionSignup.setVisible(false);

            // Show selected pane
            switch (accountType) {
                case "Administrator": AdminSignup.setVisible(true); break;
                case "Commander": commanderSignup.setVisible(true); break;
                case "Field Officer": fieldOfficerSignup.setVisible(true); break;
                case "Logistic Manager": logisticManagerSignup.setVisible(true); break;
                case "Communication Officer": comOperatorSignup.setVisible(true); break;
                case "Demolition": demolitionSignup.setVisible(true); break;
                case "medic": madicSignup.setVisible(true); break;
                case "Sniper": sniperSignup.setVisible(true); break;
            }

            // Generate user ID when role is selected
            Generated_Signup_UserID.setText(String.valueOf(generateUserID(accountType)));
        } else {
            SelectRoleAlertMSG.setText("Please select a role");
            SelectRoleAlertMSG.setVisible(true);
        }
    }

    public int generateUserID(String selectedRole) {
        int prefix = switch (selectedRole) {
            case "Administrator" -> 1;
            case "Commander" -> 2;
            case "Field Officer" -> 3;
            case "Logistic Manager" -> 4;
            case "Sniper" -> 5;
            case "Communication Officer" -> 6;
            case "Demolition" -> 7;
            case "medic" -> 8;
            default -> 0;
        };
        return prefix * 10000 + random.nextInt(9000);
    }

    // Common validation method
    private boolean validateCommonFields() {
        if (select_Signup_FullName.getText().isEmpty() ||
                select_Signup_Email.getText().isEmpty() ||
                select_Signup_Password.getText().isEmpty() ||
                select_Signup_Gender.getValue() == null ||
                select_Signup_Dob.getValue() == null) {

            showAlert("Error", "Please fill all required fields");
            return false;
        }

        if (select_Signup_Password.getText().length() < 8) {
            showAlert("Error", "Password must be at least 8 characters");
            return false;
        }

        return true;
    }

    // Account creation methods
    @FXML
    public void CreateAdministratorAccount(ActionEvent actionEvent) {
        if (!validateCommonFields()) return;

        if (inputAdmin_AccessCode.getText().isEmpty() ||
                !mainController.getAdminAccessCode().contains(inputAdmin_AccessCode.getText())) {
            showAlert("Error", "Invalid admin access code");
            return;
        }

        // Create admin account logic
        showAlert("Success", "Administrator account created successfully");
    }

    @FXML
    public void CreateCommanderAccount(ActionEvent actionEvent) {
        if (!validateCommonFields()) return;

        if (input_Commander_BatchNo.getText().isEmpty() ||
                input_Commander_SecurityLevel.getValue() == null) {
            showAlert("Error", "Please fill all commander specific fields");
            return;
        }

        // Create commander account logic
        showAlert("Success", "Commander account created successfully");
    }

    @FXML
    public void CreateFieldOfficerAccount(ActionEvent actionEvent) {
        if (!validateCommonFields()) return;

        if (input_FO_BatchNo.getText().isEmpty() ||
                input_FO_TeamId.getText().isEmpty() ||
                input_FO_AsignZone.getText().isEmpty()) {
            showAlert("Error", "Please fill all field officer specific fields");
            return;
        }

        // Create field officer account logic
        showAlert("Success", "Field Officer account created successfully");
    }

    @FXML
    public void CreateCommunicatorAccount(ActionEvent actionEvent) {
        if (!validateCommonFields()) return;

        if (Input_comOperator_AccessCode.getText().isEmpty() ||
                input_comOperator_EncyptionProtocol.getValue() == null) {
            showAlert("Error", "Please fill all communication operator specific fields");
            return;
        }

        // Create communicator account logic
        showAlert("Success", "Communication Operator account created successfully");
    }

    @FXML
    public void CreateSniperAccount(ActionEvent actionEvent) {
        if (!validateCommonFields()) return;

        if (input_Sniper_BatchNo.getText().isEmpty() ||
                Input_Sniper_PrefferedWeapon.getValue() == null) {
            showAlert("Error", "Please fill all sniper specific fields");
            return;
        }

        // Create sniper account logic
        showAlert("Success", "Sniper account created successfully");
    }

    @FXML
    public void createLogisticManagerAccount(ActionEvent actionEvent) {
        if (!validateCommonFields()) return;

        if (input_Logistic_WarehouseCode.getText().isEmpty() ||
                input_logistic_WarehouseAddress.getText().isEmpty()) {
            showAlert("Error", "Please fill all logistic manager specific fields");
            return;
        }

        // Create logistic manager account logic
        showAlert("Success", "Logistic Manager account created successfully");
    }

    @FXML
    public void CreateMadicAccount(ActionEvent actionEvent) {
        if (!validateCommonFields()) return;

        if (input_madic_SpecializeField.getText().isEmpty() ||
                input_Madic_LisenceNo.getText().isEmpty()) {
            showAlert("Error", "Please fill all medic specific fields");
            return;
        }

        // Create medic account logic
        showAlert("Success", "Medic account created successfully");
    }

    @FXML
    public void createDemolitionerAccount(ActionEvent actionEvent) {
        if (!validateCommonFields()) return;

        // Create demolition account logic
        showAlert("Success", "Demolition account created successfully");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void clearForm() {
        // Clear all common fields
        select_Signup_FullName.clear();
        select_Signup_Email.clear();
        select_Signup_Contact.clear();
        select_Signup_Password.clear();
        select_Signup_Gender.getSelectionModel().clearSelection();
        select_Signup_BloodType.clear();
        select_Signup_Dob.setValue(null);
        select_Signup_UserRole.getSelectionModel().clearSelection();
        Generated_Signup_UserID.setText("");

        // Clear all role-specific fields
        inputAdmin_AccessCode.clear();
        input_Commander_BatchNo.clear();
        input_Commander_SecurityLevel.getSelectionModel().clearSelection();
        inputCommanderSpecialize.clear();
        input_FO_BatchNo.clear();
        input_FO_TeamId.clear();
        input_FO_AsignZone.clear();
        Input_comOperator_AccessCode.clear();
        input_comOperator_EncyptionProtocol.getSelectionModel().clearSelection();
        input_Sniper_BatchNo.clear();
        Input_Sniper_PrefferedWeapon.getSelectionModel().clearSelection();
        input_Logistic_WarehouseCode.clear();
        input_logistic_WarehouseAddress.clear();
        input_madic_SpecializeField.clear();
        input_Madic_LisenceNo.clear();
    }
}