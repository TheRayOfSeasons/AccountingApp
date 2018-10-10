package Pages;

import Java.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConfirmData
{
    private TextArea
        display;

    private Label
        header;

    private Button
        commit;

    private VBox mainLayout;

    //TODO finish this page
    public ConfirmData () {}

    public Scene GetScene ()
    {
        SetupLayouts();
        SetupContents();

        Scene scene = new Scene(mainLayout, Initialize.StandardWindowMinWidth(), Initialize.StandardWindowMinHeight());
        return scene;
    }

    private void SetupLayouts ()
    {
        mainLayout = new VBox(20);
        Initialize.StandardVBOX(mainLayout);
    }

    private void SetupContents ()
    {
        header = new Label();
        header.setText("Confirm input?");

        display = new TextArea();
        display.setMinWidth(400);
        display.setMinHeight(400);
        display.setDisable(true);

        commit = new Button();
        commit.setText("Commit");
        commit.setOnAction(event -> Commit());

        if (FillForm.cashReceiptA.isFull())
            display.setText(FillForm.PrintReceiptA());
        else
            System.out.println("Insufficient Data");

        HBox bottomLayer = new HBox(20);
        Initialize.StandardHBOX(bottomLayer);
        bottomLayer.setAlignment(Pos.CENTER_RIGHT);
        bottomLayer.getChildren().add(commit);

        mainLayout.getChildren().addAll(header, display, bottomLayer);
    }

    private void Commit ()
    {
        FillForm.InsertToDatabase();
        AlertBox.InsertSuccess();
        Events.SwitchSceneTo(Scenes.MainMenuLayout());
    }

}
