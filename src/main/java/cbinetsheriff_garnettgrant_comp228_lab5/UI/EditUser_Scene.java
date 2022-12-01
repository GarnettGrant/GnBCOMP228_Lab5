package cbinetsheriff_garnettgrant_comp228_lab5.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import cbinetsheriff_garnettgrant_comp228_lab5.Player;


public class EditUser_Scene extends Scene {

    Player SelectedPlayer;
    public EditUser_Scene(Player selectedPlayer, Stage primarystage){
        super(new HBox(), 750,300);
        primarystage.setTitle("User: " + selectedPlayer.getFirstName());
        SelectedPlayer = selectedPlayer;
        HBox root = (HBox)getRoot();

        HBox topControls = new HBox();
        VBox GameStatsContainer = new VBox();
        GameStatsContainer.getChildren().add(new Label("Game List"));
        GameStatList gameStatList = new GameStatList(SelectedPlayer);

        GameStatsContainer.getChildren().add(gameStatList);

        HBox statsButtonsBox = new HBox();

        Button createStatButton = new Button("Add game");
        createStatButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new AddStat_Stage(primarystage, SelectedPlayer);
            }
        });
        Button editStatButton = new Button("Edit game");
        editStatButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new EditStat_Stage(primarystage, gameStatList.selectedItem.stat, selectedPlayer);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });

        statsButtonsBox.getChildren().add(createStatButton);
        statsButtonsBox.getChildren().add(editStatButton);
        GameStatsContainer.getChildren().add(statsButtonsBox);

        topControls.getChildren().add(GameStatsContainer);

        VBox UserDetails = new VBox();
        UserDetails.getChildren().add( new Label("First Name:  " + SelectedPlayer.getFirstName()));
        UserDetails.getChildren().add( new Label("Last Name:   " + SelectedPlayer.getLastName()));
        UserDetails.getChildren().add( new Label("Address:     " + SelectedPlayer.getAddress()));
        UserDetails.getChildren().add( new Label("Postal Code: " + SelectedPlayer.getPostal_Code()));
        UserDetails.getChildren().add( new Label("Province:    " + SelectedPlayer.getProvince()));
        UserDetails.getChildren().add( new Label("Phone Number:" + SelectedPlayer.getPhone()));

        root.getChildren().add(topControls);
        root.getChildren().add(UserDetails);

        Button editUserButton = new Button("Edit User");
        editUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new EditUser_Stage(primarystage, SelectedPlayer );
            }
        });

        Button logOUtButton = new Button("Log Out");
        logOUtButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primarystage.setScene( new UserSelect_Scene(primarystage));
            }
        });
        UserDetails.getChildren().add(editUserButton);
        UserDetails.getChildren().add(logOUtButton);
    }

}
