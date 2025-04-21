package group57.ssf.UserClasses;

import group57.ssf.InventoryCollection.Weapons;
import group57.ssf.MainController;
import group57.ssf.Rabib_2221005.Administrator;
import group57.ssf.Rabib_2221005.LogisticManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.*;
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
    @FXML
    private TextField UserFulname;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
        mainController.setUsers(loadAllUsers());
    }

    private final String USER_DATA_FILE = "StoredInBin/Users.bin";

    private ArrayList<User> UserList = new MainController().getUsers();

    @FXML
    public void initialize() {
        initializeComboBoxes();
        select_Signup_UserRole.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> updateAccountCreationPane(newValue)
        );
    }

    private void initializeComboBoxes() {
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
    }

    private void updateAccountCreationPane(String accountType) {
        if (accountType != null) {
            SelectRoleAlertMSG.setVisible(false);
            hideAllRolePanes();
            showSelectedPane(accountType);
            Generated_Signup_UserID.setText(String.valueOf(generateUserID(accountType)));
        } else {
            SelectRoleAlertMSG.setText("Please select a role");
            SelectRoleAlertMSG.setVisible(true);
        }
    }

    private void hideAllRolePanes() {
        AdminSignup.setVisible(false);
        commanderSignup.setVisible(false);
        fieldOfficerSignup.setVisible(false);
        comOperatorSignup.setVisible(false);
        sniperSignup.setVisible(false);
        logisticManagerSignup.setVisible(false);
        madicSignup.setVisible(false);
        demolitionSignup.setVisible(false);
    }

    private void showSelectedPane(String accountType) {
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
    }

    private int generateUserID(String selectedRole) {
        int prefix = switch (selectedRole.toLowerCase()) {
            case "administrator" -> 1;
            case "commander" -> 2;
            case "field officer" -> 3;
            case "logistic manager" -> 4;
            case "sniper" -> 5;
            case "communication officer" -> 6;
            case "demolitioner" -> 7;
            case "medic" -> 8;
            default -> 0;
        };

        int userCount = mainController.getUsers().stream()
                .filter(u -> u.getRole().equalsIgnoreCase(selectedRole))
                .toList()
                .size();

        return prefix * 10000 + (userCount + 1);
    }

    private boolean validateCommonFields() {
        // Check for empty fields
        if (select_Signup_FullName.getText().isEmpty() ||
                select_Signup_Email.getText().isEmpty() ||
                select_Signup_Password.getText().isEmpty() ||
                select_Signup_Gender.getValue() == null ||
                select_Signup_Dob.getValue() == null) {
            showAlert("Error", "Please fill all required fields");
            return false;
        }

        // Check password length
        if (select_Signup_Password.getText().length() < 8) {
            showAlert("Error", "Password must be at least 8 characters");
            return false;
        }

        // Check User ID length
        String userId = Generated_Signup_UserID.getText();
        if (userId.length() != 5) {
            showAlert("Error", "User  ID must be exactly 5 characters long");
            return false;
        }

        // Check if access codes are valid (example for Administrator)
        if (select_Signup_UserRole.getValue().equals("Administrator")) {
            String accessCode = inputAdmin_AccessCode.getText();
            if (!mainController.getAdminAccessCode().contains(accessCode)) {
                showAlert("Error", "Invalid administrator access code");
                return false;
            }
        }

        // Check if access codes are valid (example for Logistic Manager)
        if (select_Signup_UserRole.getValue().equals("Logistic Manager")) {
            String warehouseCode = input_Logistic_WarehouseCode.getText();
            if (!mainController.getWarehouseAccessCode().contains(warehouseCode)) {
                showAlert("Error", "Invalid warehouse access code");
                return false;
            }
        }

        return true;
    }
    public void createAccount() {
        if (!validateCommonFields()) return;

        String role = select_Signup_UserRole.getValue();
        User newUser  = createUser (role);
        if (newUser  != null && saveUser (newUser )) {
            showAlert("Success", role + " account created successfully!\nUser  ID: " + Generated_Signup_UserID.getText());
            clearForm();
        } else {
            showAlert("Error", "Failed to save account data");
        }
    }

    private int getDefaultSalary(String role) {
        return switch (role.toLowerCase()) {
            case "administrator" -> 5000;
            case "logistic manager" -> 4000;
            case "commander" -> 3500;
            case "field officer" -> 3000;
            case "communication officer" -> 2800;
            case "sniper" -> 3200;
            case "demolition" -> 3000;
            case "medic" -> 2900;
            default -> 0; // Default salary if role is not recognized
        };
    }

    private User createUser (String role) {
        User baseUser  = new User(
                Integer.parseInt(Generated_Signup_UserID.getText()),
                select_Signup_Password.getText(),
                select_Signup_FullName.getText(),
                select_Signup_Email.getText(),
                select_Signup_Contact.getText(),
                select_Signup_BloodType.getText(),
                select_Signup_Gender.getValue(),
                role,
                "Active",
                getDefaultSalary(role) // Set default salary based on role
        );

        switch (role) {
            case "Administrator":
                Administrator admin = new Administrator(baseUser .getId(), baseUser .getPassword(), baseUser .getFullName(),
                        baseUser .getEmail(), baseUser .getContact(), baseUser .getBloodType(),
                        baseUser .getGender(), baseUser .getRole(), baseUser .getStatus(), baseUser .getSalary(),
                        baseUser .getId(), "Main Office", "Level 1");
                mainController.saveUserToAllFiles(baseUser , admin); // Save both base user and admin
                return admin;

            case "Logistic Manager":
                LogisticManager logisticUser  = new LogisticManager(baseUser .getId(), baseUser .getPassword(), baseUser .getFullName(),
                        baseUser .getEmail(), baseUser .getContact(), baseUser .getBloodType(),
                        baseUser .getGender(), baseUser .getRole(), baseUser .getStatus(), baseUser .getSalary(),
                        input_Logistic_WarehouseCode.getText(), baseUser .getContact(), baseUser .getEmail());
                mainController.saveUserToAllFiles(baseUser , logisticUser ); // Save both base user and logistic manager
                return logisticUser ;// Add cases for other roles as needed
            default:
                return baseUser ; // Return base user for roles not specifically handled
        }
    }



    private boolean saveUser (User user) {
        ArrayList<User> existingUsers = loadAllUsers();
        existingUsers.add(user);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_DATA_FILE))) {
            oos.writeObject(existingUsers);
            return true;
        } catch (IOException e) {
            showAlert("Error", "Failed to save user data: " + e.getMessage());
            return false;}
    }

    @SuppressWarnings("unchecked")
    private ArrayList<User> loadAllUsers() {
        File file = new File(USER_DATA_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_DATA_FILE))) {
            return (ArrayList<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            showAlert("Error", "Failed to load user data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void clearForm() {
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
        mainController.displayAllSavedData();
    }

    @FXML
    public void CreateMadicAccount(ActionEvent actionEvent) {
        createAccount();
    }

    @FXML
    public void CreateCommanderAccount(ActionEvent actionEvent) {
        createAccount();
    }

    @FXML
    public void createDemolitionerAccount(ActionEvent actionEvent) {
    }

    @FXML
    public void createLogisticManagerAccount(ActionEvent actionEvent) {
        createAccount();
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
        createAccount();
    }
}