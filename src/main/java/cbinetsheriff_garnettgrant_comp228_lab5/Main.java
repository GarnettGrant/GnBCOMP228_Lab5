package cbinetsheriff_garnettgrant_comp228_lab5;

import cbinetsheriff_garnettgrant_comp228_lab5.UI.UserSelect_Scene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new UserSelect_Scene(primaryStage));
        primaryStage.show();
    }


    public static void main(String[] args) {

        DatabaseController.testFetch();

        launch(args);
    }
}
