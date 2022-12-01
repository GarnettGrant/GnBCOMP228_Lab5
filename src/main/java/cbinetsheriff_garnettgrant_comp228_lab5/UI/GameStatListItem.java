package cbinetsheriff_garnettgrant_comp228_lab5.UI;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import cbinetsheriff_garnettgrant_comp228_lab5.GameStat;

public class GameStatListItem extends HBox {
GameStatListItem listItem;
GameStat stat;
    public GameStatListItem(GameStatList parentList, GameStat stat){
        this.stat = stat;
        listItem = this;
        System.out.print("create list item");
        Label title = new Label();
        Label score = new Label();
        Label playDate = new Label();
        title.setText(stat.toString());
        title.setPrefWidth(160);
        score.setText(Double.toString(stat.Score));
        score.setPrefWidth(160);

        playDate.setText(stat.PlayDate.toString());
        playDate.setPrefWidth(160);

        getChildren().add(title);
        getChildren().add(score);
        getChildren().add(playDate);
        setPrefWidth(100);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                parentList.Deselect();
                parentList.Select(listItem);
            }
        });
    }

    public void Select(){
        setStyle("-fx-background-color: dodgerblue");

    }

    public void Deselect(){
        setStyle("-fx-background-color: none");


    }

}
