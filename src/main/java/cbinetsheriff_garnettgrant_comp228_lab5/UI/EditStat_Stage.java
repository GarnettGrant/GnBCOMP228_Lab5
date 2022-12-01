package cbinetsheriff_garnettgrant_comp228_lab5.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import cbinetsheriff_garnettgrant_comp228_lab5.DatabaseController;
import cbinetsheriff_garnettgrant_comp228_lab5.GameStat;
import cbinetsheriff_garnettgrant_comp228_lab5.Player;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditStat_Stage extends Stage {

    public EditStat_Stage(Stage parentStage, GameStat stat, Player selectedPlayer){
        super();
        Scene scene = new Scene(new HBox(), 550, 60);
        setTitle(stat.toString());
        Stage thisStage = this;

        HBox root = ((HBox) scene.getRoot());

        Label l = new Label("Score: ");
        TextField txfScore = new TextField();
        txfScore.setText( Double.toString(stat.Score) );

        DatePicker datePicker = new DatePicker();
        datePicker.setValue( LocalDate.parse(stat.getPlayDate(),DateTimeFormatter.ofPattern("yyyy-MM-dd")));



        Button UpdateButton = new Button("Update Score");
        UpdateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stat.Score = Double.parseDouble( txfScore.getText());
                DatabaseController.UpdateStat(stat);
                parentStage.setScene(new EditUser_Scene(selectedPlayer,parentStage ));
                thisStage.close();
            }
        });

        Button DeleteButton = new Button("Delete Score");
        DeleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseController.DeleteStat(stat);
                parentStage.setScene(new EditUser_Scene(selectedPlayer,parentStage ));
                thisStage.close();
            }
        });

        root.getChildren().add(l);
        root.getChildren().add(txfScore);
        root.getChildren().add(datePicker);
        root.getChildren().add(UpdateButton);
        root.getChildren().add(DeleteButton);



        initOwner(parentStage);
        setScene(scene);
        initModality(Modality.APPLICATION_MODAL);
        showAndWait();
    }
}
