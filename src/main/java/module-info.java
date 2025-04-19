module group57.ssf {
    requires javafx.controls;
    requires javafx.fxml;


    opens group57.ssf to javafx.fxml;
    opens group57.ssf.UserClasses to javafx.fxml;
    opens group57.ssf.Kobita_2130178_W to javafx.fxml;
    opens group57.ssf.Rabib_2221005 to javafx.fxml;
    opens group57.ssf.Safin_1921111 to javafx.fxml;
    opens group57.ssf.Saida_2220179 to javafx.fxml;
    opens group57.ssf.nonUser to javafx.fxml;
    opens group57.ssf.InventoryCollection to javafx.fxml;

    exports group57.ssf;
    exports group57.ssf.UserClasses;
    exports group57.ssf.Rabib_2221005;
    exports group57.ssf.Kobita_2130178_W;
    exports group57.ssf.Saida_2220179;
    exports group57.ssf.Safin_1921111;
    exports group57.ssf.nonUser;
    exports group57.ssf.InventoryCollection;
}