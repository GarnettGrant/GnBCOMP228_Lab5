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
import javafx.stage.Modality;
import javafx.stage.Stage;
import cbinetsheriff_garnettgrant_comp228_lab5.DatabaseController;
import cbinetsheriff_garnettgrant_comp228_lab5.Player;

/* Window for editing and updating player information */

public class EditUser_Stage extends Stage {

    public EditUser_Stage(Stage parentStage, Player selectedPlayer) {
        super();
        Scene scene = new Scene(new VBox(), 300, 250);
        setTitle("Edit User: " + selectedPlayer.getFirstName());
        Stage thisStage = this;

        VBox root = ((VBox) scene.getRoot());

        //Build cbinetsheriff_garnettgrant_comp228_lab5.UI for player fields
        HBox fNameRow = new HBox();
        Label fNameLabel = new Label("First Name :");
        fNameLabel.setPrefWidth(90);
        fNameLabel.setAlignment(Pos.CENTER_RIGHT);
        TextField fNameTextField = new TextField(selectedPlayer.getFirstName());
        fNameRow.getChildren().add(fNameLabel);
        fNameRow.getChildren().add(fNameTextField);

        HBox lNameRow = new HBox();
        Label lNameLabel = new Label("Last Name :");
        lNameLabel.setPrefWidth(90);
        lNameLabel.setAlignment(Pos.CENTER_RIGHT);
        TextField lNameTextField = new TextField(selectedPlayer.getLastName());
        lNameRow.getChildren().add(lNameLabel);
        lNameRow.getChildren().add(lNameTextField);

        HBox addressRow = new HBox();
        Label addressLabel = new Label("Address :");
        addressLabel.setPrefWidth(90);
        addressLabel.setAlignment(Pos.CENTER_RIGHT);
        TextField AddressTextField = new TextField(selectedPlayer.getAddress());
        addressRow.getChildren().add(addressLabel);
        addressRow.getChildren().add(AddressTextField);

        HBox postalRow = new HBox();
        Label postalLabel = new Label("Postal Code :");
        postalLabel.setPrefWidth(90);
        postalLabel.setAlignment(Pos.CENTER_RIGHT);
        TextField PostalTextField = new TextField(selectedPlayer.getPostal_Code());
        postalRow.getChildren().add(postalLabel);
        postalRow.getChildren().add(PostalTextField);

        HBox provinceRow = new HBox();
        Label provinceLabel = new Label("Province:");
        provinceLabel.setPrefWidth(90);
        provinceLabel.setAlignment(Pos.CENTER_RIGHT);
        TextField ProvinceTextField = new TextField(selectedPlayer.getProvince());
        provinceRow.getChildren().add(provinceLabel);
        provinceRow.getChildren().add(ProvinceTextField);

        HBox phoneRow = new HBox();
        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.setPrefWidth(90);
        phoneLabel.setAlignment(Pos.CENTER_RIGHT);
        TextField PhoneTextField = new TextField(selectedPlayer.getPhone());
        phoneRow.getChildren().add(phoneLabel);
        phoneRow.getChildren().add(PhoneTextField);

        root.getChildren().add(fNameRow);
        root.getChildren().add(lNameRow);
        root.getChildren().add(addressRow);
        root.getChildren().add(postalRow);
        root.getChildren().add(provinceRow);
        root.getChildren().add(phoneRow);

        //Update Button Logic
        Button updateButton = new Button("Update");
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedPlayer.setFirstName( fNameTextField.getText());
                selectedPlayer.setLastName(lNameTextField.getText());
                selectedPlayer.setAddress( AddressTextField.getText());
                selectedPlayer.setPostal_Code(PostalTextField.getText());
                selectedPlayer.setProvince(ProvinceTextField.getText());
                selectedPlayer.setPhone(PhoneTextField.getText());

                DatabaseController.UpdatePlayer(selectedPlayer);

                thisStage.close();
                parentStage.setScene(new UserSelect_Scene(parentStage));
            }
        });
        root.getChildren().add(updateButton);

        //Make window operate like a message box
        initOwner(parentStage);
        setScene(scene);
        initModality(Modality.APPLICATION_MODAL);
        showAndWait();
    }
}
