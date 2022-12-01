module com.example.binetsheriff_garnettgrant_comp228_lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires ojdbc6;


    opens cbinetsheriff_garnettgrant_comp228_lab5 to javafx.fxml;
    exports cbinetsheriff_garnettgrant_comp228_lab5;
    exports cbinetsheriff_garnettgrant_comp228_lab5.UI;
    opens cbinetsheriff_garnettgrant_comp228_lab5.UI to javafx.fxml;
}