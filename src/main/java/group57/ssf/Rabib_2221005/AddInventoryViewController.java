package group57.ssf.Rabib_2221005;

import group57.ssf.InventoryCollection.Inventory;
import group57.ssf.InventoryCollection.InventoryItems;
import group57.ssf.MainController;
import group57.ssf.UserClasses.User;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.*;
import java.util.ArrayList;

public class AddInventoryViewController
{
    @javafx.fxml.FXML
    private TextField ManageInventory_Edit_Model;
    @javafx.fxml.FXML
    private AnchorPane ManageInventory_MainContainer;
    @javafx.fxml.FXML
    private ComboBox<String> ManageInventory_Add_Condition;
    @javafx.fxml.FXML
    private ComboBox<String> ManageInventory_Edit_Condition;
    @javafx.fxml.FXML
    private TextField ManageInventory_Add_Price;
    @javafx.fxml.FXML
    private Pane ManageInventory_AddView;
    @javafx.fxml.FXML
    private TextField ManageInventory_Add_Quantity;
    @javafx.fxml.FXML
    private ComboBox<String> ManageInventory_Edit_ItemType;
    @javafx.fxml.FXML
    private TextField ManageInventory_Add_ItemID;
    @javafx.fxml.FXML
    private Pane ManageInventory_EditView;
    @javafx.fxml.FXML
    private TextField ManageInventory_Edit_Quantity;
    @javafx.fxml.FXML
    private TextField ManageInventory_Edit_Price;
    @javafx.fxml.FXML
    private ComboBox<String> ManageInventory_Add_ItemType;
    @javafx.fxml.FXML
    private TextField ManageInventory_Add_Model;
    @javafx.fxml.FXML
    private TextField ManageInventory_Edit_ItemID;
    private Inventory inventory;

    private MainController mainController;
    public void setMainController(MainController mainController, User user) {
        this.mainController = mainController;
}

    @javafx.fxml.FXML
    public void initialize() {
        ManageInventory_AddView.setVisible(false); // Initially hide add view
        ManageInventory_EditView.setVisible(false); // Initially hide edit view
        inventory = new Inventory();
    }

    @javafx.fxml.FXML
    public void ShowAddItemView(ActionEvent actionEvent) {
        ManageInventory_AddView.setVisible(true); // Show add view
        ManageInventory_EditView.setVisible(false); // Hide edit view

    }

    @javafx.fxml.FXML
    public void AddItemToInventory(ActionEvent actionEvent) {
        String category = ManageInventory_Add_ItemType.getValue();
        String model = ManageInventory_Add_Model.getText();
        String status = ManageInventory_Add_Condition.getValue();
        String serialNumber = ManageInventory_Add_ItemID.getText();
        double price = Double.parseDouble(ManageInventory_Add_Price.getText());
        int quantity = Integer.parseInt(ManageInventory_Add_Quantity.getText());

        // Create a new InventoryItem
        InventoryItems newItem = new InventoryItems(category, model, status, serialNumber, price, quantity);
        inventory.addItem(newItem);

        // Save the updated inventory to the file
        saveInventoryItems();

        // Clear fields after adding
        clearAddFields();
    }

    @javafx.fxml.FXML
    public void ManageInventory_Edit_FindItem(ActionEvent actionEvent) {
        String serialNumber = ManageInventory_Edit_ItemID.getText();
        InventoryItems item = inventory.findItemBySerial(serialNumber);
        if (item != null) {
            ManageInventory_Edit_Model.setText(item.getModel());
            ManageInventory_Edit_Quantity.setText(String.valueOf(item.getQuantity()));
            ManageInventory_Edit_Price.setText(String.valueOf(item.getPrice()));
            ManageInventory_Edit_Condition.setValue(item.getStatus());
        } else {
            // Handle item not found case
            System.out.println("Item not found.");
        }
    }

    @javafx.fxml.FXML
    public void ManageInventory_Edit_ExistingItem(ActionEvent actionEvent) {
        String serialNumber = ManageInventory_Edit_ItemID.getText();
        InventoryItems item = inventory.findItemBySerial(serialNumber);
        if (item != null) {
            // Update item details
            item.setModel(ManageInventory_Edit_Model.getText());
            item.setQuantity(Integer.parseInt( ManageInventory_Edit_Quantity.getText()));
            item.setPrice(Double.parseDouble(ManageInventory_Edit_Price.getText()));
            item.setStatus(ManageInventory_Edit_Condition.getValue());

            // Save the updated inventory to the file
            saveInventoryItems();

            // Clear fields after editing
            clearEditFields();
        } else {
            // Handle item not found case
            System.out.println("Item not found.");
        }
    }

    @javafx.fxml.FXML
    public void ShowEditItemView(ActionEvent actionEvent) {
        ManageInventory_AddView.setVisible(false); //  hide add view
        ManageInventory_EditView.setVisible(true); //  Show edit view

    }
    private void clearAddFields() {
        ManageInventory_Add_ItemID.clear();
        ManageInventory_Add_Model.clear();
        ManageInventory_Add_Quantity.clear();
        ManageInventory_Add_Price.clear();
        ManageInventory_Add_Condition.setValue(null);
        ManageInventory_Add_ItemType.setValue(null);
    }

    private void clearEditFields() {
        ManageInventory_Edit_ItemID.clear();
        ManageInventory_Edit_Model.clear();
        ManageInventory_Edit_Quantity.clear();
        ManageInventory_Edit_Price.clear();
        ManageInventory_Edit_Condition.setValue(null);
    }

    private void saveInventoryItems() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("inventory.dat"))) {
            oos.writeObject(inventory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadInventoryItems() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("inventory.dat"))) {
            inventory = (Inventory) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}