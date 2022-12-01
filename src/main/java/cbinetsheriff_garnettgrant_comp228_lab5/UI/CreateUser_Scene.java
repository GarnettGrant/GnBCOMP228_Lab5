package cbinetsheriff_garnettgrant_comp228_lab5.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import cbinetsheriff_garnettgrant_comp228_lab5.DatabaseController;
import cbinetsheriff_garnettgrant_comp228_lab5.Player;


//Create user scene. Changes window contents to enter in new user fields.

public class CreateUser_Scene extends Scene {

    TextField fNameTextField;
    TextField lNameTextField;

    public CreateUser_Scene(Stage primaryStage){

        super(new VBox(), 300, 300);
        VBox root = (VBox)getRoot();
        primaryStage.setTitle("Create User");

        HBox fNameRow = new HBox();
        Label fNameLabel = new Label("First Name :");
        fNameLabel.setPrefWidth(90);
        fNameLabel.setAlignment(Pos.CENTER_RIGHT);
        fNameTextField = new TextField();
        fNameRow.getChildren().add(fNameLabel);
        fNameRow.getChildren().add(fNameTextField);

        HBox lNameRow = new HBox();
        Label lNameLabel = new Label("Last Name :");
        lNameLabel.setPrefWidth(90);
        lNameLabel.setAlignment(Pos.CENTER_RIGHT);
        lNameTextField = new TextField();
        lNameRow.getChildren().add(lNameLabel);
        lNameRow.getChildren().add(lNameTextField);

        HBox addressRow = new HBox();
        Label addressLabel = new Label("Address :");
        addressLabel.setPrefWidth(90);
        addressLabel.setAlignment(Pos.CENTER_RIGHT);
        TextField addressTextField = new TextField();
        addressRow.getChildren().add(addressLabel);
        addressRow.getChildren().add(addressTextField);

        HBox postalRow = new HBox();
        Label postalLabel = new Label("Postal Code :");
        postalLabel.setPrefWidth(90);
        postalLabel.setAlignment(Pos.CENTER_RIGHT);
        TextField postalTextField = new TextField();
        postalRow.getChildren().add(postalLabel);
        postalRow.getChildren().add(postalTextField);

        HBox provinceRow = new HBox();
        Label provinceLabel = new Label("Province:");
        provinceLabel.setPrefWidth(90);
        provinceLabel.setAlignment(Pos.CENTER_RIGHT);
        TextField provinceTextField = new TextField();
        provinceRow.getChildren().add(provinceLabel);
        provinceRow.getChildren().add(provinceTextField);

        HBox phoneRow = new HBox();
        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.setPrefWidth(90);
        phoneLabel.setAlignment(Pos.CENTER_RIGHT);
        TextField phoneTextField = new TextField();
        phoneRow.getChildren().add(phoneLabel);
        phoneRow.getChildren().add(phoneTextField);

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new UserSelect_Scene(primaryStage));
            }
        });

        Button createButton = new Button("Create");
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Player newPlayer = new Player(fNameTextField.getText(), lNameTextField.getText(), addressTextField.getText(),postalTextField.getText(),provinceTextField.getText(),phoneTextField.getText());
                DatabaseController.InsertPlayer(newPlayer);

                primaryStage.setScene(new UserSelect_Scene(primaryStage));
            }
        });

        HBox buttonRow = new HBox();
        buttonRow.getChildren().add(cancelButton);
        buttonRow.getChildren().add(createButton);
        root.getChildren().add(fNameRow);
        root.getChildren().add(lNameRow);
        root.getChildren().add(addressRow);
        root.getChildren().add(postalRow);
        root.getChildren().add(provinceRow);
        root.getChildren().add(phoneRow);

        root.getChildren().add(buttonRow);

    }
}
