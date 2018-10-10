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
        DatabaseHandler.InitiateDatabase();
        DatabaseHandler.AddDataINTINCA("101", "120", 1000);
        DatabaseHandler.AddDataSavingsDepositA("101", "120", 1000);
        DatabaseHandler.AddDataTimeDepositA("101", "120", 1000);
        primaryStage.setTitle("Cash Register");
        primaryStage.setScene(Scenes.MainMenuLayout());
        primaryStage.show();
    }
}

