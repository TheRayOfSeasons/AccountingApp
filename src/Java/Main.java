package Java;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
    Stage stage;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        Events.stage = primaryStage;
        primaryStage.setTitle("Cash Register");
        primaryStage.setScene(Scenes.ORLayout());
        primaryStage.show();
    }
}

