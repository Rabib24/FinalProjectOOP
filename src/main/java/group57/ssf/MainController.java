package group57.ssf;

import group57.ssf.InventoryCollection.*;
import group57.ssf.Kobita_2130178_W.DemolitionExpert;
import group57.ssf.Kobita_2130178_W.Medic;
import group57.ssf.Rabib_2221005.Administrator;
import group57.ssf.Rabib_2221005.LogisticManager;
import group57.ssf.Safin_1921111.Commander;
import group57.ssf.Safin_1921111.FieldOperative;
import group57.ssf.Saida_2220179.CommunicationOfficer;
import group57.ssf.Saida_2220179.Sniper;
import group57.ssf.UserClasses.AddNewUserController;
import group57.ssf.UserClasses.User;
import group57.ssf.nonUser.Mission;
import group57.ssf.nonUser.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainController {
    // Login View Components
    @FXML private AnchorPane LoginRightContainer;
    @FXML private Label AboutAccount;
    @FXML private ToggleButton UserLoginOptionBTN;

    // Data Collections
    protected ArrayList<String> adminAccessCode = new ArrayList<>(List.of("ADMIN2023", "ROOTACCESS", "SECUREADMIN"));
    protected ArrayList<String> warehouseAccessCode = new ArrayList<>(List.of("WH001", "WH002", "WH003", "WH004"));
    protected ArrayList<String> communicatorOperatorAccessCode = new ArrayList<>(List.of("COMSEC1", "COMSEC2", "COMSEC3"));

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Team> teamList = new ArrayList<>();
    private ArrayList<Mission> missionList = new ArrayList<>();
    private ArrayList<Inventory> inventoryList = new ArrayList<>();
    private ArrayList<Weapons> weaponsList = new ArrayList<>();
    private ArrayList<Ammos> ammoList = new ArrayList<>();
    private ArrayList<Fuels> fuelList = new ArrayList<>();
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();
    private ArrayList<Medikit> mediKitList = new ArrayList<>();

    private static final String DATA_DIR = "StoredInBin/";
    private static final String USER_DATA_FILE = "StoredInBin/Users.bin";
    private static final String ADMIN_DATA_FILE = "StoredInBin/Administrators.bin";
    private static final String LOGISTIC_DATA_FILE = "StoredInBin/LogisticManagers.bin";
    private static final String COMMANDER_DATA_FILE = "StoredInBin/Commanders.bin";
    private static final String FIELD_OPERATIVE_DATA_FILE = "StoredInBin/FieldOperatives.bin";
    private static final String SNIPER_DATA_FILE = "StoredInBin/Snipers.bin";
    private static final String COMMUNICATION_OFFICER_DATA_FILE = "StoredInBin/CommunicationOfficers.bin";
    private static final String DEMOLITION_EXPERT_DATA_FILE = "StoredInBin/DemolitionExperts.bin";
    private static final String TEAM_DATA_FILE = "StoredInBin/Teams.bin";
    private static final String MISSION_DATA_FILE = "StoredInBin/Missions.bin";
    private static final String INVENTORY_DATA_FILE = "StoredInBin/Inventory.bin";
    private static final String WEAPONS_DATA_FILE = "StoredInBin/Weapons.bin";
    private static final String AMMO_DATA_FILE = "StoredInBin/Ammo.bin";
    private static final String FUEL_DATA_FILE = "StoredInBin/Fuel.bin";
    private static final String VEHICLE_DATA_FILE = "StoredInBin/Vehicles.bin";
    private static final String MEDIKIT_DATA_FILE = "StoredInBin/MediKits.bin";
    // Controllers
    private LogInViewController loginViewController;
    private AddNewUserController signUpViewController;

    @FXML
    public void initialize() {
        loadLoginView();
        new File(DATA_DIR).mkdirs(); // Ensure the data directory exists
        loadAllUsers();
        loadAdministrators();
        loadLogisticManagers();
//        createDemoUsers();
        displayAllSavedData();
    }



    private void loadAllUsers() {
        ArrayList<User> bkup = users;
        try {
            File file = new File(USER_DATA_FILE);
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                ArrayList<User> loadedUsers = (ArrayList<User>) ois.readObject();
                users.clear(); // Clear existing users before loading
                users.addAll(loadedUsers);
                ois.close();
//                System.out.println("MainController - LoadAllUsers");
//                System.out.println(users);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading users: " + e.getMessage());
            // Initialize with empty list if error occurs
            users = bkup;
        }
    }
    public void refreshUserData() {
        loadAllUsers();
        loadAdministrators();
        loadLogisticManagers();
    }

    @SuppressWarnings("unchecked")
    private void loadAdministrators() {
        loadUsersFromFile(ADMIN_DATA_FILE, Administrator.class);
    }

    @SuppressWarnings("unchecked")
    private void loadLogisticManagers() {
        loadUsersFromFile(LOGISTIC_DATA_FILE, LogisticManager.class);
    }

    private <T> void loadUsersFromFile(String filename, Class<T> clazz) {
        try {
            File file = new File(filename);
            if (file.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    ArrayList<T> loadedUsers = (ArrayList<T>) ois.readObject();
                    users.addAll((Collection<? extends User>) loadedUsers);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading " + clazz.getSimpleName() + "s: " + e.getMessage());
        }
    }

    public boolean saveUserToAllFiles(User user, Object roleSpecificUser ) {
        try {
            // Save to Users.bin
            saveUserToFile(USER_DATA_FILE, user);

            // Save to role-specific file
            if (roleSpecificUser  instanceof Administrator) {
                saveUserToFile(ADMIN_DATA_FILE, (Administrator) roleSpecificUser );
            } else if (roleSpecificUser  instanceof LogisticManager) {
                saveUserToFile(LOGISTIC_DATA_FILE, (LogisticManager) roleSpecificUser );
            } else if (roleSpecificUser  instanceof Commander) {
                saveUserToFile(COMMANDER_DATA_FILE, (Commander) roleSpecificUser );
            } else if (roleSpecificUser  instanceof FieldOperative) {
                saveUserToFile(FIELD_OPERATIVE_DATA_FILE, (FieldOperative) roleSpecificUser );
            } else if (roleSpecificUser  instanceof Medic) {
                saveUserToFile(MEDIKIT_DATA_FILE, (Medic) roleSpecificUser );
            } else if (roleSpecificUser  instanceof Sniper) {
                saveUserToFile(SNIPER_DATA_FILE, (Sniper) roleSpecificUser );
            } else if (roleSpecificUser  instanceof CommunicationOfficer) {
                saveUserToFile(COMMUNICATION_OFFICER_DATA_FILE, (CommunicationOfficer) roleSpecificUser );
            } else if (roleSpecificUser  instanceof DemolitionExpert) {
                saveUserToFile(DEMOLITION_EXPERT_DATA_FILE, (DemolitionExpert) roleSpecificUser );
            }

            return true;
        } catch (IOException e) {
            System.err.println("Error saving user data: " + e.getMessage());
            return false;
        }
    }

    private <T> void saveUserToFile(String filename, T user) throws IOException {
        ArrayList<T> usersList = loadAllUsersFromFile(filename);
        usersList.add(user);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(usersList);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> ArrayList<T> loadAllUsersFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading " + filename + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void displayAllSavedData() {
        System.out.println("\n=== ALL SAVED DATA ===");
        displayFileContents(USER_DATA_FILE, "All Users");
        displayFileContents(ADMIN_DATA_FILE, "Administrators");
        displayFileContents(LOGISTIC_DATA_FILE, "Logistic Managers");
    }

    @SuppressWarnings("unchecked")
    private void displayFileContents(String filename, String title) {
        System.out.println("\n--- " + title + " ---");
        try {
            ArrayList<Object> data = loadAllUsersFromFile(filename);
            if (data.isEmpty()) {
                System.out.println("No records found");
                return;
            }

            data.forEach(record -> {
                if (record instanceof User) {
                    User user = (User ) record;
                    System.out.println("ID: " + user.getId() + " | Name: " + user.getFullName() + " | Role: " + user.getRole());
                    if (record instanceof Administrator) {
                        Administrator admin = (Administrator) record;
                        System.out.println("   OfficeID: " + admin.getOfficeId() + " | Dept: " + admin.getDepartment());
                    } else if (record instanceof LogisticManager) {
                        LogisticManager lm = (LogisticManager) record;
                        System.out.println("   Warehouse: " + lm.getWareHouseAccessCode());
                    }
                }
            });
        } catch (Exception e) {
            System.err.println("Error displaying " + title + ": " + e.getMessage());
        }
    }

    // Other methods remain unchanged...

    public void setUsers(ArrayList<User> users) {
        this.users = new ArrayList<>(users);
    }

    public ArrayList<User> getUsers() {
        return new ArrayList<>(users);
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

    public User validateLogin(String inputUsername, String inputPassword) {
        for (User  user : users) {
            if (String.valueOf(user.getId()).equals(inputUsername) && user.getPassword().equals(inputPassword)) {
                return user;
            }
        }
        return null; // No match found
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
        if (isLoginVisible) {
            UserLoginOptionBTN.setText("Sign Up");
            AboutAccount.setText("Create new account?");
        } else {
            UserLoginOptionBTN.setText("Log In");
            AboutAccount.setText("Already have an account?");
        }
    }

    @FXML
    void UserLoginChoiceBTN(ActionEvent event) {
        if (UserLoginOptionBTN.getText().equals("Sign Up")) {
            loadSignUpView();
        } else {
            loadLoginView();
        }
    }
    // Access Code Getters/Setters
    public ArrayList<String> getAdminAccessCode() { return adminAccessCode; }
    public void setAdminAccessCode(ArrayList<String> adminAccessCode) { this.adminAccessCode = adminAccessCode; }
    public ArrayList<String> getWarehouseAccessCode() { return warehouseAccessCode; }
    public void setWarehouseAccessCode(ArrayList<String> warehouseAccessCode) { this.warehouseAccessCode = warehouseAccessCode; }
    public ArrayList<String> getCommunicatorOperatorAccessCode() { return communicatorOperatorAccessCode; }
    public void setCommunicatorOperatorAccessCode(ArrayList<String> communicatorOperatorAccessCode) { this.communicatorOperatorAccessCode = communicatorOperatorAccessCode; }

    // Data List Getters/Setters
    public ArrayList<Team> getTeamList() { return teamList; }
    public void setTeamList(ArrayList<Team> teamList) { this.teamList = teamList; }
    public ArrayList<Mission> getMissionList() { return missionList; }
    public void setMissionList(ArrayList<Mission> missionList) { this.missionList = missionList; }
    public ArrayList<Inventory> getInventoryList() { return inventoryList; }
    public void setInventoryList(ArrayList<Inventory> inventoryList) { this.inventoryList = inventoryList; }
    public ArrayList<Weapons> getWeaponsList() { return weaponsList; }
    public void setWeaponsList(ArrayList<Weapons> weaponsList) { this.weaponsList = weaponsList; }
    public ArrayList<Ammos> getAmmoList() { return ammoList; }
    public void setAmmoList(ArrayList<Ammos> ammoList) { this.ammoList = ammoList; }
    public ArrayList<Fuels> getFuelList() { return fuelList; }
    public void setFuelList(ArrayList<Fuels> fuelList) { this.fuelList = fuelList; }
    public ArrayList<Vehicle> getVehicleList() { return vehicleList; }
    public void setVehicleList(ArrayList<Vehicle> vehicleList) { this.vehicleList = vehicleList; }
    public ArrayList<Medikit> getMediKitList() { return mediKitList; }
    public void setMediKitList(ArrayList<Medikit> mediKitList) { this.mediKitList = mediKitList; }

    private void showAlert(String title, String message, Alert.AlertType X) {
        Alert alert = new Alert(X);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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

        int userCount = users.stream()
                .filter(u -> u.getRole().equalsIgnoreCase(selectedRole))
                .toList()
                .size();

        return prefix * 10000 + (userCount + 1);
    }

    public void createDemoUsers() {
        // Create demo users
        ArrayList<User> demoUsers = new ArrayList<>();

        // Define base ID for each role
        int baseId = 1000;

        // Create demo users for each type
        for (int i = 1; i <= 5; i++) {
            int adminID = generateUserID("Administrator");
            int commanderId = generateUserID("Commander") ;
            int FO = generateUserID("Field Operative") ;
            int Medic = generateUserID("Medic") ;
            int SniperID = generateUserID("Sniper") ;
            int CO = generateUserID("Communication Officer") ;
            int DemolutionID = generateUserID("Demolition Expert");

            // Create an Administrator
            Administrator admin = new Administrator(adminID, "12345678", "Admin User " + i, "admin.user" + i + "@example.com", "555-200" + i, "O+", "Male", "Administrator", "Active", 7000.0f, 2335,"Admin", Integer.toString(i) );
            demoUsers.add(admin);

            // Create a Commander
            Commander commander = new Commander(commanderId, "12345678", "Commander John " + i, "commander.john" + i + "@military.com", "555-201" + i, "O+", "Male", "Commander", "Active", 6000.0f, "TeamID" + i, "Badge" + i, "Tactical Operations", "TeamID" + i);
            demoUsers.add(commander);

            // Create a Field Operative
            FieldOperative fieldOperative = new FieldOperative(FO, "12345678", "Field Operative Alice " + i, "alice.field" + i + "@military.com", "555-202" + i, "A+", "Female", "Field Operative", "Active", 3500.0f, "TeamID" + i, "WeaponLicense" + i);
            demoUsers.add(fieldOperative);

            // Create a Medic
            Medic medic = new Medic(Medic, "12345678", "Medic Robert " + i, "robert.medic" + i + "@military.com", "555-203" + i, "B+", "Male", "Medic", "Active", 4000.0f, "MedLicense" + i);
            demoUsers.add(medic);

            // Create a Sniper
            Sniper sniper = new Sniper(SniperID, "12345678", "Sniper Emily " + i, "emily.sniper" + i + "@military.com", "555-204" + i, "AB+", "Female", "Sniper", "Active", 4500.0f, "SniperCertID" + i);
            demoUsers.add(sniper);

            // Create a Communication Officer
            CommunicationOfficer commOfficer = new CommunicationOfficer(CO, "12345678", "Comm Officer Michael " + i, "michael.comm" + i + "@military.com", "555-205" + i, "O-", "Male", "Communication Officer", "Active", 3700.0f, "RFCode" + i, "Encryption" + i, "TeamID" + i);
            demoUsers.add(commOfficer);

            // Create a Demolition Expert
            DemolitionExpert demolitionExpert = new DemolitionExpert(DemolutionID, "12345678", "Demolition Expert Sophia " + i, "sophia.demolition" + i + "@military.com", "555-206" + i, "A-", "Female", "Demolition Expert", "Active", 3800.0f, "ExplosivesLicense" + i);
            demoUsers.add(demolitionExpert);
        }

        // Save demo users to the binary file
        for (User  user : demoUsers) {
            saveUserToAllFiles(user, user); // Save user and role-specific user
        }

        System.out.println("Demo users created and saved successfully.");
    }



//    public void saveDemoData() {
//        // Create an inventory list
//        Inventory inventory = new Inventory();
//
//        // Create demo items
//        inventory.addItem(new Ammos("Ammo", "9mm Bullet", "New", "AMMO001", 0.50, 100, 9.0f));
//        inventory.addItem((new Ammos("Ammo", "5.56mm Bullet", "New", "AMMO002", 0.75, 200, 5.56f));
//        inventory.addItem((new Ammos("Ammo", "7.62mm Bullet", "New", "AMMO003", 1.00, 150, 7.62f));
//        inventory.addItem((new Fuels("Fuel", "Gasoline", "New", "FUEL001", 2.50, 500, new ArrayList<vehicle>(Arrays.asList("Car", "Truck"))));
//        inventory.addItem((new Fuels("Fuel", "Diesel", "New", "FUEL002", 2.80, 300, new ArrayList<>(Arrays.asList("Truck", "Generator"))));
//        inventory.addItem((new Fuels("Fuel", "Jet Fuel", "New", "FUEL003", 3.00, 200, new ArrayList<>(Arrays.asList("Airplane"))));
//        inventory.addItem((new Medikit("Medical Kit", "First Aid Kit", "New", "MED001", 25.00, 50, new ArrayList<>(Arrays.asList("Bandages", "Antiseptic"))));
//        inventory.addItem((new Medikit("Medical Kit", "Trauma Kit", "New", "MED002", 50.00, 30, new ArrayList<>(Arrays.asList("Tourniquet", "Gauze"))));
//        inventory.addItem((new Vehicle("Vehicle", "Humvee", "Operational", "VEH001", 50000.00, 10, "Military", 12345));
//        inventory.addItem((new Vehicle("Vehicle", "Tank", "Operational", "VEH002", 300000.00, 5, "Military", 67890));
//        inventory.addItem((new Vehicle("Vehicle", "Ambulance", "Operational", "VEH003", 150000.00, 8, "Emergency", 54321));
//        inventory.addItem((new Weapons("Weapon", "M4 Carbine", "Operational", "WEAP001", 1200.00, 15, "Assault Rifle", "5.56mm"));
//        inventory.addItem((new Weapons("Weapon", "M16 Rifle", "Operational", "WEAP002", 1000.00, 20, "Assault Rifle", "5.56mm"));
//        inventory.addItem((new Weapons("Weapon", "AK-47", "Operational", "WEAP003", 900.00, 25, "Assault Rifle", "7.62mm"));
//
//        // Save all items to a single binary file
//        saveToFile(inventory.getItems(), "StoredInBin/inventory.bin");
//    }
//
//    private void saveToFile(ArrayList<InventoryItems> inventory, String filename) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
//            oos.writeObject(inventory);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}