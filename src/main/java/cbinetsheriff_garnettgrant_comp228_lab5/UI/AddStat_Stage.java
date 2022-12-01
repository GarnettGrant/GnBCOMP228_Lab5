package cbinetsheriff_garnettgrant_comp228_lab5.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import cbinetsheriff_garnettgrant_comp228_lab5.DatabaseController;
import cbinetsheriff_garnettgrant_comp228_lab5.Game;
import cbinetsheriff_garnettgrant_comp228_lab5.GameStat;
import cbinetsheriff_garnettgrant_comp228_lab5.Player;

import java.time.LocalDate;


//Add stat window
public class    AddStat_Stage extends Stage {

    //constructor
    public AddStat_Stage(Stage parentStage, Player selectedPlayer){
        super();
        Scene scene = new Scene(new HBox(), 550, 60);
        setTitle("Add new game stat");
        Stage thisStage = this;

        //build ui objects
        HBox root = ((HBox) scene.getRoot());
        ChoiceBox<Game> gameChoiceBox = new ChoiceBox<>();
        gameChoiceBox.getItems().setAll(DatabaseController.games);

        root.getChildren().add(gameChoiceBox);

        TextField scoreTextField = new TextField();
        scoreTextField.setPromptText("Score");
        root.getChildren().add(scoreTextField);

        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        root.getChildren().add(datePicker);

        Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                GameStat newStat = new GameStat(selectedPlayer.getID(), gameChoiceBox.getValue().getID(), datePicker.getValue().toString(), Double.parseDouble(scoreTextField.getText()) );
                DatabaseController.InsertStat(newStat);
                parentStage.setScene(new EditUser_Scene(selectedPlayer,parentStage));
                thisStage.close();
            }
        });
        root.getChildren().add(addButton);
        Button cancel = new Button("Cancel");
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                thisStage.close();
            }
        });
        root.getChildren().add(cancel);

//        show();
        initOwner(parentStage);
        setScene(scene);
        initModality(Modality.APPLICATION_MODAL);
        showAndWait();
    }

}
