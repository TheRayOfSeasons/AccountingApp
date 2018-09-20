package Java;

import Objects.Credit;
import Objects.Debit;
import Pages.CashReceiptsRegister;
import Pages.OrR;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Scenes
{

    public static Scene CashReceiptsRegisterLayout ()
    {
        return new CashReceiptsRegister().GetScene();
    }

    public static Scene ORLayout ()
    {
        return new OrR().GetScene();
    }



    public static Scene testScene ()
    {
        Button button = new Button();
        button.setText("Submit");
        button.setOnAction(e -> Events.wow());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        return scene;
    }
}
