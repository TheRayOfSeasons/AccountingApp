package Java;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AlertBox
{
    public static void NumOnly ()
    {
        ConstructWindow("Input numbers only.");
    }

    public static void Empty ()
    {
        ConstructWindow("Please fill up all fields.");
    }

    private static void ConstructWindow (String message)
    {
        Stage alertWindow = new Stage();

        alertWindow.initModality(Modality.APPLICATION_MODAL);
        alertWindow.setTitle("Alert");
        alertWindow.setMinWidth(250);

        Label label = new Label();
        label.setText(message);

        Button closeWindow = new Button();
        closeWindow.setText("Ok");
        closeWindow.setOnAction(e -> alertWindow.close());

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(label, closeWindow);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene (layout);
        alertWindow.setScene(scene);
        alertWindow.show();
    }
}
